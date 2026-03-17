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
                System.out.print("Enter Student ID to add course: ");
                String id = scanner.nextLine().trim().toUpperCase();
                for (Student s : students) {
                    if (s.getId().equals(id)) {
                        System.out.print("Enter course code to add (ABCD1234): ");
                        String course = scanner.nextLine().trim();
                        if (course.trim().isEmpty() || course == null) {
                            System.out.println("Course name can't be empty.");
                            return;
                        }
                        s.addCourse(course);
                        return;
                    }
                    System.out.println("No student found with that ID.");
                }
            }
             else if (choice == 6) {
                System.out.print("Enter Student ID to remove course: ");
                String id = scanner.nextLine().trim();
                for (Student s : students) {
                    if (s.getId().equals(id)) {
                        s.displayCourses();
                        System.out.print("Enter course code to remove: ");
                        String course = scanner.nextLine().trim();
                        if (course.trim().isEmpty() || course == null) {
                            System.out.println("Course name can't be empty.");
                            return;
                        }
                        s.removeCourse(course);
                    }
                }
            }
            else if (choice == 7) {
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
        System.out.println("5. Add a course to a student");
        System.out.println("6. Remove a course from a student");
        System.out.println("7. Exit");
        System.out.println("Choose an option (1-7): ");
    }

    private static int getChoice() {
        try {
            return Integer.parseInt(scanner.nextLine().trim());
        } catch (Exception e) {
            return -1;
        }
    }
    // adding example students for testing purposes
    private static void addExampleStudents() {
        students.add(new Student("Peter Pan", "S-1234", "peter@college.ca", "Culinary Arts"));
        students.add(new Student("Emily Rose", "x-1021", "emily@college.ca", "Biology"));
        students.add(new Student("Victor Hugo", "J-1012", "victor@college.ca", "Literature"));
        System.out.println("Example students loaded (" + students.size() + " records).");
    }
 // adding our lovely students
    private static void addStudent() {
        System.out.print("Name: ");
        String name = scanner.nextLine().trim();

        System.out.print("Student ID (S-1234): ");
        String id = scanner.nextLine().trim();

        System.out.print("Email: ");
        String email = scanner.nextLine().trim();

        System.out.print("Program: ");
        String program = scanner.nextLine().trim();

        // Validate and add student, catching any exceptions thrown by the constructor
        try {
            students.add(new Student(name, id, email, program));
        }
        catch (IllegalArgumentException e) {
            System.out.println("Error adding student: " + e.getMessage());
            return;
        }
        System.out.println("Student added successfully.");
    }

    private static void removeStudentById() {
        System.out.print("Enter Student ID to remove: ");
        String idToRemove = scanner.nextLine().trim();
        if (idToRemove.isEmpty()) {
            System.out.println("ID can't be empty.");
            return;
        }

        boolean removed = students.removeIf(s -> s.getId().equals(idToRemove));

        if (removed) {
            System.out.println("Student with ID " + idToRemove + " removed.");
        } else {
            System.out.println("No student found with that ID.");
            }
        }
        // displaying all students
        private static void displayAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No students in the system yet.");
            return;
        }
        System.out.println("\nAll Students:");
        System.out.println("=".repeat(80));
        for (Student s : students) {
            System.out.println(s.getDetails());
        }
        System.out.println("=".repeat(80));
        System.out.println("Total students: " + students.size());
    }
    private static void searchStudents() {
        System.out.print("Enter name or ID (partial match ok): ");
        String searchTerm = scanner.nextLine().trim().toLowerCase();

        System.out.println("\nSearch Results:");
        System.out.println("-".repeat(60));

        boolean found = false;
        for (Student s : students) {
            if (s.getName().toLowerCase().contains(searchTerm) ||
                s.getId().toLowerCase().contains(searchTerm)) {
                System.out.println(s.getDetails());
                found = true;
            }
        }

        if (!found) {
            System.out.println("No students match your search.");
        }
        System.out.println();
    }
}
