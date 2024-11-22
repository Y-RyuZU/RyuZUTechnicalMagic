#! /bin/sh

if [ "$EULA" = "true" ]; then
    echo "eula=true" > eula.txt
else
    echo "Please accept the EULA by setting the EULA environment variable to true"
    exit 1
fi

java -jar paper.jar

