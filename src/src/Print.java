package src;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Print {
	public static void print() {
		Menu.showPrintMenu();
		String transcriptChoose = Main.sc.next();
		try {
			Integer transcrptChooseX = Integer.parseInt(transcriptChoose);
			if (transcrptChooseX == 1) {
				File folder = new File("C:\\Users\\Lenovo\\Documents\\Transcript");
				if (!folder.exists()) { // check if the folder not exist
					folder.mkdir(); // if not - create folder
				}
				File myFile = new File("C:\\Users\\Lenovo\\Documents\\Transcript\\Transcript.txt");
				try {
					FileWriter fw = new FileWriter(myFile, true);
					fw.write(
							"\n---------------------------------------------------------------------------------------------------------------------\n");
					fw.write(String.format("%20s %20s %30s %20s %20s\n", "SchoolName", "StudentName",
							"StudentMail", "Subject", "Mark"));
					fw.write(
							"---------------------------------------------------------------------------------------------------------------------\n");
					for (int i = 0; i < Main.mySchool.studentList.size(); i++) {
						for (int j = 0; j < Main.mySchool.subjectArray.size(); j++) {
							fw.write(String.format("%20s %20s %30s %20s %20s\n", Main.mySchool.name,
									Main.mySchool.studentList.get(i).name,
									Main.mySchool.studentList.get(i).emailAddresses, Main.mySchool.subjectArray.get(j),
									Main.mySchool.studentList.get(i).studentSubjectList.get(j).mark.marks));
						}
					}
					fw.close();
					System.out.println("THE TRANSCRIPT DOWNLOADED SUCCESSFULLY");
				} catch (IOException e) {
					System.out.println("Error in FileWriter");
					e.printStackTrace();
				}
			} else if (transcrptChooseX == 2) {
				// File f1=new File("input.txt"); //Creation of File Descriptor for input file
				String[] words = null;
				FileReader fr = new FileReader("C:\\Users\\Lenovo\\Documents\\Transcript\\Transcript.txt");
				BufferedReader br = new BufferedReader(fr);
				String s;
				System.out.println("Enter word to search in the file");
				String input = Main.sc.next();
				int counter = 0;
				while ((s = br.readLine()) != null) { // Reading Content from the file
					words = s.split(" ");// split words use spaces
					for (String word : words) {
						if (word.equals(input)) {
							counter++;
						}
					}
				}
				if (counter != 0) {// counter not equal 0
					System.out.println("the word " + input + " present for " + counter + " times in the file");
				} else {
					System.out.println("the word " + input + " does not found in the file");
				}
				br.close();
			} else if (transcrptChooseX == 3) {
				System.out.println("wait for the update soon..");
			} else if (transcrptChooseX == 4) {
				if (Main.mySchool.studentList.size() == 0) {
					System.out.println("Please Enter Student First");
				} else if (Main.mySchool.subjectArray.size() == 0) {
					System.out.println("Please Enter Subject First");
				} else {
					System.out.printf("%20s %20s %30s %20s %20s\n", "SchoolName", "StudentName", "StudentMail",
							"Subject", "Mark");
					System.out.println(
							"_______________________________________________________________________________________________________________________");
					for (int i = 0; i < Main.mySchool.studentList.size(); i++) {
						for (int j = 0; j < Main.mySchool.subjectArray.size(); j++) {
							System.out.printf("%20s %20s %30s %20s %20s\n", Main.mySchool.name,
									Main.mySchool.studentList.get(i).name,
									Main.mySchool.studentList.get(i).emailAddresses, Main.mySchool.subjectArray.get(j),
									Main.mySchool.studentList.get(i).studentSubjectList.get(j).mark.marks);
						}
					}
				}
			}
			else {
				System.out.println("Enter valid Input (1 / 2)");
			}
		}
		catch (Exception e) {
			System.out.println("Error in Transcript");
		}
	}
}
