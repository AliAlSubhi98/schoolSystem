package src;

import java.util.ArrayList;
import java.util.HashSet;

public class Student {
	ArrayList<Subject> studentSubjectList = new ArrayList<Subject>();
	HashSet<String> emailAddresses = new HashSet<String>();
    String name;
    String mail;//--------------------------------------------------------------------------------------------------
    public static void enterStudents() {
    	boolean repeat = true;
		while (repeat) {
			System.out.println("Enter Name");
			String name = Main.sc.next();
			Student newStudent = new Student();
			newStudent.name = name;
			for (int i = 0; i < Main.mySchool.subjectArray.size(); i++) {
				Subject newSubject = new Subject();
				newSubject.name = Main.mySchool.subjectArray.get(i);
				newStudent.studentSubjectList.add(newSubject);
			}
			Main.mySchool.studentList.add(newStudent);
			while (true) {
				System.out.println("Do you want to enter more name ??  ( y - n ) ");
				String option = Main.sc.next();
				if (option.equals("n")) {
					repeat = false;
					break;
				} else if (option.equals("y")) {
					break;
				} else {
					System.out.println("enter < y > to enter more names or < n > to close ");
				}
			}
		}
    }//-------------------------------------------------------------------------------------------------------------
    public static void enterStudentMail() {
		boolean mailing = true;
		while (mailing) {
			for (int i = 0; i < Main.mySchool.studentList.size(); i++) {
				System.out.println("[" + (i + 1) + "]" + Main.mySchool.studentList.get(i).name);
			}
			System.out.println("Select Student # to add an email  ");
			String stdNum11 = Main.sc.next();
			try {
				Integer stdNum1 = Integer.parseInt(stdNum11) - 1;
				if (stdNum1 < 0 || stdNum1 > Main.mySchool.studentList.size()) {
					System.out.println("Number of Student NOT included ");
				} else {
					boolean repeat2 = true;
					while (repeat2) {
						System.out.println("Enter The Email for Student : ");
						String inMail = Main.sc.next();
						Main.mySchool.studentList.get(stdNum1).emailAddresses.add(inMail);
						while (true) {
							System.out.println("Do you want to add more E-Mails?? (y-n) ");
							String moreMail = Main.sc.next();
							if (moreMail.equalsIgnoreCase("y")) {
								repeat2 = false;
								mailing = true;
								break;
							} else if (moreMail.equalsIgnoreCase("n")) {
								repeat2 = false;
								mailing = false;
								break;
							} else {
								System.out.println("Enter (y) to add mail (n) to back");
							}
						}
					}
				}
			} catch (Exception e) {
				System.err.println("try again and Choose Correct NUMBER :) ");
			}
		}
    }//--------------------------------------------------------------------------------------------------
    public static void searchStudent() {
		System.out.println("Enter Student Name to Search ");
		String search = Main.sc.next();
		int checkSearch = 0;
		for (int i = 0; i < Main.mySchool.studentList.size(); i++) {
			if (Main.mySchool.studentList.get(i).name.equals(search)) {
				System.out.println("School Name is : " + Main.mySchool.name);
				System.out.println("Student Name is : " + Main.mySchool.studentList.get(i).name);
				for (int j = 0; j < Main.mySchool.subjectArray.size(); j++) {
					System.out.println(Main.mySchool.subjectArray.get(j) + " is "
							+ Main.mySchool.studentList.get(i).studentSubjectList.get(j).mark.marks);
				}
				checkSearch = checkSearch + 1;
			} else if (checkSearch == 0) {
				System.out.println("There is no Student with " + search + " name");
			}
		}
    }
}
