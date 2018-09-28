package oop.lab02.constructors;

public class Student {

    String name;
    String surname;
    int id;
    int matriculationYear;

    void build(final int id, final String name, final String surname, final int matriculationYear) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.matriculationYear = matriculationYear;
    }

    void printStudentInfo() {
        System.out.println("Student id: " + this.id);
        System.out.println("Student name: " + this.name);
        System.out.println("Student surname: " + this.surname);
        System.out.println("Student matriculationYear: " + this.matriculationYear + "\n");
    }

    public static void main(final String[] args) {
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
