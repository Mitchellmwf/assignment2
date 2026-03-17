import java.util.ArrayList;
import java.util.Scanner;


// Main program
public class StudentManager {
    
    private static ArrayList<Student> students = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        addExampleStudents();

        boolean running = true;
        
        while (running) {
            showMenu();
            int choice = getChoice();

            if (choice == 1) {
                addStudent();
            }
            else if (choice == 2) {
                removeStudentById();
            }
            else if (choice == 3) {
                displayAllStudents();
            }
            else if (choice == 4) {
                searchStudents();
            }
            else if (choice == 5) {
                running = false;
                System.out.println("\nThank you! Goodbye.");
            }
            else {
                System.out.println("Invalid choice. Please enter 1-5.");
            }
            
            System.out.println();
        }
        
        scanner.close();
    }
    private static void showMenu() {
        System.out.println("=== Student Management System ===");
        System.out.println("1. Add a student");
        System.out.println("2. Remove student by ID");
        System.out.println("3. Display all students");
        System.out.println("4. Search by name or ID");
        System.out.println("5. Exit");
        System.out.print("Choose an option (1-5): ");
    }

    private static int getChoice() {
        try {
            return Integer.parseInt(scanner.nextLine().trim());
        } catch (Exception e) {
            return -1;
        }
    }

    private static void addExampleStudents() {
        students.add(new Student("Peter Pan", "123456", "peter@college.ca", "Culinary Arts"));
        students.add(new Student("Emily Rose", "789012", "emily@college.ca", "Biology"));
        students.add(new Student("Victor Hugo", "345678", "victor@college.ca", "Literature"));
        System.out.println("Example students loaded (" + students.size() + " records).");
    }