# Embloy Java

Embloy's Java SDK for interacting with your Embloy integration.

## Usage

Add Embloy-Java SDK:

```Java title="build.gradle"
/*
  For Gradle, add the following dependency to your build.gradle and replace with
  the version number you want to use from:
  - https://mvnrepository.com/artifact/com.embloy/sdk or
  - https://github.com/embloy/embloy-java/releases/latest
*/
implementation "com.embloy:sdk:0.1.6"
```

```Java title="build.gradle.kts"
/*
  For Gradle with Kotlin, add the following dependency to your build.gradle.kts and replace with
  the version number you want to use from:
  - https://mvnrepository.com/artifact/com.embloy/sdk or
  - https://github.com/embloy/embloy-java/releases/latest
*/
implementation("com.embloy:sdk:0.1.6")
```

```XML title="pom.xml"
<!--
  For Maven, add the following dependency to your POM and replace with the
  version number you want to use from:
  - https://mvnrepository.com/artifact/com.embloy/sdk or
  - https://github.com/embloy/embloy-java/releases/latest
-->
<dependency>
  <groupId>com.embloy</groupId>
  <artifactId>sdk</artifactId>
  <version>0.1.6</version>
</dependency>
```

Integrate it in your service:

```Java title="main.java"
import embloy.EmbloyClient;
import embloy.EmbloySession;

public class ExampleClass {
    public static void exampleEndpoint() {
        // Replace these values with your actual client token and session data
        String clientToken = "your-client-token";

        EmbloySession session = new EmbloySession(EmbloySession.EmbloyRequestMode.JOB_MODE, "your-job-slug", "your-success-url", "your-cancel-url");

        EmbloyClient embloyClient = new EmbloyClient(clientToken, session);

        try {
            String applyUrl = embloyClient.makeRequest();
            System.out.println("Redirect URL: " + applyUrl);
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
```

## Build package from source

```Bash
javac src/main/java/embloy/EmbloyClient.java src/main/java/embloy/EmbloySession.java

mvn clean install # you'll be prompted to insert your gpg key passphrase

mvn release:clean release:prepare release:perform

mvn clean deploy # or alternatively mvn clean deploy -P release
```

---

© Carlo Bortolan, Jan Hummel

> Carlo Bortolan &nbsp;&middot;&nbsp;
> GitHub [@carlobortolan](https://github.com/carlobortolan) &nbsp;&middot;&nbsp;
> contact via [bortolanoffice@embloy.com](mailto:bortolanoffice@embloy.com)
>
> Jan Hummel &nbsp;&middot;&nbsp;


