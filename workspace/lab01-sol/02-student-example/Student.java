class Student {
    int id;
    String name;
    String surname;
    int matriculationYear;

    void build(String name, String surname, int id, int matriculationYear) {
        this.name = name;
        this.surname = surname;
        this.id = id;
        this.matriculationYear = matriculationYear;
    }

    void printStudentInfo() {
        System.out.println("Student name: " + name);
        System.out.println("Student surname: " + surname);
        System.out.println("Student id: " + id);
        System.out.println("Student matriculationYear: " + matriculationYear);
    }
}
