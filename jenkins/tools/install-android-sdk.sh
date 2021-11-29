#!/bin/sh

######################################
# Install Android SDK
######################################
wget -O android-sdk.zip "https://dl.google.com/android/repository/commandlinetools-linux-7583922_latest.zip"
unzip android-sdk.zip -d /android-sdk
mkdir -p /android-sdk/cmdline-tools/latest
mv /android-sdk/cmdline-tools/* /android-sdk/cmdline-tools/latest
ls /android-sdk
rm android-sdk.zip

######################################
# Licenses and tools
######################################

echo "y" | /android-sdk/cmdline-tools/latest/bin/sdkmanager --licenses
echo "y" | /android-sdk/cmdline-tools/latest/bin/sdkmanager "patcher;v4"

# Platforms
echo "y" | /android-sdk/cmdline-tools/latest/bin/sdkmanager "platforms;android-30"

# Build tools
echo "y" | /android-sdk/cmdline-tools/latest/bin/sdkmanager "build-tools;30.0.2"
