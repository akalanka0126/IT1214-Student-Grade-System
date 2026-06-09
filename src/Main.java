import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayList<Student> students = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n=== Student Grade System ===");
            System.out.println("1. Add Student");
            System.out.println("2. Display All Students");
            System.out.println("3. Search Student by ID");
            System.out.println("4. Calculate Average Marks");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    addStudent(sc);
                    break;
                case 2:
                    displayStudents();
                    break;
                case 3:
                    searchStudent(sc);
                    break;
                case 4:
                    calculateAverage();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 5);
    }

    static void addStudent(Scanner sc) {
        System.out.print("Enter ID: ");
        String id = sc.next();
        System.out.print("Enter Name: ");
        String name = sc.next();
        System.out.print("Enter Marks: ");
        double marks = sc.nextDouble();

        students.add(new Student(id, name, marks));
        System.out.println("Student added successfully!");
    }

    static void displayStudents() {
        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }

        for (Student s : students) {
            s.displayStudent();
        }
    }

    static void searchStudent(Scanner sc) {
        System.out.print("Enter Student ID: ");
        String id = sc.next();

        for (Student s : students) {
            if (s.getId().equals(id)) {
                System.out.println("Student Found:");
                s.displayStudent();
                return;
            }
        }
        System.out.println("Student not found!");
    }

    static void calculateAverage() {
        if (students.isEmpty()) {
            System.out.println("No students to calculate.");
            return;
        }

        double sum = 0;
        for (Student s : students) {
            sum += s.getMarks();
        }

        double avg = sum / students.size();
        System.out.println("Average Marks: " + avg);
    }
}