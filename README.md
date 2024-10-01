
# MindShift - Automation Testing Project

## Overview
MindShift is an automation testing project that showcases the use of Selenium WebDriver for testing the core functionalities of the OrangeHRM application. This project includes two main tasks:

1. **Task 1**: Basic automation for logging in to the OrangeHRM application using hardcoded credentials.
2. **Task 2**: Data-driven testing for the login functionality using external CSV files for multiple test scenarios.

## Table of Contents
- [Features](#features)
- [Prerequisites](#prerequisites)
- [Getting Started](#getting-started)
- [Usage](#usage)
- [Directory Structure](#directory-structure)
- [Contributing](#contributing)
- [License](#license)

## Features
- **Task 1**: Automates the login functionality on the OrangeHRM application using predefined credentials.
- **Task 2**: Implements data-driven testing, allowing multiple login scenarios with different usernames and passwords from a CSV file.
- Utilizes XPath for locating web elements.

## Prerequisites
To run this project, ensure you have the following installed:
- **Java Development Kit (JDK)**: Version 8 or higher.
- **Apache Maven**: For managing dependencies (if applicable).
- **Google Chrome**: The latest version of the Chrome browser.
- **ChromeDriver**: The appropriate version for your Chrome browser. Ensure it is added to your system PATH or specify its location in the code.

## Getting Started
1. **Clone the Repository**:
   ```bash
   git clone https://github.com/yourusername/mindshift.git
   cd mindshift
   ```

2. **Set Up ChromeDriver**:
   - Download the ChromeDriver executable from [ChromeDriver Download](https://chromedriver.chromium.org/downloads).
   - Set the path to the ChromeDriver in the Java code for both tasks:
     ```java
     System.setProperty("webdriver.chrome.driver", "C:\\Path\\To\\Your\\chromedriver.exe");
     ```

3. **Prepare the Test Data for Task 2**:
   - Create a CSV file named `testdata.csv` in your desired location with the following structure:
     ```csv
     username,password
     Admin,admin123
     User1,password1
     User2,password2
     ```
   - Update the path to the CSV file in the code:
     ```java
     new FileReader("C:\\Users\\YourUsername\\Downloads\\testdata.csv");
     ```

4. **Compile and Run the Project**:
   - If using Maven, run the following command in your project directory:
     ```bash
     mvn clean install
     ```
   - To run each Java program, execute:
     ```bash
     // For Task 1
     java -cp target/mindshift.jar Internship.Task1

     // For Task 2
     java -cp target/mindshift.jar Internship.Task2
     ```

## Usage
- **Task 1**: The program will log in to the OrangeHRM application using hardcoded credentials.
- **Task 2**: The program will read login credentials from the `testdata.csv` file and attempt to log in to the OrangeHRM application with each set of credentials.

## Directory Structure
```
mindshift/
│
├── src/
│   └── main/
│       └── java/
│           ├── Internship/
│           │   ├── Task1.java
│           │   └── Task2.java
│
├── testdata.csv
└── README.md
```

## Contributing
Feel free to contribute to this project. You can fork the repository, make changes, and submit a pull request.

## License
This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

---

### Notes:
- Replace `https://github.com/yourusername/mindshift.git` with the actual URL of your GitHub repository.
- Adjust paths and instructions based on your project setup and structure.
- Ensure to keep the README updated with any changes you make to the project or its structure.
