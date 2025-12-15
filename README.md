# 🚀 Backend Practice – Spring Boot REST API

A **Spring Boot backend practice project** focused on building clean, layered REST APIs using real‑world domain entities like **Company**, **Job**, and **Review**.
This repository is designed to strengthen backend fundamentals such as **CRUD operations**, **service abstraction**, **JPA repositories**, and **REST controller design**.

---

## 📌 Tech Stack

* **Language:** Java 17+
* **Framework:** Spring Boot
* **Build Tool:** Maven
* **ORM:** Spring Data JPA / Hibernate
* **Architecture:** Controller → Service → Repository
* **API Style:** RESTful APIs

---

## 📂 Project Architecture

The project follows a **feature‑based package structure** with clear separation of concerns.

```
src/main/java/com/sagnik/NewBackend_Practice
│
├── company
│   ├── Company                 # Entity
│   ├── CompanyController       # REST Controller
│   ├── CompanyRepository       # JPA Repository
│   ├── CompanyService          # Service Interface
│   └── impl
│       └── CompanyServiceImpl  # Service Implementation
│
├── job
│   ├── Job
│   ├── JobController
│   ├── JobRepository
│   ├── JobService
│   └── impl
│       └── JobServiceImpl
│
├── reviews
│   ├── Review
│   ├── ReviewController
│   ├── ReviewRepository
│   ├── ReviewService
│   └── impl
│       └── ReviewServiceImpl
│
└── NewBackendPracticeApplication  # Main Spring Boot class
```

---

## 🧠 Architecture Overview

### 🔹 Controller Layer

* Handles incoming HTTP requests
* Maps REST endpoints using `@RestController`
* Delegates business logic to the service layer

### 🔹 Service Layer

* Contains **business logic**
* Defined using interfaces for loose coupling
* Implemented inside the `impl` package

### 🔹 Repository Layer

* Uses **Spring Data JPA**
* Handles database operations
* Extends `JpaRepository`

### 🔹 Entity Layer

* Represents database tables
* Annotated with `@Entity`

---

## 📡 API Modules

### 🏢 Company Module

Handles operations related to companies.

**Responsibilities:**

* Create company
* Fetch company details
* Update company
* Delete company

### 💼 Job Module

Handles job postings associated with companies.

**Responsibilities:**

* Create jobs
* List jobs
* Update job details
* Delete jobs

### ⭐ Review Module

Handles reviews given to companies.

**Responsibilities:**

* Add reviews
* Fetch reviews by company
* Update/delete reviews

---

## ⚙️ Configuration

All application configurations are present in:

```
src/main/resources/application.properties
```

This includes:

* Server configuration
* Database configuration (if enabled)

---

## ▶️ How to Run the Project

### 1️⃣ Clone the repository

```bash
git clone https://github.com/DSagnik24/Backend-Practice.git
cd Backend-Practice
```

### 2️⃣ Run using Maven Wrapper

```bash
./mvnw spring-boot:run
```

OR (Windows)

```bash
mvnw.cmd spring-boot:run
```

### 3️⃣ Access the application

```
http://localhost:8083
```

---

## 🧪 Testing APIs

You can test the APIs using:

* Postman
* Thunder Client
* curl

---

## ✅ Best Practices Followed

✔ Layered architecture (Controller / Service / Repository)
✔ Interface‑based service design
✔ Clean package structure
✔ RESTful API conventions
✔ Reusable business logic

---

## 🚧 Future Enhancements

* Add **Swagger / OpenAPI documentation**
* Add **Spring Security + JWT**
* Add **Global Exception Handling**
* Add **DTOs & ModelMapper**
* Add **Pagination & Sorting**
* Add **Unit & Integration Tests**

---

## 👨‍💻 Author

**Sagnik Dutta**
Backend Developer | Java | Spring Boot

---

This project is for **learning and practice purposes**. Feel free to fork and extend it.

