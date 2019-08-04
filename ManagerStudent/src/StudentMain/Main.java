package StudentMain;

import StudentManager.StudentManager;

import java.util.Scanner;

public class Main {
    public static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {

        String choose = null;
        boolean exit = false;
        StudentManager studentManager = new StudentManager();
        int studentId, studentMssv;
        showMenu();
        while (true) {
            choose = scan.nextLine();
            switch (choose) {
                case "1":
                    studentManager.add();
                    break;
                case "2":
                    studentMssv = studentManager.inputMssv();
                    studentManager.edit(studentMssv);
                    break;
                case "3":
                    studentMssv = studentManager.inputMssv();
                    studentManager.delete(studentMssv);
                    break;
                case "4":
                    studentMssv = studentManager.inputMssv();
                    studentManager.find(studentMssv);
                    break;
                case "5":
                    //studentManager.sortStudentById();
                    break;
                case "6":
                    //studentManager.sortStudentByMssv();
                    break;
                case "7":
                    //studentManager.sortStudentByDtb();
                    break;
                case "8":
                    //studentManager.sortStudentByName();
                    break;
                case "9":
                    studentManager.show();
                    break;
                case "10":
                    System.out.println("Exited!");
                    exit = true;
                    break;
                default:
                    System.out.println("invalid! please choose action in below menu ");
                    break;
            }
            if (exit) {
                break;
            }
            showMenu();
        }

    }

    public static void showMenu() {
        System.out.println("----------------------------------");
        System.out.println("| Menu Manager Student           |");
        System.out.println("----------------------------------");
        System.out.println("|  1. Add student.               |");
        System.out.println("|  2. Edit student by mssv.      |");
        System.out.println("|  3. Delete student by mssv.    |");
        System.out.println("|  4. Find student by mssv.      |");
        System.out.println("|  5. Sort student by id.        |");
        System.out.println("|  6. Sort student by mssv.      |");
        System.out.println("|  7. Sort student by dtb.       |");
        System.out.println("|  8. Sort student by name.      |");
        System.out.println("|  9. Show Student.              |");
        System.out.println("| 10. Exit.                      |");
        System.out.println("----------------------------------");

    }
}

