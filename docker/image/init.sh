#!/bin/bash 
GIT_REPO=https://github.com/czechp/bsp-weight-monitoring-backend.git
git clone $GIT_REPO /JavaProject
cd JavaProject
mvn clean install package -DskipTests
java -jar /JavaProject/core/target/bsp-weight-monitoring.jar --spring.datasource.username=weight-monitoring --spring.datasource.password=weight-monitoring123 --spring.profiles.active=production 
