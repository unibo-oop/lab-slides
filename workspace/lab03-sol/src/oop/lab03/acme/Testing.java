package oop.lab03.acme;

public class Testing {

	private Testing() {
		/*
		 *  Impedisce che si possa creare una classe Testing da fuori.
		 */
	}
	
	public static void main(final String[] args) {

		// 1)Creare 3 studenti a piacere
		final Student stud1 = new Student(1015, "Luigi", "Gentile", "1234", 2012);
		final Student stud2 = new Student(1016, "Simone", "Bianchi", "mamma", 2010);
		final Student stud3 = new Student(1017, "Andrea", "Bracci", "password", 2012);

		// 2)Creare 2 docenti a piacere
		final Professor prof1 = new Professor(2015, "Andrea", "Santi", "mypwd", new String[] { "OOP", "SISOP" });
		final Professor prof2 = new Professor(2015, "Danilo", "Pianini", "mypwd2", new String[] { "OOP", "FINFA" });

		// 3) Creare due aulee di esame, una con 100 posti una con 80 posti
		final ExamRoom vela = new ExamRoom(100, "VELA", true, true);
		final ExamRoom gpt1 = new ExamRoom(80, "GPT1", true, true);

		// 4) Creare due esami, uno con nMaxStudents=10, l'altro con
		// nMaxStudents=2
		final Exam exam1 = new Exam(10, 10, prof1.getCourses()[0], prof1, vela);
		final Exam exam2 = new Exam(11, 2, prof2.getCourses()[1], prof2, gpt1);

		// 5) Iscrivere tutti e 3 gli studenti agli esami
		exam1.registerStudent(stud1);
		exam1.registerStudent(stud2);
		exam1.registerStudent(stud3);
		exam2.registerStudent(stud1);
		exam2.registerStudent(stud2);
		exam2.registerStudent(stud3);

		// 6) Stampare in stdout la rapresentazione in stringa dei due esami
		System.out.println(exam1.toString());
		System.out.println(exam2.toString());
	}
}
