class TestStudent {
  public static void main(String[] args) {
      Student mario = new Student();
      mario.build(1014, "Mario", "Rossi", 2013);
      mario.printStudentInfo();

      Student luigi = new Student();
      luigi.build(1015, "Luigi", "Gentile", 2012);
      luigi.printStudentInfo();

      Student simone = new Student();
      simone.build(1016, "Simone", "Bianchi", 2010);
      simone.printStudentInfo();

      Student andrea = new Student();
      andrea.build(1017, "Andrea", "Bracci", 2012);
      andrea.printStudentInfo();
  }
}
