import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class MedicalRecord {
    private final String diagnosis;
    private final String prescription;

    public MedicalRecord(String diagnosis, String prescription) {
        this.diagnosis = diagnosis;
        this.prescription = prescription;
    }

    @Override
    public String toString() {
        return "Diagnosis: " + diagnosis + " | Prescription: " + prescription;
    }
}

class Patient {
    private static int counter = 1000;
    private final String id;
    private final String name;
    private final int age;
    private final String gender;
    private final List<MedicalRecord> records = new ArrayList<>();

    public Patient(String name, int age, String gender) {
        this.id = "PAT-" + (++counter);
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public String getId() { return id; }
    public String getName() { return name; }

    public void addRecord(MedicalRecord record) {
        records.add(record);
    }

    public void displayHistory() {
        System.out.println("\n--- History for " + name + " (" + id + ") ---");
        if (records.isEmpty()) {
            System.out.println("No medical records found.");
        } else {
            for (MedicalRecord record : records) {
                System.out.println(record);
            }
        }
    }

    @Override
    public String toString() {
        return String.format("[%s] %-15s | Age: %-3d | Gender: %s", id, name, age, gender);
    }
}

class Doctor {
    private static int counter = 5000;
    private final String id;
    private final String name;
    private final String specialization;
    private final double consultationFee;

    public Doctor(String name, String specialization, double consultationFee) {
        this.id = "DOC-" + (++counter);
        this.name = name;
        this.specialization = specialization;
        this.consultationFee = consultationFee;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public double getConsultationFee() { return consultationFee; }

    @Override
    public String toString() {
        return String.format("[%s] Dr. %-15s | Specialization: %-15s | Fee: $%.2f", id, name, specialization, consultationFee);
    }
}

class Appointment {
    private final Patient patient;
    private final Doctor doctor;
    private final String date;
    private final String status;

    public Appointment(Patient patient, Doctor doctor, String date) {
        this.patient = patient;
        this.doctor = doctor;
        this.date = date;
        this.status = "Confirmed";
    }

    @Override
    public String toString() {
        return String.format("Date: %s | Patient: %s | Doctor: Dr. %s | Status: %s", date, patient.getName(), doctor.getName(), status);
    }
}

class Invoice {
    private static int counter = 9000;
    private final String invoiceId;
    private final Patient patient;
    private final double amount;
    private boolean isPaid;

    public Invoice(Patient patient, double amount) {
        this.invoiceId = "INV-" + (++counter);
        this.patient = patient;
        this.amount = amount;
        this.isPaid = false;
    }

    public void markAsPaid() {
        this.isPaid = true;
    }

    @Override
    public String toString() {
        return String.format("[%s] Patient: %-15s | Amount: $%.2f | Status: %s", invoiceId, patient.getName(), amount, (isPaid ? "PAID" : "UNPAID"));
    }
}

class HospitalApp {
    private final List<Patient> patients = new ArrayList<>();
    private final List<Doctor> doctors = new ArrayList<>();
    private final List<Appointment> appointments = new ArrayList<>();
    private final List<Invoice> invoices = new ArrayList<>();

    public HospitalApp() {
        doctors.add(new Doctor("Alice Smith", "Cardiology", 150.00));
        doctors.add(new Doctor("Robert Chen", "Neurology", 200.00));
        doctors.add(new Doctor("Emily Davis", "Pediatrics", 100.00));
    }

    public void registerPatient(String name, int age, String gender) {
        Patient patient = new Patient(name, age, gender);
        patients.add(patient);
        System.out.println("Registered patient successfully: " + patient.getId());
    }

    public void listPatients() {
        if (patients.isEmpty()) {
            System.out.println("No patients found.");
            return;
        }
        System.out.println("\n--- Patients List ---");
        for (Patient p : patients) {
            System.out.println(p);
        }
    }

    public void listDoctors() {
        System.out.println("\n--- Medical Staff ---");
        for (Doctor d : doctors) {
            System.out.println(d);
        }
    }

    public void scheduleAppointment(String patientId, String doctorId, String date) {
        Patient patient = findPatient(patientId);
        Doctor doctor = findDoctor(doctorId);

        if (patient == null || doctor == null) {
            System.out.println("Error: Invalid Patient or Doctor ID.");
            return;
        }

        Appointment appointment = new Appointment(patient, doctor, date);
        appointments.add(appointment);

        Invoice invoice = new Invoice(patient, doctor.getConsultationFee());
        invoices.add(invoice);

        System.out.println("Appointment scheduled successfully!");
        System.out.println("Invoice generated: " + invoice);
    }

    public void addMedicalRecord(String patientId, String diagnosis, String prescription) {
        Patient patient = findPatient(patientId);
        if (patient == null) {
            System.out.println("Error: Patient not found.");
            return;
        }

        patient.addRecord(new MedicalRecord(diagnosis, prescription));
        System.out.println("Medical record added successfully.");
    }

    public void viewPatientHistory(String patientId) {
        Patient patient = findPatient(patientId);
        if (patient == null) {
            System.out.println("Error: Patient not found.");
            return;
        }
        patient.displayHistory();
    }

    public void listInvoices() {
        if (invoices.isEmpty()) {
            System.out.println("No invoices generated yet.");
            return;
        }
        System.out.println("\n--- Billing Records ---");
        for (Invoice inv : invoices) {
            System.out.println(inv);
        }
    }

    private Patient findPatient(String id) {
        return patients.stream().filter(p -> p.getId().equalsIgnoreCase(id)).findFirst().orElse(null);
    }

    private Doctor findDoctor(String id) {
        return doctors.stream().filter(d -> d.getId().equalsIgnoreCase(id)).findFirst().orElse(null);
    }
}

public class main {
    public static void main(String[] args) {
        HospitalApp system = new HospitalApp();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n=================================");
            System.out.println("    CLINIC MANAGEMENT SYSTEM    ");
            System.out.println("=================================");
            System.out.println("1. Register Patient");
            System.out.println("2. View Patients");
            System.out.println("3. View Doctors");
            System.out.println("4. Book Appointment");
            System.out.println("5. Add Patient Medical Record");
            System.out.println("6. View Patient Medical History");
            System.out.println("7. View Billing & Invoices");
            System.out.println("8. Exit");
            System.out.print("Select choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter Patient Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Age: ");
                    int age = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter Gender: ");
                    String gender = scanner.nextLine();
                    system.registerPatient(name, age, gender);
                    break;

                case 2:
                    system.listPatients();
                    break;

                case 3:
                    system.listDoctors();
                    break;

                case 4:
                    System.out.print("Enter Patient ID (e.g. PAT-1001): ");
                    String pId = scanner.nextLine();
                    System.out.print("Enter Doctor ID (e.g. DOC-5001): ");
                    String dId = scanner.nextLine();
                    System.out.print("Enter Date (YYYY-MM-DD): ");
                    String date = scanner.nextLine();
                    system.scheduleAppointment(pId, dId, date);
                    break;

                case 5:
                    System.out.print("Enter Patient ID: ");
                    String recPid = scanner.nextLine();
                    System.out.print("Enter Diagnosis: ");
                    String diag = scanner.nextLine();
                    System.out.print("Enter Prescription: ");
                    String rx = scanner.nextLine();
                    system.addMedicalRecord(recPid, diag, rx);
                    break;

                case 6:
                    System.out.print("Enter Patient ID: ");
                    String histPid = scanner.nextLine();
                    system.viewPatientHistory(histPid);
                    break;

                case 7:
                    system.listInvoices();
                    break;

                case 8:
                    System.out.println("Shutting down application.");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid selection.");
            }
        }
    }
}