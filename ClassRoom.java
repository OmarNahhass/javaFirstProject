import java.util.ArrayList;
import java.util.List;

public class ClassRoom {

    private String className;
    private String classSection;
    private List<User> students;
    private User classRoomTeacher;

    public ClassRoom() {
        students = new ArrayList<>();
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getClassSection() {
        return classSection;
    }

    public void setClassSection(String classSection) {
        this.classSection = classSection;
    }

    public List<User> getStudents() {
        return students;
    }

    public void addStudent(User user) {
        students.add(user);
    }

    public User getClassRoomTeacher() {
        return classRoomTeacher;
    }

    public void setClassRoomTeacher(User classRoomTeacher) {
        this.classRoomTeacher = classRoomTeacher;
    }

    @Override
    public String toString() {
        String output = "Class: " + this.className + " Section: " + this.classSection + "\n";
        output += "Teacher: " + this.classRoomTeacher.getName() + "\n";
        output += "Students: \n";
        for (User student : students) {
            output += student.getName() + "\n";
        }
        return output;
    }
}
