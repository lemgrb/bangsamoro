# How to

## Run TESTNG test in command line 

```bash
$ mvn test -DsuiteXmlFile=-DsuiteXmlFile=src/test/resources/com.lemsst.bangsamoro.test/LoginTest
```

`-D` stands for **DEFINE** and `suiteXmlFile` refer to this code in POM.XML:

```XML
    <build>
        <plugins>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-surefire-plugin</artifactId>
                <configuration>
                    <suiteXmlFiles>
                        <suiteXmlFile>${suiteXmlFile}</suiteXmlFile>
                    </suiteXmlFiles>
                </configuration>
            </plugin>
        </plugins>
    </build>
```

## Run Cucumber-TestNG

```Bash
$ c
```