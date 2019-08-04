package StudentSort;

import Student.Student;

import java.util.Comparator;

public class StudentSortById implements Comparator<Student> {
    public int compare(Student s1, Student s2) {
        if(s1.getId()>s2.getId()){
            return 1;
        }
        return -1;
    }
}
