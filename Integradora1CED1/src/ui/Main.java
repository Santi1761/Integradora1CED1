package ui;

import java.util.Scanner;

public class Main {

	private Scanner sc;
	
	
	public Main() {
		this.sc = new Scanner(System.in);		
	}
	
	public static void main(String[] args) {
		Main main = new Main();
		main.menu();
	}
	
	public void menu() {
		System.out.println("////////////////////////////"+
									"\n	WELCOME"+
						"\n ///////////////////////// ");
		
		System.out.println("1) Register a person"+
						"\n 2) Show people"+
						"\n 3) Make an entry"+
						"\n 4) Make an exit"+
						"\n 5) Undo entry or exit"+
						"\n 6) CLOSE PROGRAM");
		int option = sc.nextInt();
		
		switch(option) {
			case 1:
				
				break;
			case 2:
				
				break;
			case 3:
				
				break;
			case 4:
				
				break;
			case 5:
				
				break;
			case 6:
				
				break;
			default:
				System.out.print("WRITE A VALID NUMBER");
		}

	}
}
