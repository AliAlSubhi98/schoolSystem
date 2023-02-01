package src;

public class Mark {
	int marks;
	public static void enterMark() {
		System.out.println("");
		if (Main.mySchool.studentList.size() == 0) {
			System.out.println("Enter Student First to add Marks ");
		} else if (Main.mySchool.subjectArray.size() == 0) {
			System.out.println("Enter Subject Frist ");
		} else {
			for (int i = 0; i < Main.mySchool.studentList.size(); i++) {
				System.out.println("[" + (i + 1) + "]" + Main.mySchool.studentList.get(i).name);
			}
			System.out.println("Select Student # ");
			String stdNumEntry = Main.sc.next();
			try {
				Integer stdNum = Integer.parseInt(stdNumEntry) - 1;
				if (stdNum < 0 || stdNum > Main.mySchool.studentList.size()) {
					System.out.println("Number of Student NOT included ");
				} else {
					boolean repeat1 = true;
					while (repeat1) {
						for (int i = 0; i < Main.mySchool.subjectArray.size(); i++) {
							System.out.println("[" + (i + 1) + "]"
									+ Main.mySchool.studentList.get(stdNum).studentSubjectList.get(i).name);
						}
						System.out.println("Select Subject # ");
						int subNum = Main.sc.nextInt() - 1;
						if (Main.mySchool.subjectArray.size() > subNum || subNum >= 0) { /////////////////////////
							System.out.println("Enter the mark of " + Main.mySchool.subjectArray.get(subNum));
							int stdMarkIn = Main.sc.nextInt();
							Main.mySchool.studentList.get(stdNum).studentSubjectList
									.get(subNum).mark.marks = stdMarkIn;
							System.out.println("Do you want to enter marks");
							String moreMarks = Main.sc.next();
							while (true) {
								if (moreMarks.equals("y")) {
									break;
								} else if (moreMarks.equals("n")) {
									repeat1 = false;
									break;
								} else {
									System.out.println("enter 'y' to enter mark for other Subject ");
									System.out.println("enter 'n' to go back ");
									break;
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
	}
}
