#!/usr/bin/env bash
echo "Started watching Jenkins"
echo "user: $JENKINS_USERNAME"
echo "url: $JENKINS_URL"
fswatch -o --event OwnerModified configurations jobs | while read;
do
    # Copy configuration files to the container
    docker cp configurations/ jenkins:/ && echo "Config files copied successfully."

    # Copy jobs dsl files to the container
    docker cp jobs/ jenkins:/ && echo "Job config files copied successfully."

    # Reload configuration files in jenkins
    curl -X POST \
        "${JENKINS_URL}configuration-as-code/reload/?casc-reload-token=$CASC_RELOAD_TOKEN" \
        --user ${JENKINS_USERNAME}:${JENKINS_API_TOKEN} && printf "New config reloaded!\n\n"
done
