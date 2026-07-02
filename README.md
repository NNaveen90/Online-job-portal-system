\# Online Job Portal System



A full-stack web application that connects \*\*job seekers (candidates)\*\* with \*\*recruiters\*\*, built using core Java web technologies following the MVC architecture.



\## 🚀 Features



\### For Candidates

\- User registration \& login

\- Browse and search job listings

\- Apply to jobs

\- Save jobs for later

\- View and manage submitted applications

\- Edit personal profile



\### For Recruiters

\- Recruiter registration \& login

\- Post new job openings

\- Edit / delete posted jobs

\- Manage all posted jobs

\- View applicants for each job

\- View candidate profiles

\- Update application status

\- Schedule interviews

\- Manage company/recruiter profile



\## 🛠️ Tech Stack



| Layer | Technology |

|---|---|

| Language | Java |

| Web Layer | Servlets, JSP |

| Database Access | JDBC |

| Database | MySQL |

| Architecture | MVC (Model-View-Controller) |

| Build Tool | Maven |



\## 📁 Project Structure



```

JobPortal/

├── src/main/java/com/jobportal/

│   ├── controller/

│   │   ├── auth/          # Login, Register, Logout

│   │   ├── candidate/     # Candidate-side servlets

│   │   └── recruiter/     # Recruiter-side servlets

│   ├── dao/                # Database access classes

│   ├── filter/              # Authentication \& role-based filters

│   ├── listener/          # App context listener

│   ├── model/              # Entity classes

│   ├── service/            # Business logic layer

│   └── util/                # DB connection, validation, file upload utils

├── src/main/webapp/

│   ├── auth/                # Login/Register JSPs

│   ├── candidate/         # Candidate dashboard JSPs

│   ├── recruiter/          # Recruiter dashboard JSPs

│   ├── common/             # Shared navbar/sidebar/footer

│   ├── assets/               # CSS \& JS

│   └── WEB-INF/web.xml

└── src/main/resources/

&#x20;   └── db.properties.example

```



\## ⚙️ Setup Instructions



\### Prerequisites

\- JDK 8 or higher

\- Apache Tomcat (9.x recommended)

\- MySQL Server

\- Maven

\- An IDE (Eclipse / IntelliJ) — optional but recommended



\### 1. Clone the repository

```bash

git clone https://github.com/NNaveen90/Online-job-portal-system.git

cd Online-job-portal-system

```



\### 2. Set up the database

\- Create a MySQL database (e.g., `online\_job\_portal`)

\- Import the schema/SQL file (if provided) or create the required tables matching the model classes



\### 3. Configure database credentials

Copy the example properties file and update it with your own MySQL credentials:

```bash

copy src\\main\\resources\\db.properties.example src\\main\\resources\\db.properties

```

Then edit `src/main/resources/db.properties`:

```properties

db.url=jdbc:mysql://localhost:3306/online\_job\_portal

db.user=your\_mysql\_username

db.password=your\_mysql\_password

```

> ⚠️ `db.properties` is git-ignored and will not be pushed — keep your real credentials there only.



\### 4. Build the project

```bash

mvn clean package

```

This generates a `.war` file inside the `target/` folder.



\### 5. Deploy to Tomcat

\- Copy the generated `.war` file into Tomcat's `webapps/` folder

\- Start Tomcat

\- Access the app at:

```

http://localhost:8080/<war-name>/

```



\## 📌 Notes

\- This project currently runs on `localhost` only.

\- Deployment to a live server (e.g., Render, Railway) requires containerizing the app and using a cloud-hosted MySQL instance.



\## 👤 Author

\*\*Naveen\*\* — \[GitHub Profile](https://github.com/NNaveen90)



\## 📄 License

This project is open source and available for learning purposes.



