#!/bin/sh
cd $(dirname $0)

cd ../complete

./mvnw clean package
ret=$?
if [ $ret -ne 0 ]; then
exit $ret
fi
rm -rf target

./mvnw spring-boot:build-image
ret=$?
if [ $ret -ne 0 ]; then
exit $ret
fi
rm -rf target

./gradlew build
ret=$?
if [ $ret -ne 0 ]; then
exit $ret
fi
rm -rf build

./gradlew bootBuildImage
ret=$?
if [ $ret -ne 0 ]; then
exit $ret
fi
rm -rf build

cd ../initial

./mvnw clean compile
ret=$?
if [ $ret -ne 0 ]; then
exit $ret
fi
rm -rf target

./gradlew compileJava
ret=$?
if [ $ret -ne 0 ]; then
exit $ret
fi
rm -rf build

exit
