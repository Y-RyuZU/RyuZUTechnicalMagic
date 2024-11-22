FROM gradle:8-jdk17 as build

WORKDIR /app

COPY . /app
RUN gradle build

RUN ls ./build/libs/

RUN git clone https://github.com/Y-RyuZU/RyuZUTechnicalMagicDependenciesAndConfig.git
WORKDIR /app/RyuZUTechnicalMagicDependenciesAndConfig/build
RUN find . -name '*.sh' -exec sh {} \;

FROM openjdk:17-slim

RUN apt-get update && apt-get install -y curl jq git

WORKDIR /app

COPY ./docker/download-papermc.sh .
RUN sh download-papermc.sh

RUN echo "eula=false" > eula.txt

COPY --from=build /app/RyuZUTechnicalMagicDependenciesAndConfig/plugins ./plugins

COPY ./docker/start-papermc.sh .
CMD ["sh", "start-papermc.sh"]

COPY --from=build /app/build/libs/RyuZUTechnicalMagicCore.jar ./plugins/app.jar
RUN git clone https://github.com/Y-RyuZU/RyuZUTechnicalMagic.git