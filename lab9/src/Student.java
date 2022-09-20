import java.util.List;

public class Student {
    private String name;
    private int course;

    public Student(String name, int course) {
        this.name = name;
        this.course = course;
    }

    public String getName() {
        return name;
    }

    public int getCourse() {
        return course;
    }

    public static void printStudents(List<Student> students, int course) {
        students.forEach(student -> {
            if (student.course == course) {
                System.out.println(student);
            }
        });
    }

    @Override
    public String toString() {
        return "Student [name=" + name + ", course=" + course + "]";
    }
}
