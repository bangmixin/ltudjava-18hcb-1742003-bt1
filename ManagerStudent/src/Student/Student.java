package Student;

import java.io.Serializable;

public class Student implements Serializable {
    private int id;
    private int mssv;
    private String name;
    private String sex;
    private float dtb;//điểm trung bình

    public Student() {
    }

    public Student(int id, int mssv, String name, String sex, float dtb) {
        this.id = id;
        this.mssv = mssv;
        this.name = name;
        this.sex = sex;
        this.dtb = dtb;
    }

    public int getId() {
        return id;
    }

    public int getMssv() {
        return mssv;
    }

    public String getName() {
        return name;
    }

    public String getSex() {
        return sex;
    }


    public float getDtb() {
        return dtb;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setMssv(int mssv) {
        this.mssv = mssv;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }


    public void setDtb(float dtb) {
        this.dtb = dtb;
    }
}
