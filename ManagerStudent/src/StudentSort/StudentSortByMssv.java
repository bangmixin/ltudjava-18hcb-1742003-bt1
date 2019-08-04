package StudentSort;

import Student.Student;

import java.util.Comparator;

public class StudentSortByMssv implements Comparator<Student> {

    public int compare(Student s1, Student s2) {
        if(s1.getMssv()>s2.getMssv()){
            return 1;
        }
        return -1;
    }


}
