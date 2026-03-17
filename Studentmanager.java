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