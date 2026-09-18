# Hospital Management System

A Java-based console application designed to streamline daily hospital and clinic operations, including patient registration, doctor lookup, appointment booking, medical record tracking, and automated billing generation.

---

## Key Features

- **Patient Management:** Register patients and automatically generate unique IDs (`PAT-100x`).
- **Doctor Directory:** View available doctors, specializations, and consultation fees.
- **Appointment Scheduling:** Book patient appointments with specific doctors for selected dates.
- **Medical Records:** Add diagnoses and prescriptions directly to patient profiles and view complete medical history.
- **Billing & Invoicing:** Automatic invoice generation upon scheduling appointments.

---

## Prerequisites

- **Java Development Kit (JDK):** Version 8 or higher
- **Terminal / Command Prompt / IDE:** IntelliJ IDEA, Eclipse, VS Code, or standard command line.

---

## File Structure

```text
.
├── Main.java     # Contains all classes and application main method
└── README.md     # Project documentation
```

---

## How to Compile and Run

### 1. Command Line / Terminal

1. **Navigate to project directory:**
   ```bash
   cd path/to/your/project
   ```

2. **Compile the Java file:**
   ```bash
   javac Main.java
   ```

3. **Run the application:**
   ```bash
   java Main
   ```

---

## Project Class Architecture

- **`Patient`**: Stores details like ID, name, age, gender, and associated medical records.
- **`Doctor`**: Contains staff information, specialization, and consultation fees.
- **`Appointment`**: Connects a `Patient` and a `Doctor` on a given date.
- **`MedicalRecord`**: Encapsulates diagnosis and prescription data.
- **`Invoice`**: Handles billing calculations and status tracking for consultation fees.
- **`HospitalApp`**: System controller managing lists and operational logic.
- **`Main`**: Interactive CLI wrapper providing user navigation.
