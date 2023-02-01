package src;

import java.util.ArrayList;

public class School {
	String name;
	ArrayList<String> subjectArray = new ArrayList<String>();
	ArrayList<Student> studentList = new ArrayList<Student>();

	public static void editSchool() {
		boolean case1 = true;
		while (case1) {
			Main.mainMenu.showSetupSchoolMenu();
			String setup = Main.sc.next();
			if (setup.equals("1")) {
				System.out.println("Enter Shcool Name ");
				String schoolName = Main.sc.next();
				Main.mySchool.name = schoolName;
			} else if (setup.equals("2")) {
				boolean setup2 = true;
				while (setup2) {
					System.out.println("Enter Subjects");
					String subjectStore = Main.sc.next();
					Subject newSubject = new Subject();
					newSubject.name = subjectStore;
					Main.mySchool.subjectArray.add(subjectStore);
					for (int i = 0; i < Main.mySchool.studentList.size(); i++) {
						Main.mySchool.studentList.get(i).studentSubjectList.add(newSubject);
					}
					while (true) {
						System.out.println("Do you want to enter more Subjects ? ");
						System.out.println("Enter Y or N  ");
						String select = Main.sc.next();
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
	}
}
