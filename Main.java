import java.util.Scanner;

class Subject {
    int[] subjectMarks = new int[8];
    int[] credits = new int[8];
    int[] grades = new int[8];

    public void getMarksAndCredits(Scanner s) {
        System.out.println("Enter the subject Marks:");
        for (int j = 0; j < subjectMarks.length; j++) {
            System.out.print("Subject " + (j + 1) + ": ");
            subjectMarks[j] = s.nextInt();
        }

        System.out.println("Enter the subject Credits:");
        for (int j = 0; j < credits.length; j++) {
            System.out.print("Credits for Subject " + (j + 1) + ": ");
            credits[j] = s.nextInt();
        }
    }

    public void computeGrades() {
        for (int j = 0; j < subjectMarks.length; j++) {
            grades[j] = subjectMarks[j] / 10;
            if (grades[j] > 10) {
                grades[j] = 10;
            }
            if (grades[j] < 4) {
                grades[j] = 0;
            }
        }
    }
}

class Student {
    String name;
    String usn;
    double sgpa;
    Subject subject;

    public Student() {
        subject = new Subject();
    }

    public void getStudentDetails(Scanner s) {
        System.out.print("Enter the Name: ");
        name = s.nextLine();
        System.out.print("Enter the USN: ");
        usn = s.nextLine();
    }

    public void computeSGPA() {
        double totalCredits = 0;
        double totalPoints = 0;

        for (int j = 0; j < subject.credits.length; j++) {
            totalCredits += subject.credits[j];
            totalPoints += subject.grades[j] * subject.credits[j];
        }

        sgpa = totalPoints / totalCredits;
    }

    public void display() {
        System.out.println("Name: " + name);
        System.out.println("USN: " + usn);
        System.out.printf("SGPA: %.2f%n", sgpa);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Student[] students = new Student[1];

        for (int i = 0; i < students.length; i++) {
            System.out.println("Entering details for Student " + (i + 1) + ":");
            students[i] = new Student();
            students[i].getStudentDetails(scanner);
            students[i].subject.getMarksAndCredits(scanner);
            students[i].subject.computeGrades();
            students[i].computeSGPA();
            students[i].display();
            System.out.println();
        }

        scanner.close();
    }
}
