FROM openjdk:11 as builder

COPY gradlew ./
COPY gradle gradle
COPY build.gradle ./
COPY settings.gradle ./
COPY src src
RUN chmod +x ./gradlew
RUN ./gradlew clean build -x test


FROM openjdk:11

WORKDIR /app

# builder 이미지에서 build/libs/*.jar 파일을 ./app.jar로 복사
COPY --from=builder build/libs/*.jar ./app.jar

ENTRYPOINT ["java","-jar","./app.jar"]