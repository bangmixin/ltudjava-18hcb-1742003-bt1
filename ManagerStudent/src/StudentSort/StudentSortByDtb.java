package StudentSort;

import Student.Student;

import java.util.Comparator;

public class StudentSortByDtb implements Comparator<Student> {
    public int compare(Student s1, Student s2) {
        if(s1.getDtb()>s2.getDtb()){
            return 1;
        }
        return -1;
    }
}
