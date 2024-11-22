#! /bin/sh

PROJECT="paper"
MINECRAFT_VERSION="1.20.4"

LATEST_BUILD=$(curl -s https://api.papermc.io/v2/projects/${PROJECT}/versions/${MINECRAFT_VERSION}/builds | \
    jq -r '.builds | map(select(.channel == "default") | .build) | .[-1]')

JAR_NAME=${PROJECT}-${MINECRAFT_VERSION}-${LATEST_BUILD}.jar

PAPERMC_URL="https://api.papermc.io/v2/projects/${PROJECT}/versions/${MINECRAFT_VERSION}/builds/${LATEST_BUILD}/downloads/${JAR_NAME}"

curl ${PAPERMC_URL} -o paper.jar

