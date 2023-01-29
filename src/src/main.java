package src;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		School mySchool = new School();
		Scanner sc = new Scanner(System.in);
		boolean doo = true;
		int enterSetupCount = 0;
		int enterStudentCount = 0;
		int enterGradeCount = 0;
		int enterMailCount = 0;
		int enterPrintCount = 0;
		int enterSearchCount = 0;
		int enterStatisticsCount = 0;
		while (doo) {
			System.out.println("Select Action ");
			System.out.println("[1] Setup School Details");
			System.out.println("[2] Enter Student");
			System.out.println("[3] Enter Grade");
			System.out.println("[4] Enter E-Mail Student");
			System.out.println("[5] Print All / Transcript");
			System.out.println("[6] Search Students");
			System.out.println("[7] App Statistics");
			System.out.println("[8] Exit");
			String action = sc.next();
			switch (action) {
			case "1": // setup school Details_______________________________
				enterSetupCount++;
				boolean case1 = true;
				while (case1) {
					System.out.println("[1] Enter Shcool Name ");
					System.out.println("[2] Enter Subjects ");
					System.out.println("[3] Go Back");
					String setup = sc.next();
					if (setup.equals("1")) {
						System.out.println("Enter Shcool Name ");
						String schoolName = sc.next();
						mySchool.name = schoolName;
					} else if (setup.equals("2")) {
						boolean setup2 = true;
						while (setup2) {
							System.out.println("Enter Subjects");
							String subjectStore = sc.next();
							Subject newSubject = new Subject();
							newSubject.name = subjectStore;
							mySchool.subjectArray.add(subjectStore);
							for (int i = 0; i < mySchool.studentList.size(); i++) {
								mySchool.studentList.get(i).studentSubjectList.add(newSubject);
							}
							while (true) {
								System.out.println("Do you want to enter more Subjects ? ");
								System.out.println("Enter Y or N  ");
								String select = sc.next();
								if (select.equals("y")) {
									break;
								} else if (select.equals("n")) {
									setup2 = false;
									break;
								} else {
									System.out.println("Enter Valid vlaue (Y or N)");
								}
							}
						}
					} else if (setup.equals("3")) {
						break;
					}
				}
				break;
			case "2": // enter students _______________________________________________
				enterStudentCount++;
				boolean repeat = true;
				while (repeat) {
					System.out.println("Enter Name");
					String name = sc.next();
					Student newStudent = new Student();
					newStudent.name = name;
					for (int i = 0; i < mySchool.subjectArray.size(); i++) {
						Subject newSubject = new Subject();
						newSubject.name = mySchool.subjectArray.get(i);
						newStudent.studentSubjectList.add(newSubject);
					}
					mySchool.studentList.add(newStudent);
					while (true) {
						System.out.println("Do you want to enter more name ??  ( y - n ) ");
						String option = sc.next();
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
				break;
			case "3": // enter grade menu _______________________________________________
				enterGradeCount++;
				System.out.println("");
				if (mySchool.studentList.size() == 0) {
					System.out.println("Enter Student First to add Marks ");
				} else if (mySchool.subjectArray.size() == 0) {
					System.out.println("Enter Subject Frist ");
				} 
				else {
					for (int i = 0; i < mySchool.studentList.size(); i++) {
						System.out.println("[" + (i + 1) + "]" + mySchool.studentList.get(i).name);
					}
					System.out.println("Select Student # ");
					String stdNumEntry = sc.next();
					try {
						Integer stdNum = Integer.parseInt(stdNumEntry) - 1;
						if (stdNum < 0 || stdNum > mySchool.studentList.size()) {
							System.out.println("Number of Student NOT included ");
						} else {
							boolean repeat1 = true;
							while (repeat1) {
								for (int i = 0; i < mySchool.subjectArray.size(); i++) {
									System.out.println("[" + (i + 1) + "]"
											+ mySchool.studentList.get(stdNum).studentSubjectList.get(i).name);
								}
								System.out.println("Select Subject # ");
								int subNum = sc.nextInt() - 1;
								if (mySchool.subjectArray.size() > subNum || subNum >= 0) { /////////////////////////
									System.out.println("Enter the mark of " + mySchool.subjectArray.get(subNum));
									int stdMarkIn = sc.nextInt();
									mySchool.studentList.get(stdNum).studentSubjectList
											.get(subNum).mark.marks = stdMarkIn;
									System.out.println("Do you want to enter marks");
									String moreMarks = sc.next();
									while (true) {

										if (moreMarks.equals("y")) {
											break;
										} else if (moreMarks.equals("n")) {
											repeat1 = false;
											break;
										} else {
											System.out.println("enter 'y' to enter mark for other Subject ");
											System.out.println("enter 'n' to go back ");
										}
									}
								} else {
									System.out.println("Enter valid # ");
								}
							}
						}
					}

					catch (Exception e) {
						System.err.println("try again and enter valid number :) ");
					}
				}
				break;
			case "4": // Enter Email For Student
						// __________________________________________________________
				enterMailCount++;
				for (int i = 0; i < mySchool.studentList.size(); i++) {
					System.out.println("[" + (i + 1) + "]" + mySchool.studentList.get(i).name);
				}
				boolean mailing = true;
				while (mailing) {
					System.out.println("Select Student # to add an email  ");
					int stdNum1 = sc.nextInt() - 1;
					if (stdNum1 < 0 || stdNum1 > mySchool.studentList.size()) {
						System.out.println("Number of Student NOT included ");
					} else {
						boolean repeat2 = true;
						while (repeat2) {
							System.out.println("Enter The Email for Student : ");
							String inMail = sc.next();
							mySchool.studentList.get(stdNum1).mail = inMail;
							System.out.println("Do you want to add more E-Mails?? (y-n) ");
							String moreMail = sc.next();
							while (true) {
								if (moreMail.equalsIgnoreCase("y")) {
									repeat2 = false;
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
				}
				break;
			case "5": // print all
						// _____________________________________________________________________
				enterPrintCount++;
				System.out.printf("%20s %20s %30s %20s %20s\n", "SchoolName", "StudentName", "StudentMail", "Subject",
						"Mark");
				System.out.println(
						"_______________________________________________________________________________________________________________________");
				for (int i = 0; i < mySchool.studentList.size(); i++) {
					for (int j = 0; j < mySchool.subjectArray.size(); j++) {
						System.out.printf("%20s %20s %30s %20s %20s\n", mySchool.name, mySchool.studentList.get(i).name,
								mySchool.studentList.get(i).mail, mySchool.subjectArray.get(j),
								mySchool.studentList.get(i).studentSubjectList.get(j).mark.marks);
					}
				}
				break;
			case "6": // search
						// Student_________________________________________________________________
				enterSearchCount++;
				System.out.println("Enter Student Name to Search ");
				String search = sc.next();
				int checkSearch = 0;
				for (int i = 0; i < mySchool.studentList.size(); i++) {
					if (mySchool.studentList.get(i).name.equals(search)) {
						System.out.println("School Name is : " + mySchool.name);
						System.out.println("Student Name is : " + mySchool.studentList.get(i).name);
						for (int j = 0; j < mySchool.subjectArray.size(); j++) {
							System.out.println(mySchool.subjectArray.get(j) + " is "
									+ mySchool.studentList.get(i).studentSubjectList.get(j).mark.marks);
						}
						checkSearch = checkSearch + 1;
					} else if (checkSearch == 0) {
						System.out.println("There is no Student with " + search + " name");
					}
				}
				break;
			case "7":// statitstics___________________________________________________________
				enterStatisticsCount++;
				System.out.println(
						"_______________________________________________________________________________________________________________________");
				System.out.println("[1] Setup School Details " + enterSetupCount);
				System.out.println("[2] Enter Student " + enterStudentCount);
				System.out.println("[3] Enter Grade " + enterGradeCount);
				System.out.println("[4] Enter E-Mail Student " + enterMailCount);
				System.out.println("[5] Print All / Transcript " + enterPrintCount);
				System.out.println("[6] Search Students " + enterSearchCount);
				System.out.println("[7] App Statistics " + enterStatisticsCount);
				System.out.println(
						"_______________________________________________________________________________________________________________________");
				break;
			case "8":// ________________________________________________________________________
				doo = false;
				break;
			default:
				System.out.println(
						"_______________________________________________________________________________________________________________________");
				System.out.println("enter valid number brooooooooooo -_- oooooooooooooo");
				System.out.println(
						"_______________________________________________________________________________________________________________________");
			}
		}
		sc.close();

	}
}
