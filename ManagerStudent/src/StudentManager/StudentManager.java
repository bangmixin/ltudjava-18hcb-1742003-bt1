package StudentManager;

import Student.Student;
import StudentDAO.StudentDAO;
import StudentSort.StudentSortByDtb;
import StudentSort.StudentSortById;
import StudentSort.StudentSortByMssv;
import StudentSort.StudentSortByName;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentManager {
    private static Scanner scan = new Scanner(System.in);
    private ArrayList<Student> studentList;

    public StudentManager() {
        Object data = StudentDAO.readFile();
        studentList = (ArrayList<Student>) data;

    }

    /*
     * add student to studentList
     * @param student
     */
    public void add() {
       /* int id = (studentList.size() > 0) ? (studentList.size() + 1) : 1;
        System.out.println("Student id= " + id);*/
        int id = inputId();
        int mssv = inputMssv();
        String name = inputName();
        String sex = inputSex();
        float dtb = inputDtb();
        Student student = new Student(id, mssv, name, sex, dtb);
        studentList.add(student);
        boolean result = StudentDAO.writeFile(studentList);
        if (result) {
            System.out.println("Add success");
        } else {
            System.out.println("Add fail");
        }

    }

    /*
     * edit student by mssv
     * @param id
     */
    public void edit(int mssv) {
        boolean isExixted = false;
        //int size = studentList.size();
        //lấy hs ở vị trí i từ get()
        for (Student student : studentList)
            if (student.getMssv() == mssv) {
                System.out.println(student);
                isExixted = true;
                student.setName(inputName());
                student.setSex(inputSex());
                student.setDtb(inputDtb());
                break;
            }
        if (!isExixted) {
            System.out.printf("Mssv = %d not existed.\n", mssv);
        } else {
            boolean result = StudentDAO.writeFile(studentList);
            if (result) {
                System.out.println("Edit success");
            } else {
                System.out.println("Edit fail");
            }
        }
    }

    /*
     * delete student by mssv
     * @param id: student mssv
     */
    public void delete(int mssv) {
        Student student = null;
        //int size = studentList.size();
        for (Student value : studentList) {
            if (value.getMssv() == mssv) {
                student = value;
                break;
            }
        }
        if (student != null) {
            studentList.remove(student);
            boolean result = StudentDAO.writeFile(studentList);
            if (result) {
                System.out.println("Delete success");
            } else {
                System.out.println("Delete fail");
            }
        } else {
            System.out.printf("id = %d not existed.\n", mssv);
        }
    }

    /*
     * find student by mssv
     * @param id: student mssv
     */
    public void find(int mssv) {
        boolean isExixted = false;

        for (Student student : studentList) {
            if (student.getMssv() == mssv) {
                isExixted = true;
                System.out.println(student);
            }
        }
        if (!isExixted) {
            System.out.println("Not find student!");
        }
    }

    /*
     * sort student by name
     */
    public void sortStudentById() {
        studentList.sort(new StudentSortById());
        show();
    }
    /*
     * sort student by name
     */
    public void sortStudentByName() {
        studentList.sort(new StudentSortByName());
        show();
    }

    /*
     * sort student by mssv
     */
    public void sortStudentByMssv() {

        studentList.sort(new StudentSortByMssv());
        show();
    }

    /*
     * sort student by dtb
     */
    public void sortStudentByDtb() {

        studentList.sort(new StudentSortByDtb());
        show();
    }

    public void show() {
        System.out.format(
                "------------------------------------------------------------\n");
        System.out.format("| ID | Mssv\t\t | Name\t\t\t\t\t\t| Sex | DTB |\n");
        System.out.format(
                "------------------------------------------------------------\n");
        for (Student student : studentList) {
            System.out.format("| %-2d ", student.getId());
            System.out.format("| %-9d ", student.getMssv());
            System.out.format("| %-25s", student.getName());
            System.out.format("| %-4s", student.getSex());
            System.out.format("| %.1f |\n", student.getDtb());
            System.out.format("------------------------------------------------------------\n");

        }
    }

    /*
     * input student id
     * @return student id
     */
    public int inputId() {
        System.out.print("Input student id: ");
        while (true) {
            try {
                return Integer.parseInt(scan.nextLine());
            } catch (NumberFormatException e) {
                System.out.print("Invalid! Input student id again:");
            }
        }
    }

    /*
     * input student mssv
     * @return student mssv
     */
    public int inputMssv() {
        System.out.print("Input student mssv: ");
        while (true) {
            try {
                return Integer.parseInt(scan.nextLine());
            } catch (NumberFormatException e) {
                System.out.print("Invalid! Input student mssv again:");
            }
        }
    }

    /*
     * input student name
     * @return student name
     */
    private String inputName() {
        System.out.print("Input student name: ");
        return scan.nextLine();
    }

    /*
     * input student sex
     * @return student sex
     */
    private String inputSex() {
        System.out.print("Input student sex: ");
        return scan.nextLine();
    }

    /*
     * input student dtb
     * @return student dtb
     */
    private float inputDtb() {
        System.out.print("Input student dtb: ");
        while (true) {
            try {
                float dtb = Float.parseFloat((scan.nextLine()));
                if (dtb < 0.0 && dtb > 10.0) {
                    throw new NumberFormatException();
                }
                return dtb;

            } catch (NumberFormatException e) {
                System.out.println("Invalid! Input student dtb again: ");
            }
        }
    }

    public ArrayList<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(ArrayList<Student> studentList) {
        this.studentList = studentList;
    }
}





