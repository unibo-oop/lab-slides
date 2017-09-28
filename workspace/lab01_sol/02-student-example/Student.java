class Student {
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
}
