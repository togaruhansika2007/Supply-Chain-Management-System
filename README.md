Supply Chain Management System (Java Swing + MySQL)
🚀 Project Overview

This is a Java-based Desktop Application for managing supply chain operations. It provides a simple and interactive GUI to handle Products, Suppliers, and Orders with database connectivity using MySQL.

The system follows a layered architecture:

UI Layer (Swing GUI)
Service Layer
DAO Layer
Database Layer (MySQL)
✨ Features
🔐 Login Authentication System
📦 Product Management (CRUD)
🏭 Supplier Management (CRUD)
🛒 Order Management (CRUD)
📊 Database Integration using JDBC
🎨 Simple and Colorful Java Swing UI
🔗 Foreign Key Relationship between Product & Orders
🧱 Tech Stack
Java (JDK 17)
Swing (GUI)
JDBC
MySQL
Eclipse / VS Code
📁 Project Structure

src/
├── ui/         → GUI Screens (Login, Dashboard, Product, Supplier, Order)
├── dao/        → Database Access Layer
├── service/    → Business Logic Layer
├── model/      → POJO Classes
├── db/         → DB Connection Class

🗄️ Database Schema
Product Table
id INT PRIMARY KEY AUTO_INCREMENT
name VARCHAR(100)
price DOUBLE
Supplier Table
id INT PRIMARY KEY AUTO_INCREMENT
name VARCHAR(100)
phone VARCHAR(50)
Orders Table
id INT PRIMARY KEY AUTO_INCREMENT
product_id INT (FK → product.id)
quantity INT
⚙️ Setup Instructions
1. Clone the Repository
git clone https://github.com/your-username/supply-chain-management.git
2. Import Project
Open in Eclipse / IntelliJ / VS Code
Add JDBC MySQL Connector JAR
3. Setup Database
Create MySQL database:
CREATE DATABASE supply_chain;
Import tables using schema above
4. Configure DB Connection

Update:

username = "root";
password = "your_password";
5. Run Project

Start from:

ui.LoginGUI
🔐 Login Credentials (Default)
Username: admin
Password: admin123
⚠️ Known Behavior
Order creation requires valid Product ID (foreign key constraint)
Suppliers and Products must exist before creating dependent records
📌 Future Improvements
Dropdown-based Order creation (remove manual ID entry)
Better UI (JavaFX / React frontend upgrade)
Reports & Analytics dashboard
Search & filter functionality
👨‍💻 Author

Developed as a learning project for:

Java OOP concepts
JDBC database integration
GUI development using Swing
Layered architecture design
⭐ If you like this project

Give it a ⭐ on GitHub and feel free to improve it!
