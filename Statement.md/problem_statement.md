# Problem Statement & System Vision: Hospital Management System (HMS)

## 1. Problem Statement

Healthcare facilities, particularly small-to-medium clinics and outpatient departments, frequently rely on fragmented manual record-keeping, paper forms, or disconnected spreadsheets to manage daily operations. This operational model introduces critical inefficiencies:

* **Fragmented Patient Records:** Medical histories, past diagnoses, and prescriptions are stored across separate files, leading to incomplete patient backgrounds during consultations.
* **Scheduling Conflicts & Overbooking:** Without real-time validation, overlapping appointments occur, resulting in extended patient wait times and uneven doctor workloads.
* **Billing Discrepancies:** Manual fee calculation for consultations and services leads to financial tracking errors and delayed invoicing.
* **Lack of Unique Identification:** Inconsistent patient identification numbers cause misattribution of medical charts and diagnostic records.

There is a clear need for a centralized, lightweight, and structured system that unifies patient onboarding, doctor scheduling, medical history tracking, and financial billing into a reliable digital platform.

---

## 2. Project Scope

The **Hospital Management System (HMS)** addresses these challenges by providing an object-oriented software solution designed to automate core administrative workflows.

### In-Scope Capabilities
* **Patient Registration:** Automated generation of unique primary identifiers (`PAT-100x`) and demographic profile management.
* **Doctor Directory:** Management of active physician profiles, areas of specialization, and standardized consultation fee schedules.
* **Appointment Coordination:** Real-time scheduling binding active patients with physicians for designated dates.
* **Medical Record Logging:** An append-only historical log for recording clinical diagnoses and prescriptions linked directly to patient profiles.
* **Automated Invoicing:** Instant generation of billing statements corresponding to doctor consultation rates upon appointment confirmation.

### Out-of-Scope (Future Development)
* Multi-hospital network synchronization.
* Direct insurance claims processing integrations.
* Real-time pharmacy inventory auto-replenishment.

---

## 3. System Vision & Objectives

* **Data Integrity:** Eliminate duplicate entries and data loss through encapsulated data structures.
* **Operational Efficiency:** Reduce patient intake and appointment processing times from minutes to seconds.
* **Scalability:** Maintain a modular code architecture ready for seamless expansion to relational databases (e.g., MySQL via JDBC) and modern graphical interfaces (JavaFX/Swing).