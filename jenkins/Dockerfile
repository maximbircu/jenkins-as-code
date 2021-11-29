FROM jenkins/jenkins:latest

################################################################################
### JENKINS SETUP
################################################################################

# Disable Jenkins Startup Wizard
ARG CASC_RELOAD_TOKEN
ENV JAVA_OPTS "-Dhudson.Main.development=true -Djenkins.install.runSetupWizard=false"
ENV JENKINS_JAVA_OPTIONS "-Dcasc.reload.token=${CASC_RELOAD_TOKEN}"

################################################################################
### PLUGINS & TOOLS SETUP
################################################################################

USER root
RUN apt-get update
RUN apt-get install -y unzip wget

# Install Jenkins plugins
COPY configurations/plugins.txt /var/configurations/plugins.txt
RUN /usr/local/bin/install-plugins.sh < /var/configurations/plugins.txt

# Setup Android SDK
COPY tools/install-android-sdk.sh /install-android-sdk.sh
RUN /install-android-sdk.sh

###############################################################################
## GENERAL ENVIRONMENT VARIABLES
###############################################################################

ENV JENKINS_URL http://localhost:8080/
ENV JENKINS_ADMIN_USER_NAME admin
ENV JENKINS_ADMIN_USER_PASSWORD admin
