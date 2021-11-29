multibranchPipelineJob('android-app-multibranch-pipeline') {
    displayName "android-app-multibranch-pipeline"
    description "Demo Counter Android App"
    factory {
        workflowBranchProjectFactory {
            scriptPath('android-app/.jenkins/Jenkinsfile.groovy')
        }
    }
    configure {
        it / sources / 'data' / 'jenkins.branch.BranchSource' << {
            source(class: 'org.jenkinsci.plugins.github_branch_source.GitHubSCMSource') {
                id(UUID.randomUUID().toString())
                credentialsId("github-http")
                repository("jenkins-as-code")
                repositoryUrl(System.getenv("ANDROID_APP_REPOSITORY_URL"))
                traits {
                    'org.jenkinsci.plugins.github_branch_source.BranchDiscoveryTrait'()
                    'org.jenkinsci.plugins.github_branch_source.ForkPullRequestDiscoveryTrait'()
                    'org.jenkinsci.plugins.github_branch_source.TagDiscoveryTrait'()
                    'jenkins.scm.impl.trait.WildcardSCMHeadFilterTrait' {
                        includes('*')
                        excludes('alpha-* beta-*')
                    }
                    'jenkins.plugins.git.traits.RefSpecsSCMSourceTrait' {
                        templates {
                            'jenkins.plugins.git.traits.RefSpecsSCMSourceTrait_-RefSpecTemplate' {
                                value('+refs/heads/*:refs/remotes/@{remote}/*')
                            }
                        }
                    }
                }
            }
        }
    }
}
