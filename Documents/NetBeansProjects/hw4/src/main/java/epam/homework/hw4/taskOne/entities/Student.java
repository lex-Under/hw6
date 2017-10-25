package epam.homework.hw4.taskOne.entities;

public class Student {

    private String name;
    private int age;
    private int passportNo;
    private int markbookNo;
    private int course;
    private String major;

    public Student(String name, int age, int passportNo, int markbookNo, int course, String major) {
        this.name = name;
        this.age = age;
        this.passportNo = passportNo;
        this.markbookNo = markbookNo;
        this.course = course;
        this.major = major;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getPassportNo() {
        return passportNo;
    }

    public void setPassportNo(int passportNo) {
        this.passportNo = passportNo;
    }

    public int getMarkbookNo() {
        return markbookNo;
    }

    public void setMarkbookNo(int markbookNo) {
        this.markbookNo = markbookNo;
    }

    @Override
    public String toString() {
        return "Name: " + name + ",\nage: " + age + ",\npassport number: " + passportNo
                + ",\nmarkbook number:" + markbookNo + ",\ncourse: " + course + ",\nmajor: " + major + ";";
    }
}
