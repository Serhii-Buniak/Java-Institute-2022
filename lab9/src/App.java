import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        int course = Integer.parseInt(args[0]);

        List<Student> students = new ArrayList<Student>() {
            {
                add(new Student("Name1", 101));
                add(new Student("Name2", 201));
                add(new Student("Name3", 101));
                add(new Student("Name4", 201));
                add(new Student("Name5", 401));
                add(new Student("Name6", 301));
                add(new Student("Name7", 401));
                add(new Student("Name8", 501));
                add(new Student("Name9", 501));
                add(new Student("Name10", 701));
                add(new Student("Name11", 101));
                add(new Student("Name12", 201));
            }
        };

        Student.printStudents(students, course);
    }
}