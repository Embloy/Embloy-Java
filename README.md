# Embloy Java

Embloy's Java SDK for interacting with your Embloy integration.

## Usage

Add Embloy-Java SDK:

```Java title="build.gradle"
/*
  For Gradle, add the following dependency to your build.gradle and replace with
  the version number you want to use from:
  - https://mvnrepository.com/artifact/com.embloy/embloy-java or
  - https://github.com/embloy/embloy-java/releases/latest
*/
implementation "com.embloy:embloy-java:24.0.0"
```

```XML title="pom.xml"
<!--
  For Maven, add the following dependency to your POM and replace with the
  version number you want to use from:
  - https://mvnrepository.com/artifact/com.embloy/embloy-java or
  - https://github.com/embloy/embloy-java/releases/latest
-->
<dependency>
  <groupId>com.embloy</groupId>
  <artifactId>embloy-java</artifactId>
  <version>24.0.0</version>
</dependency>
```

Integrate it in your service:

```Java title="main.java"
javac -cp .:lib main.java && java -cp .:lib main

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

```Java
javac lib/embloy/EmbloyClient.java lib/embloy/EmbloySession.java
```

---

© Carlo Bortolan, Jan Hummel

> Carlo Bortolan &nbsp;&middot;&nbsp;
> GitHub [@carlobortolan](https://github.com/carlobortolan) &nbsp;&middot;&nbsp;
> contact via [bortolanoffice@embloy.com](mailto:bortolanoffice@embloy.com)
>
> Jan Hummel &nbsp;&middot;&nbsp;


