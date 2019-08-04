package StudentDAO;

import Student.Student;

import java.io.*;
import java.util.ArrayList;

public class StudentDAO {

    private static final String STUDENT_FILE_NAME = "student.txt";

    /**
     * save list student to file
     *
     * @param studentList: list student to save
     */
    public static boolean writeFile(Object studentList) {
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            fos = new FileOutputStream(new File(STUDENT_FILE_NAME));
            oos = new ObjectOutputStream(fos);
            oos.writeObject(studentList);
            closeStream(fos);
            closeStream(oos);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * read list student from file
     *
     * @return list student
     */
    public static Object readFile() {
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        ArrayList<Student> studentList = new ArrayList<Student>();
        try {
            fis = new FileInputStream(new File(STUDENT_FILE_NAME));
            ois = new ObjectInputStream(fis);
            studentList = (ArrayList<Student>) ois.readObject();
            closeStream(fis);
            closeStream(ois);

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return studentList;
    }

    /**
     * close input stream
     *
     * @param is: input stream
     */
    private static void closeStream(InputStream is) {
        if (is != null) {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * close output stream
     *
     * @param os: output stream
     */
    private static void closeStream(OutputStream os) {
        if (os != null) {
            try {
                os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
