# NovaWallet Spring 💸

NovaWallet is a Spring Boot Web Application that simulates e-wallet functionalities, allowing users to perform various operations related to fund management and currency transactions. 
While this application provides a comprehensive simulation, it's important to note that it is intended for educational and demonstration purposes only.

---

### Features 💁
- **Responsive Design:** Fully responsive site with a modern and simple design.
- **User Registration and Login:** Users can register their accounts and log in securely to access their e-wallet functionalities.
- **Password encryption:** Passwords are stored safely using Spring Security's authentication and authorization.
- **Fund Management:**
  - *Deposit Funds:* Users can add funds to their e-wallet accounts.
  - *Withdraw Funds:* Users can withdraw funds from their e-wallet accounts.
  - *Transfer Funds:* Users can transfer funds between accounts within the simulation.
- **Balance Inquiry:** Users can check their account balances to track their funds.
- **MySQL connection:** Information is stored on a MySQL database.
- **Javadocs and Unit Tests:** The application includes Javadocs for code documentation and unit tests using JUnit and Mockito for ensuring code quality and reliability.

### Getting Started 🚀
To run NovaWallet Spring on your local machine, follow these steps:

1. Clone the repository to your local environment.
2. Ensure that MySQL Server is running and that you have a valid MySQL connection on the default port (3306).
3. Download the MySQL script found on the root of the project ([script.sql](https://github.com/sara-rioseco/nova-wallet-spring/blob/main/script.sql)) and run it to create database and to insert dummy data.
4. Open the project in your preferred Java IDE and make sure to modify the datasource user and password using your own credentials.
5. Compile and run the project as a Spring Boot Project.
6. Go to [http://localhost:8080/login](http://localhost:8080/login) and log in, or press the SignUp option to register.

### Requirements 💻
- Java Development Kit (JDK) version 21 or higher.
- Java IDE (Eclipse, IntelliJ IDEA, etc.) for development.
- MySQL Server running on your machine
- MySQL Workbench or other method for running MySQL scripts
- Git for cloning the repository (optional).

### Technologies Used 📖
- Maven
- Spring Framework
- Spring Security
- MySQL
- JUnit
- Mockito
  
### Usage 💰
Upon running the application, you will be presented with login screen. From there you can login or go to Sign up and create an account. 
After you enter the site you can perform various wallet operations, such as deposit, withdrawals and transfer to your contacts. 
Click on the different menu options to interact with the simulation and explore its features.

### License 🔑
This project is licensed under the MIT License - see the LICENSE file for details.

---
*This project was developed by Sara Rioseco as part of the FullStack Java Bootcamp by Talento Digital, Chile. June 2024*
