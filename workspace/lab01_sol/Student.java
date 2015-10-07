public class Student {
    String name;
    String surname;
    int id;
    int matriculationYear;

    void build(int id, String name, String surname, int matriculationYear) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.matriculationYear = matriculationYear;
    }

    void printStudentInfo() {
        System.out.println("Student id: " + id);
        System.out.println("Student name: " + name);
        System.out.println("Student surname: " + surname);
        System.out.println("Student matriculationYear: " + matriculationYear);
    }

    public static void main(String[] args) {
        Student student = new Student();
        student.build(1014, "Mario", "Rossi", 2013);
        student.printStudentInfo();

        student = new Student();
        student.build(1015, "Luigi", "Gentile", 2012);
        student.printStudentInfo();

        student = new Student();
        student.build(1016, "Simone", "Bianchi", 2010);
        student.printStudentInfo();

        student = new Student();
        student.build(1017, "Andrea", "Bracci", 2012);
        student.printStudentInfo();
    }
}
