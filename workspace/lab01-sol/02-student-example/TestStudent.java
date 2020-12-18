class TestStudent {
  public static void main(String[] args) {
      Student mario = new Student();
      mario.build("Mario", "Rossi", 1014, 2019);
      mario.printStudentInfo();

      Student luigi = new Student();
      luigi.build("Luigi", "Gentile", 1015, 2019);
      luigi.printStudentInfo();

      Student simone = new Student();
      simone.build("Simone", "Bianchi", 1016, 2018);
      simone.printStudentInfo();

      Student andrea = new Student();
      andrea.build("Andrea", "Bracci", 1017, 2017);
      andrea.printStudentInfo();
  }
}
