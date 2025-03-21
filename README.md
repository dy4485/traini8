# traini8

# Getting Started

### Reference Documentation
For further reference, please consider the following sections:

Traini8 Project - Setup Guide (Spring Tool Suite + MySQL)
This guide provides detailed step-by-step instructions to set up and run the Traini8 project using Spring Tool Suite (STS) and MySQL.

🛠 Prerequisites
Before starting, ensure you have the following installed on your system:

🔹 Required Software
✅ Java Development Kit (JDK) 17+
✅ Spring Tool Suite (STS) or IntelliJ IDEA
✅ Maven (included in STS)
✅ MySQL Server & MySQL Workbench


🏗 1. Open the Project in Spring Tool Suite
1️ Open Spring Tool Suite (STS).
2️ Click on File → Import.
3️ Select Existing Maven Projects → Click Next.
4️ Browse to the traini8 project folder → Click Finish.
5️ Wait for Maven dependencies to download.

📂 2. Configure MySQL Database
🔹 Step 1: Create a Database in MySQL

1️ Open MySQL Workbench or command prompt.

2️ Run the following SQL query to create the database:
CREATE DATABASE traini8;

3️ Create a MySQL user and grant permissions (optional, if needed):

CREATE USER 'traini8_user'@'localhost' IDENTIFIED BY 'password';
GRANT ALL PRIVILEGES ON traini8_db.* TO 'traini8_user'@'localhost';
FLUSH PRIVILEGES;

⚙️ 4. Configure application.properties for MySQL
Open src/main/resources/application.properties and update the database settings:


# Spring Boot Application Properties

# MySQL Configuration
spring.datasource.url=jdbc:mysql://localhost:3306/traini8_db?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC
spring.datasource.username=traini8_user
spring.datasource.password=password
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

# Hibernate Configuration
spring.jpa.database-platform=org.hibernate.dialect.MySQL8Dialect
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

# Connection Pooling (HikariCP)
spring.datasource.hikari.minimum-idle=5
spring.datasource.hikari.maximum-pool-size=10
spring.datasource.hikari.idle-timeout=30000
spring.datasource.hikari.max-lifetime=60000

▶️ 5. Run the Project
1️⃣ In Spring Tool Suite (STS), open the Traini8Application.java file.
2️⃣ Right-click and select Run As → Spring Boot App.
3️⃣ The application will start, and you should see:


Tomcat started on port(s): 4500 
Started Traini8Application in 5.123 seconds (JVM running for 6.456)


🔗 6. Test the APIs Using Postman

📌 API: Add a Training Center

Method: POST
URL: http://localhost:4500
Headers:

Content-Type: application/json
Request Body (JSON):json

data in Json
{
  "centerName": "AI Training Hub",
  "centerCode": "ABC123456789",
  "address": {
    "detailedAddress": "123, Main Road",
    "city": "Mumbai",
    "state": "Maharashtra",
    "pincode": "400001"
  },
  "studentCapacity": 200,
  "coursesOffered": ["AI", "Machine Learning", "Data Science"],
  "contactEmail": "contact@traini8.com",
  "contactPhone": "9876543210"
}
📌 API: Get All Training Centers
Method: GET
URL: http://localhost:4500
Response (if data exists):json

[
  {
    "centerName": "AI Training Hub",
    "centerCode": "ABC123456789",
    "address": {
      "detailedAddress": "123, Main Road",
      "city": "Mumbai",
      "state": "Maharashtra",
      "pincode": "400001"
    },
    "studentCapacity": 200,
    "coursesOffered": ["AI", "Machine Learning", "Data Science"],
    "contactEmail": "contact@traini8.com",
    "contactPhone": "9876543210"
  }
  .....
]

Response (if no data exists):[]
