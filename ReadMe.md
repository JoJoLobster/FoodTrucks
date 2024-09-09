# Getting Started

## Project Structure

Environment: windows

Node18+, pnpm, Java22, Maven version 3.6.3 is required for generation and recommended for development

`/backend/*` back end with Java22, Maven, SpringMvc, Apache Common CSV.

`/frontend/*` front end with Nodejs, React18, NextJs14

## Build and run

We use maven and maven wrapper to manage the java libs and use npm scripts and Nextjs default tools as our build front end system.

You can start the back end service with follow script

>Tips: You need replace the JAVA_HOME and MAVEN_HOME with your JDK installation directory.
```
cd ../backend
set JAVA_HOME=C:/software/Java/jdk22.0.2_9
set MAVEN_HOME=C:/software/apache-maven-3.9.1
%MAVEN_HOME%/bin/mvn clean package
cd target
%JAVA_HOME%/bin/java -jar demo-0.0.1-SNAPSHOT.jar

```

You can start the front end service with follow script
```
cd frontend
./pnpm install
./pnpm run dev
```

## Web UI CLI Guidence

Then navigate to [http://localhost:3000](http://localhost:3000) in your browser.

You can click the search button directly to get all food trucks.

After a city name or a food name inputed and click the search button you will get items as you choosed.

## Points need improve

1. The search with city api load all data and filter in memory which is not effective
2. The web ui may not good and need some third part lib to display more ideally


### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/3.3.3/maven-plugin)
* [Create an OCI image](https://docs.spring.io/spring-boot/3.3.3/maven-plugin/build-image.html)
* [Spring Web](https://docs.spring.io/spring-boot/docs/3.3.3/reference/htmlsingle/index.html#web)
* [Next.js](https://nextjs.org) project bootstrapped with [`create-next-app`](https://nextjs.org/docs/app/api-reference/cli/create-next-app).