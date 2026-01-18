Blog Application Backend
Project Description
This project is a comprehensive Backend API for a blogging platform where users can create, read, update, and delete (CRUD) blog posts and articles,. The system is designed to handle multiple users, categorized content, and interactive comments,. It also features administrative controls for content moderation,.
Key Features
• User Management: Supports new user registration and secure login functionality,.
• Post CRUD Operations: Users can create, update, delete, and view posts. Each post supports one image upload,.
• Comment System: Interactive comments on every post with full CRUD capabilities,.
• Categorization: Posts are organized by categories (e.g., Cricket, Politics) to allow users to filter content.
• Advanced Data Handling: Implementation of Pagination and Sorting for post APIs to improve performance.
• Security:
    ◦ JWT (JSON Web Token) based authentication,.
    ◦ Role-Based Access Control (RBAC): Distinction between "Admin" and "Normal User" roles,.
    ◦ Input Validation: Strict validation for users, posts, and comments before saving to the database.
• Exception Handling: Global exception handling to provide proper error messages to the client.
• API Documentation: Fully documented APIs using Swagger for easy integration and testing,.
Technology Stack
• Language: Java
• Framework: Spring Boot,
• Security: Spring Security & JWT,
• Database: MySQL (interfaced via Spring Data JPA and Hibernate)
• Build Tool: Maven
• IDE: Spring Tool Suite (STS)
• Web Server: Embedded Apache Tomcat,
• Testing: Postman
• Deployment: AWS (EC2 Instances),
API Testing
API endpoints can be tested using Postman to ensure all functionalities like registration, post creation, and commenting work as expected.

--------------------------------------------------------------------------------
ER Diagram Description
Based on the requirements provided in the sources, here is the Entity-Relationship (ER) structure for the database.
Entities and Attributes
1. User,:
    ◦ id (Primary Key)
    ◦ name
    ◦ email (Unique)
    ◦ password
    ◦ about
    ◦ role (Admin/Normal)
2. Post,,:
    ◦ id (Primary Key)
    ◦ title
    ◦ content
    ◦ imageName (Stores the name of the uploaded picture)
    ◦ addedDate
    ◦ category_id (Foreign Key)
    ◦ user_id (Foreign Key)
3. Category:
    ◦ id (Primary Key)
    ◦ title
    ◦ description
4. Comment,:
    ◦ id (Primary Key)
    ◦ content
    ◦ post_id (Foreign Key)
    ◦ user_id (Foreign Key)
Relationships
• User to Post: One-to-Many (One user can write multiple posts).
• Category to Post: One-to-Many (One category can contain multiple posts).
• Post to Comment: One-to-Many (One post can have many comments),.
• User to Comment: One-to-Many (One user can post multiple comments).

R Diagram (Visual Representation)
erDiagram
    USER ||--o{ POST : writes
    USER ||--o{ COMMENT : posts
    CATEGORY ||--o{ POST : contains
    POST ||--o{ COMMENT : has

    USER {
        int id PK
        string name
        string email
        string password
        string about
        string role
    }

    POST {
        int id PK
        string title
        string content
        string imageName
        date addedDate
        int category_id FK
        int user_id FK
    }

    CATEGORY {
        int id PK
        string title
        string description
    }

    COMMENT {
        int id PK
        string content
        int post_id FK
        int user_id FK
    }
