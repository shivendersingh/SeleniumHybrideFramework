# Page Object Model (POM) Framework

## Overview

This repository contains a Page Object Model (POM) framework for SeleniumHybrideFramework, designed to streamline automated testing for web applications. The POM design pattern enhances test maintenance and improves readability by separating test logic from page-specific actions.

## Features

- **Modular Structure**: Each page of the application is represented by a separate class, promoting code reusability and organization.
- **Easy Maintenance**: Changes in the UI require minimal updates in the corresponding page class.
- **Readability**: Test scripts are clear and easy to understand, focusing on test logic rather than UI interactions.
- **Data-Driven Testing**: Supports integration with data sources for parameterized tests.
- **Cross-Browser Testing**: Capable of running tests across multiple browsers with minimal configuration.
- ** Data Driven
- ** GeneicUtils(ElementUtils,ExcelUtils,Cnstants,ErrorUtils)
- ** Infrastructure Setup
## **Report(Allure)**
![Allure Report](assets/images/AllureReportImage.png)
- ## **'Infrastructure setup for allure report'**

-Make sure Scoop is installed [ See the installation instructions on GitHub.](https://github.com/ScoopInstaller/Install#readme)

1 Make sure Java version 8 or above installed, and its directory is specified in the JAVA_HOME environment variable.

2 In a terminal, run this command:
```xml
scoop install allure
```
3 Run this command to see if it reports the latest version:
```xml
allure --version
```
- ## **To generate the Report**
```xml
allure generate allure-results --clean
```
- ## **To serve the report locally (this starts a local server):**

- Add 'Framework Dependency' and 'Maven Surefire Plugin' Information to the POM File as below-
```xml
		<dependency>
			<groupId>io.qameta.allure</groupId>
			<artifactId>allure-testng</artifactId>
			<version>2.13.2</version>
		</dependency>

		<dependency>
			<groupId>javax.xml.bind</groupId>
			<artifactId>jaxb-api</artifactId>
			<version>2.3.1</version>
		</dependency>
```
```xml
<plugins>
			<plugin>
				<groupId>org.apache.maven.plugins</groupId>
				<artifactId>maven-compiler-plugin</artifactId>
				<version>3.8.1</version>
				<configuration>
					<source>11</source>
					<target>11</target>
				</configuration>
			</plugin>

			<plugin>
				<groupId>org.apache.maven.plugins</groupId>
				<artifactId>maven-surefire-plugin</artifactId>
				<version>3.0.0-M7</version>

				<configuration>
					<forkCount>3</forkCount>
					<reuseForks>true</reuseForks>
					<argLine>-Xmx1024m</argLine>
					<suiteXmlFiles>
						<suiteXmlFile>
							src/test/resources/testrunners/testng_regression.xml</suiteXmlFile>
						<!-- <suiteXmlFile>${suiteXmlFile}</suiteXmlFile> -->
					</suiteXmlFiles>

					<argLine>
						-javaagent:"${settings.localRepository}/org/aspectj/aspectjweaver/${aspectj.version}/aspectjweaver-${aspectj.version}.jar"
					</argLine>
				</configuration>
				<dependencies>
					<dependency>
						<groupId>org.aspectj</groupId>
						<artifactId>aspectjweaver</artifactId>
						<version>${aspectj.version}</version>
					</dependency>
				</dependencies>

			</plugin>

		</plugins>
```

## **Report(Extent)**
![Extent Report](assets/images/extent_report.png)
- Add 'Framework Dependency' and 'Maven Surefire Plugin' Information to the POM File as below-
```xml
		<dependency>
			<groupId>com.aventstack</groupId>
			<artifactId>extentreports</artifactId>
			<version>5.1.2</version>
		</dependency>
```
```xml
<build>
		<plugins>
			<plugin>
				<groupId>org.apache.maven.plugins</groupId>
				<artifactId>maven-compiler-plugin</artifactId>
				<version>3.8.1</version>
				<configuration>
					<source>11</source>
					<target>11</target>
				</configuration>
			</plugin>

			<plugin>
				<groupId>org.apache.maven.plugins</groupId>
				<artifactId>maven-surefire-plugin</artifactId>
				<version>2.20</version>

				<configuration>
					<forkCount>3</forkCount>
					<reuseForks>true</reuseForks>
					<suiteXmlFiles>
						<suiteXmlFile>
							<add your runner suite path></suiteXmlFile>
						<!-- <suiteXmlFile>${suiteXmlFile}</suiteXmlFile> -->
					</suiteXmlFiles>


				</configuration>

			</plugin>

		</plugins>


	</build>
```
- 'Adding listeners in runner' 
```xml

	<listeners>
		<listener
			class-name="com.qa.opencart.listerns.ExtentReportListener" />
	</listeners>
```
##Command to run the suite through maven
- mvn clean install
- mvn clean install -Denv="<provide your desire environment>"

## Getting Started

### Prerequisites

- Java (1.8)
- Maven (4.0.0)
- WebDriver (ChromeDriver, GeckoDriver, etc.)


### Installation

1. Clone the repository:

  git clone https://github.com/shivendersingh/SeleniumHybrideFramework.git
  