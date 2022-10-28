package ui;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import model.Control;

public class Main {

	private Scanner sc;
	private Control manager;
	
	public Main() {
		this.sc = new Scanner(System.in);
		manager = new Control();
	}
	
	public static void main(String[] args) {
		Main main = new Main();
		main.menu();
	}
	
	public void menu() {
		
		int option = 0;
		
		System.out.println("////////////////////////////"+
									"\n	WELCOME"+
						"\n ///////////////////////// ");
		
		System.out.println("1) Register a person"+
						"\n 2) Show people"+
						"\n 3) Make an entry"+
						"\n 4) Make an exit"+
						"\n 5) Undo entry or exit"+
						"\n 6) CLOSE PROGRAM");
		option = sc.nextInt();
		
		switch(option) {
			case 1:
				register();
				break;
			case 2:
				show();
				break;
			case 3:
				enter();
				break;
			case 4:
				out();
				break;
			case 5:
				edit();
				break;
			case 6:
				
				break;
			default:
				System.out.print("WRITE A VALID NUMBER");
		}
		
	}
	
	public void register() {
		System.out.print("Write the name of the person: ");
		String name = sc.nextLine();
		if(manager.patientVerifier(name)) {
			System.out.println("This name is already registered");
		}else {
			System.out.println("Write the id of the patient: ");
            String id = sc.nextLine();
            System.out.println("Write the gender:");
            System.out.println("1) Male");
            System.out.println("2) Female");
            int gender = Integer.parseInt(sc.nextLine());
            System.out.println("Write the age:");
            int age = Integer.parseInt(sc.nextLine());
            System.out.println("Require Priority?");
            System.out.println("1) Yes");
            System.out.println("2) No");
            int priority = Integer.parseInt(sc.nextLine());
            int level;
            if(priority == 1) {
                System.out.println("Write the level of priority");
                System.out.print("1,2,3,4,5");
                level = Integer.parseInt(sc.nextLine());
                while(level<1 || level>5){
                    System.out.println("Enter a valid option:\nFrom 1 to 5 how urgent is your attention");
                    level = Integer.parseInt(sc.nextLine());
                }
                manager.add(name, id, gender, age, true, level);
            } else {
                level = 0;
                manager.add(name, id, gender, age, false, level);
            }
		}
	}
	
	public void show() {
		System.out.println(" ");
	}
	
	public void enter() {
		System.out.println("Write the name: ");
        String name = sc.nextLine();
        if(!manager.patientVerifier(name)) {
            System.out.println("Register him");
        } else {
            System.out.println("Write the unity: ");
            System.out.println("1) Hematology");
            System.out.println("2) General purpose");
            int option = Integer.parseInt(sc.nextLine());
            manager.depositLine(name, option);
        }
	}
	
	public void out() {
		System.out.println("Write the unity: ");
        System.out.println("1) Hematology");
        System.out.println("2) General purpose");
        int option = Integer.parseInt(sc.nextLine());
        System.out.println(manager.removeLine(option));
	}
	
	public void edit() {
		System.out.println();
	}
	
	private void importData() throws IOException {
		
		char SEPARATOR=';';
		
		
		BufferedReader br = null;
	      
	      try {
	         
	         br =new BufferedReader(new FileReader("files/Libro1.csv"));
	         String line = br.readLine();
	         while (null!=line) {
	            String [] fields = line.split(",");
	            System.out.println(Arrays.toString(fields));
	            
	            fields = removeTrailingQuotes(fields);
	            System.out.println(Arrays.toString(fields));
	            
	            line = br.readLine();
	         }
	         
	      } catch (Exception e) {
	         
	      } finally {
	         if (null!=br) {
	            br.close();
	         }
	      }
	      
		
	}
	private static String[] removeTrailingQuotes(String[] fields) {
		char QUOTE='"';

	      String result[] = new String[fields.length];

	      for (int i=0;i<result.length;i++){
	         result[i] = fields[i].replaceAll("^"+QUOTE, "").replaceAll(QUOTE+"$", "");
	      }
	      return result;
	   }

}
