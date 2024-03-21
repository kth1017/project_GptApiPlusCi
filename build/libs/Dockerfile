FROM openjdk:11

# 환경변수 지정
ARG JAR_FILE=*.jar

# copy시 상대 경로 사용
COPY build/libs/${JAR_FILE} /app.jar

ENTRYPOINT ["java","-jar","/app.jar"]
