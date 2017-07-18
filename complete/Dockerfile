FROM frolvlad/alpine-oraclejdk8:slim
VOLUME /tmp
COPY target/dependency/org /app/org
COPY target/dependency/BOOT-INF/lib /app/BOOT-INF/lib
COPY target/dependency/META-INF /app/META-INF
COPY target/dependency/BOOT-INF/classes /app/BOOT-INF/classes
ENV JAVA_OPTS=""
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -cp app -Djava.security.egd=file:/dev/./urandom org.springframework.boot.loader.JarLauncher" ]
