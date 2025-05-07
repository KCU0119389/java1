package java1;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

class Student {
    private String name;
    private Date dob;

    // Constructor to initialize Student with name and date of birth
    public Student(String name, String dob) throws Exception {
        this.name = name;
        // Parsing date of birth using the provided format (DD-MM-YYYY or YYYY-MM-DD)
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        this.dob = formatter.parse(dob);
    }

    // Method to calculate age based on the date of birth
    public int calculateAge() {
        long difference = new Date().getTime() - dob.getTime();
        long ageInMilliseconds = difference / (1000L * 60L * 60L * 24L * 365L);
        return (int) ageInMilliseconds;
    }

    // Method to display student information (name and age)
    public void displayStudentInfo() {
        System.out.println("Student Name: " + this.name);
        System.out.println("Age: " + calculateAge());
    }

    // Main method to test the Student class
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Student Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Date of Birth (DD-MM-YYYY or YYYY-MM-DD): ");
        String dob = scanner.nextLine();

        try {
            Student student = new Student(name, dob);
            student.displayStudentInfo();  // Display student info with age
        } catch (Exception e) {
            System.out.println("Error: Invalid date format.");
        }
    }
}
