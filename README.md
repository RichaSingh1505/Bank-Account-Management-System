#  Bank Management System

A desktop-based Bank Management System built with **Java (Swing) and MySQL**, simulating core ATM and banking operations through a full graphical user interface — including a 3-step account registration, secure login, deposits, withdrawals, and transaction tracking.

---

##  Features

- **Secure Login** — Card number + PIN authentication validated against MySQL database
- **3-Step Account Registration** — Complete new account signup across 3 form pages:
  - Page 1: Personal details (name, DOB, gender, address, marital status)
  - Page 2: Additional details (religion, category, income, education, occupation, PAN, Aadhar)
  - Page 3: Account type selection, auto-generated 16-digit card number & 4-digit PIN, services selection
- **Transaction Dashboard** — ATM-style interface with options for Deposit, Withdrawal, Fast Cash, Mini Statement, PIN Change, and Balance Check
- **Deposit** — Add funds to account with real-time MySQL transaction recording
- **Withdrawal** — Withdraw funds with live balance check and insufficient funds validation (max ₹10,000 per transaction)
- **Auto Card & PIN Generation** — Unique 16-digit card number and 4-digit PIN generated randomly on signup completion
- **ATM-Style UI** — Custom ATM background image across all transaction screens for realistic look and feel
- **Services Selection** — Choose from ATM Card, Internet Banking, Mobile Banking, and Email Alerts during signup

---

##  Tech Stack

| Layer | Technology |
|---|---|
| Language | Java (JDK 8+) |
| GUI | Java Swing, AWT |
| Database | MySQL, JDBC (mysql-connector-java) |
| Date Picker | JCalendar (com.toedter.calendar) |
| IDE | Eclipse |

---

##  Project Structure

```
BankManagementSystem/
│
└── src/bank/
    ├── ConnectionFactory.java   # MySQL JDBC connection setup
    ├── Login.java               # Login screen — card number + PIN auth
    ├── Signup.java              # Signup Page 1 — personal details
    ├── SignupTwo.java           # Signup Page 2 — additional details
    ├── SignupThree.java         # Signup Page 3 — account type & card generation
    ├── Transactions.java        # ATM transaction menu dashboard
    ├── Deposit.java             # Deposit funds screen
    └── Withdrawl.java          # Withdrawal funds screen with balance check
```

---

##  Database Schema

### Database: `bankmanagement`

### `signup` table — Personal Details (Page 1)
| Column | Type | Description |
|---|---|---|
| formno | VARCHAR | Auto-generated unique form number |
| name | VARCHAR | Customer full name |
| fname | VARCHAR | Father's name |
| gender | VARCHAR | Male / Female |
| email | VARCHAR | Email address |
| dob | VARCHAR | Date of birth |
| maritalstatus | VARCHAR | Married / Unmarried / Others |
| address | VARCHAR | Residential address |
| city | VARCHAR | City |
| pincode | VARCHAR | Area pin code |
| state | VARCHAR | State |

### `signuptwo` table — Additional Details (Page 2)
| Column | Type | Description |
|---|---|---|
| formno | VARCHAR | References signup form number |
| religion | VARCHAR | Religion |
| category | VARCHAR | General / SC / ST / OBC / Others |
| income | VARCHAR | Income range |
| education | VARCHAR | Educational qualification |
| occupation | VARCHAR | Salaried / Self-Employed / Others |
| pan | VARCHAR | PAN number |
| aadhar | VARCHAR | Aadhar number |
| seniorcitizen | VARCHAR | Yes / No |
| existingaccount | VARCHAR | Yes / No |

### `signupthree` table — Account Details (Page 3)
| Column | Type | Description |
|---|---|---|
| formno | VARCHAR | References signup form number |
| accounttype | VARCHAR | Savings / Fixed Deposit / Current / Recurring |
| cardnumber | VARCHAR | Auto-generated 16-digit card number |
| pin | VARCHAR | Auto-generated 4-digit PIN |
| facility | VARCHAR | Selected banking services |

### `login` table — Auth Credentials
| Column | Type | Description |
|---|---|---|
| formno | VARCHAR | References signup form number |
| cardnumber | VARCHAR | 16-digit card number |
| pin | VARCHAR | 4-digit PIN |

### `bank` table — Transaction Records
| Column | Type | Description |
|---|---|---|
| pin | VARCHAR | Card PIN (account identifier) |
| date | VARCHAR | Transaction timestamp |
| type | VARCHAR | `Deposit` or `Withdrawl` |
| amount | VARCHAR | Transaction amount |

---

##  Getting Started

### Prerequisites
- JDK 8 or above
- MySQL (local)
- Eclipse IDE (recommended)
- `mysql-connector-java` JAR
- `JCalendar` JAR (`jcalendar-1.4.jar` or higher)

### 1. Clone the Repository
```bash
git clone https://github.com/your-username/BankManagementSystem.git
```

### 2. Setup MySQL Database

Open MySQL and run:
```sql
CREATE DATABASE bankmanagement;
USE bankmanagement;

CREATE TABLE signup (
    formno VARCHAR(20),
    name VARCHAR(50),
    fname VARCHAR(50),
    gender VARCHAR(10),
    email VARCHAR(50),
    dob VARCHAR(20),
    maritalstatus VARCHAR(20),
    address VARCHAR(100),
    city VARCHAR(30),
    pincode VARCHAR(10),
    state VARCHAR(30)
);

CREATE TABLE signuptwo (
    formno VARCHAR(20),
    religion VARCHAR(20),
    category VARCHAR(20),
    income VARCHAR(30),
    education VARCHAR(30),
    occupation VARCHAR(30),
    pan VARCHAR(20),
    aadhar VARCHAR(20),
    seniorcitizen VARCHAR(5),
    existingaccount VARCHAR(5)
);

CREATE TABLE signupthree (
    formno VARCHAR(20),
    accounttype VARCHAR(40),
    cardnumber VARCHAR(20),
    pin VARCHAR(10),
    facility VARCHAR(100)
);

CREATE TABLE login (
    formno VARCHAR(20),
    cardnumber VARCHAR(20),
    pin VARCHAR(10)
);

CREATE TABLE bank (
    pin VARCHAR(10),
    date VARCHAR(50),
    type VARCHAR(20),
    amount VARCHAR(20)
);
```

### 3. Configure Database Connection

In `ConnectionFactory.java`, update your MySQL credentials:
```java
con = DriverManager.getConnection(
    "jdbc:mysql://localhost:3306/bankmanagement",
    "root",
    "your_password"    // ← update this
);
```

### 4. Add Required JARs to Build Path (Eclipse)

Right-click project → **Build Path** → **Add External JARs** → add:
- `mysql-connector-java-x.x.x.jar`
- `jcalendar-x.x.jar`

### 5. Run the Application

Run `Login.java` as the entry point:
```
Right-click Login.java → Run As → Java Application
```

---

##  Application Flow

```
Login Page
    │
    ├── Existing User → Enter Card Number + PIN → Transaction Dashboard
    │                                                      │
    │                                         ┌────────────┼────────────┐
    │                                      Deposit    Withdrawal    Exit
    │
    └── New User → Signup Page 1 (Personal Details)
                        │
                   Signup Page 2 (Additional Details)
                        │
                   Signup Page 3 (Account Type + Card Generation)
                        │
                   Auto-generated Card Number & PIN displayed
                        │
                   Transaction Dashboard
```

---

## Screens Overview
<img width="417" height="258" alt="image" src="https://github.com/user-attachments/assets/96886f07-603d-4f53-b3fd-62fbd9bb95c0" />
<img width="487" height="435" alt="image" src="https://github.com/user-attachments/assets/d338b9da-a7fa-4a8f-99be-985c990330f6" />
<img width="513" height="437" alt="image" src="https://github.com/user-attachments/assets/15c89755-35f1-49d8-81dd-2b5f76ccccdb" />
<img width="541" height="507" alt="image" src="https://github.com/user-attachments/assets/4b05322c-4e37-4f68-ab60-205b984dd25c" />
<img width="584" height="497" alt="image" src="https://github.com/user-attachments/assets/6b79fcd5-ca7b-4177-a809-58118c60fd86" />
<img width="582" height="501" alt="image" src="https://github.com/user-attachments/assets/9bea0718-c925-4641-b825-1dfd5ef9bc07" />

