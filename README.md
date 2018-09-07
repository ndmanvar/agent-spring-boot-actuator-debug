# agent-spring-boot-actuator-debug

To run:

```
mvn package && java -agentpath:/Users/neilmanvar/git/getsentry/sentry-java/agent/libsentry_agent.dylib -Dsentry.dsn=https://<SENTRY_DSN>@sentry.io/<PROJ_ID>  -Dsentry.stacktrace.app.packages=com.example.sb2actuatorservice -jar /Users/neilmanvar/Downloads/sb2-actuator-service/target/sb2-actuator-service-0.0.1-SNAPSHOT.jar
```
