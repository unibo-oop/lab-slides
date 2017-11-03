class TestStudent {
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
