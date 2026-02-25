# PasswordUtils

### General details

> _PasswordUtils is a Java utility library focused on password generation and strength evaluation, based on entropy calculation and brute-force attack models commonly used in cryptographic security analysis._
> 
> _In the 1.0 version it has PassPhrassed utilities and PasswordGenerator, security tools from password entropy calculations and brute-force attack models commonly used in cryptographic security analysis._

**Language used** ![Java](https://shields.io/badge/Java-red)

***Folder tree:***
```
📂passwordutils
 ┣ 📂datasources
 ┃ ┣ 📄Dictionary.java
 ┃ ┣ 📄LowerCaseLetter.java
 ┃ ┣ 📄Symbol.java
 ┃ ┣ 📄UpperCaseLetter.java
 ┣ 📂generators
 ┃  ┣ 📄PassPhrassedGenerator.java
 ┃  ┣ 📄PasswordGenerator.java
 ┣ 📂analysis
 ┃ ┣ 📄EntropyTools.java
 ┃ ┣ 📄StrengthTools.java
 ┣ 📄TimeUtils.java
 ┣ 📂crypto
 ┃ ┣ 📄SaltManager.java
```

***Instalation***:
------------
The instalation of that API is througth a .jar file named SessionSecures.jar.

<img width="324" height="34" alt="image" src="https://github.com/user-attachments/assets/85a83e2d-3eb4-4d1e-a809-ffa3080cb7c5" />

***1. Prerequisites***
------------------
Before starting, make sure you have Java Runtime Environment (JRE) or Java Development Kit (JDK) version 17 or higher installed (adjust the version accordingly).

To verify this, run the following command in your terminal: `java -version`

***2. Instalation***
------------------

Copy the .jar file to a folder (for example, libs/) within your project.

Add the file to your IDE's Build Path:

**IntelliJ:** File > Project Structure > Modules > Dependencies > + > JARs or Directories.

**Eclipse:** Right-click project > Build Path > Configure Build Path > Libraries > Add External JARs.

**VSCode**: Open the Java view: In the left sidebar of VS Code, look for the coffee cup icon or expand the "Java Projects" section at the bottom of the file browser. Locate Referenced Libraries: Look for the folder called "Referenced Libraries." Add the JAR: Click the + (Plus) icon to the right of "Referenced Libraries." Select File: Locate your .jar file in your file browser and click "Select JAR Libraries."



