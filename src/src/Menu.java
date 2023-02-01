package src;

public class Menu {
	int enterSetupCount = 0;
	int enterStudentCount = 0;
	int enterGradeCount = 0;
	int enterMailCount = 0;
	int enterPrintCount = 0;
	int enterSearchCount = 0;
	int enterStatisticsCount = 0;
	
	public void showSetupSchoolMenu() {
		System.out.println("[1] Enter Shcool Name ");
		System.out.println("[2] Enter Subjects ");
		System.out.println("[3] Go Back");
	}
	public static void showMainMenu() {
		System.out.println("Select Action ");
		System.out.println("[1] Setup School Details");
		System.out.println("[2] Enter Student");
		System.out.println("[3] Enter Grade");
		System.out.println("[4] Enter E-Mail Student");
		System.out.println("[5] Print All / Transcript");
		System.out.println("[6] Search Students");
		System.out.println("[7] App Statistics");
		System.out.println("[8] Exit");		
	}
	public static void showPrintMenu() {
		System.out.println("Choose : 1 / 2 ");
		System.out.println("[1] Download Transcript");
		System.out.println("[2] Search for a any words in txt.file");
		System.out.println("[2] Download Transcript with serilization");
		System.out.println("[4] Show Transcript");
	}
	public static void showStatsitics() {
		System.out.println(
				"_______________________________________________________________________________________________________________________");
		System.out.println("[1] Setup School Details " + Main.mainMenu.enterSetupCount);
		System.out.println("[2] Enter Student " + Main.mainMenu.enterStudentCount);
		System.out.println("[3] Enter Grade " + Main.mainMenu.enterGradeCount);
		System.out.println("[4] Enter E-Mail Student " + Main.mainMenu.enterMailCount);
		System.out.println("[5] Print All / Transcript " + Main.mainMenu.enterPrintCount);
		System.out.println("[6] Search Students " + Main.mainMenu.enterSearchCount);
		System.out.println("[7] App Statistics " + Main.mainMenu.enterStatisticsCount);
		System.out.println(
				"_______________________________________________________________________________________________________________________");
	}
}