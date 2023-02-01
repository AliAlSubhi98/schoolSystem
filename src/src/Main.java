package src;


import java.util.Scanner;

public class Main {
	static School mySchool = new School();
	static Scanner sc = new Scanner(System.in);
	static Menu mainMenu = new Menu();
	public static void main(String[] args) {
		boolean doo = true;
		while (doo) {
			Menu.showMainMenu();
			String action = Main.sc.next();
			switch (action) {
			case "1": // setup school Details___________________________________________________________________________________________________
				mainMenu.enterSetupCount++;
				School.editSchool();
				break;
			case "2": // enter students ________________________________________________________________________________________________________
				mainMenu.enterStudentCount++;
				Student.enterStudents();
				break;
			case "3": // enter grade menu ______________________________________________________________________________________________________
				mainMenu.enterGradeCount++;
				Mark.enterMark();
				break;
			case "4": // Enter Email For Student// _____________________________________________________________________________________________
				mainMenu.enterMailCount++;
				Student.enterStudentMail();
				break;
			case "5": // print all_____________________________________________________________________________________________________________
				mainMenu.enterPrintCount++;
				Print.print();
				break;
			case "6": // searchStudent__________________________________________________________________________________________________________
				mainMenu.enterSearchCount++;
				Student.searchStudent();
				break;
			case "7":// statitstics_____________________________________________________________________________________________________________
				mainMenu.enterStatisticsCount++;
				Menu.showStatsitics();
				break;
			case "8":// ________________________________________________________________________________________________________________________
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
	}
}
