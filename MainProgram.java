import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainProgram {

    private static final List<Student> studentList = new ArrayList<>();
    private static final List<Teacher> teacherList = new ArrayList<>();
    private static final List<ClassRoom> classRoomList = new ArrayList<>();
    private static final FileOperation fileOperation = new FileOperation();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Student Management System");
        while (true) {
            System.out.println("1. Student Operations");
            System.out.println("2. Class Operations");
            System.out.println("3. Teacher Operations");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    studentOperation(scanner);
                    break;
                case 2:
                    classOperation(scanner);
                    break;
                case 3:
                    teacherOperation(scanner);
                    break;
                case 4:
                    System.out.println("Thanks for using the application!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice! Try Again");
            }
        }
    }

    public static void studentOperation(Scanner scanner) {
        System.out.println("1. Create Student");
        System.out.println("2. Delete Student");
        System.out.println("3. List all students");
        System.out.println("4. Back to Main Menu");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                // creating a student
                System.out.print("Enter student name: ");
                String name = scanner.nextLine();
                System.out.print("Enter student age: ");
                int age = scanner.nextInt();
                scanner.nextLine();

                System.out.print("Enter student address: ");
                String address = scanner.nextLine();

                System.out.print("Enter student GPA: ");
                String gpa = scanner.nextLine();

                Student student = new Student();
                student.setId(UniqueId.getUniqueId());
                student.setName(name);
                student.setAge(age);
                student.setAddress(address);
                student.setGpa(gpa);

                studentList.add(student);

                System.out.println("Student Created Successfully\n");

                break;
            case 2:
                System.out.print("Enter student id to be deleted: ");
                long id = scanner.nextLong();
                scanner.nextLine();

                boolean isPresent = false;
                for (int i = 0; i < studentList.size(); i++) {
                    if (studentList.get(i).getId() == id) {
                        isPresent = true;
                        studentList.remove(i);
                        break;
                    }
                }
                if (!isPresent) {
                    System.out.println("No student found with given id " + id);
                } else {
                    System.out.println("Student Deleted Successfully\n");
                }
                break;
            case 3:
                if (studentList.size() > 0) {
                    System.out.printf("%20s%20s%20s\n", "Student ID", "Name", "Age");
                    for (int i = 0; i < studentList.size(); i++) {
                        System.out.printf("%20s%20s%20s\n", studentList.get(i).getId(), studentList.get(i).getName(), studentList.get(i).getAge());
                    }
                } else {
                    System.out.println("No student present");
                }
                break;
            case 4:
                break;
            default:
                System.out.println("Invalid Choice! Try again!");
        }
    }

    public static void teacherOperation(Scanner scanner) {
        System.out.println("1. Create Teacher");
        System.out.println("2. Delete Teacher");
        System.out.println("3. List all Teacher");
        System.out.println("4. Back to Main Menu");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                // creating a teacher
                System.out.print("Enter Teacher name: ");
                String name = scanner.nextLine();
                System.out.print("Enter Teacher age: ");
                int age = scanner.nextInt();
                scanner.nextLine();

                System.out.print("Enter Teacher address: ");
                String address = scanner.nextLine();

                System.out.print("Enter Teacher Qualification: ");
                String qualification = scanner.nextLine();

                Teacher teacher = new Teacher();
                teacher.setId(UniqueId.getUniqueId());
                teacher.setName(name);
                teacher.setAge(age);
                teacher.setAddress(address);
                teacher.setQualification(qualification);

                teacherList.add(teacher);
                System.out.println("Teacher Created Successfully\n");
                break;
            case 2:
                System.out.print("Enter teacher id to be deleted: ");
                long id = scanner.nextLong();
                scanner.nextLine();

                boolean isPresent = false;
                for (int i = 0; i < teacherList.size(); i++) {
                    if (teacherList.get(i).getId() == id) {
                        isPresent = true;
                        teacherList.remove(i);
                        break;
                    }
                }
                if (!isPresent) {
                    System.out.println("No teacher found with given id " + id);
                } else {
                    System.out.println("Teacher Deleted Successfully\n");
                }
                break;
            case 3:
                if (teacherList.size() > 0) {
                    System.out.printf("%20s%20s%20s\n", "Teacher ID", "Name", "Qualification");
                    for (int i = 0; i < teacherList.size(); i++) {
                        System.out.printf("%20s%20s%20s\n", teacherList.get(i).getId(), teacherList.get(i).getName(), teacherList.get(i).getQualification());
                    }
                } else {
                    System.out.println("No teacher present");
                }
                break;
            case 4:
                break;
            default:
                System.out.println("Invalid Choice! Try again!");
        }
    }


    public static void classOperation(Scanner scanner) {
        System.out.println("1. Create Class");
        System.out.println("2. Add Teacher");
        System.out.println("3. Add Student");
        System.out.println("4. Display class information");
        System.out.println("5. Write to file");
        System.out.println("6. Back to Main Menu");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                // creating a class
                System.out.print("Enter class name: ");
                String name = scanner.nextLine();
                System.out.print("Enter class section: ");
                String section = scanner.nextLine();

                ClassRoom classRoom = new ClassRoom();
                classRoom.setClassName(name);
                classRoom.setClassSection(section);

                classRoomList.add(classRoom);
                System.out.println("Class Created Successfully\n");
                break;
            case 2:
                // add teacher to class
                System.out.print("Enter teacher id: ");
                long teacherId = scanner.nextLong();
                scanner.nextLine();

                System.out.print("Enter class name: ");
                String classRoomName = scanner.nextLine();

                System.out.print("Enter class section: ");
                String classRoomSection = scanner.nextLine();


                boolean isClassRoomFound = false;
                ClassRoom currentClassRoom = null;
                Teacher currentTeacher = null;
                boolean isTeacherFound = false;

                for (ClassRoom classR : classRoomList) {
                    if (classR.getClassName().equalsIgnoreCase(classRoomName) &&
                            classR.getClassSection().equalsIgnoreCase(classRoomSection)) {
                        isClassRoomFound = true;
                        currentClassRoom = classR;
                        break;
                    }
                }

                for (Teacher teacher : teacherList) {
                    if (teacher.getId() == teacherId) {
                        isTeacherFound = true;
                        currentTeacher = teacher;
                        break;
                    }
                }

                if (!isClassRoomFound || !isTeacherFound) {
                    System.out.println("Invalid class or Invalid teacher");
                    break;
                } else {
                    System.out.println("Teacher Added Successfully\n");
                }

                currentClassRoom.setClassRoomTeacher(currentTeacher);
                break;
            case 3:
                // adding student to class
                System.out.print("Enter student id: ");
                long studentId = scanner.nextLong();
                scanner.nextLine();

                System.out.print("Enter class name: ");
                classRoomName = scanner.nextLine();

                System.out.print("Enter class section: ");
                classRoomSection = scanner.nextLine();

                isClassRoomFound = false;
                currentClassRoom = null;
                Student currentStudent = null;
                boolean isStudentFound = false;

                for (ClassRoom classR : classRoomList) {
                    if (classR.getClassName().equalsIgnoreCase(classRoomName) &&
                            classR.getClassSection().equalsIgnoreCase(classRoomSection)) {
                        isClassRoomFound = true;
                        currentClassRoom = classR;
                        break;
                    }
                }

                for (Student student : studentList) {
                    if (student.getId() == studentId) {
                        isStudentFound = true;
                        currentStudent = student;
                        break;
                    }
                }

                if (!isClassRoomFound || !isStudentFound) {
                    System.out.println("Invalid class or Invalid student");
                    break;
                } else {
                    System.out.println("Student added Successfully\n");
                }

                currentClassRoom.addStudent(currentStudent);
                break;
            case 4:
                System.out.print("Enter class name: ");
                classRoomName = scanner.nextLine();

                System.out.print("Enter class section: ");
                classRoomSection = scanner.nextLine();

                isClassRoomFound = false; 
                currentClassRoom = null;

                for (ClassRoom classR : classRoomList) {
                    if (classR.getClassName().equalsIgnoreCase(classRoomName) &&
                            classR.getClassSection().equalsIgnoreCase(classRoomSection)) {
                        isClassRoomFound = true;
                        currentClassRoom = classR;
                        break;
                    }
                }

                if (isClassRoomFound) {
                    System.out.println(currentClassRoom);
                } else {
                    System.out.println("No class found!");
                }

                break;
            case 5:
                System.out.print("Enter class name: ");
                classRoomName = scanner.nextLine();

                System.out.print("Enter class section: ");
                classRoomSection = scanner.nextLine();

                isClassRoomFound = false;
                currentClassRoom = null;

                for (ClassRoom classR : classRoomList) {
                    if (classR.getClassName().equalsIgnoreCase(classRoomName) &&
                            classR.getClassSection().equalsIgnoreCase(classRoomSection)) {
                        isClassRoomFound = true;
                        currentClassRoom = classR;
                        break;
                    }
                }

                if (isClassRoomFound) {
                    fileOperation.writeToFile(currentClassRoom.toString());
                } else {
                    System.out.println("No class found!");
                }
                break;
            case 6:
                break;
            default:
                System.out.println("Invalid Choice! Try again!");
        }
    }
}
