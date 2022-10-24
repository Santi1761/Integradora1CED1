package model;

public class Control {
	
	
	private MyPriorityQueue<Person> entrance;
	private MyStack<Person> exit;
	private HashTable<String, Person> patients;
	
	
	public boolean patientVerifier(String name) {
		return patients.search(name) != null;
		
	}
	
	public Control() {
		entrance = new MyPriorityQueue<>();
		exit = new MyStack<>();
	}
	
	

	public MyPriorityQueue<Person> getEntrance() {
		return entrance;
	}



	public void setEntrance(MyPriorityQueue<Person> entrance) {
		this.entrance = entrance;
	}



	public MyStack<Person> getExit() {
		return exit;
	}



	public void setExit(MyStack<Person> exit) {
		this.exit = exit;
	}



	@Override
	public String toString() {
		return 
				"\n--Entrance: " + entrance + " Head: "  + entrance.peek().toString() +
				"\n--Exit: " + exit + " Head: " + exit.peek().toString();
	}



	
	public void add(String name, String id, int gender, int age, boolean priority, int level) {
		
	}
	
	public void depositLine(String name,  int option){
        
    }
	
	public String removeLine(int option) {
		return null;
        
    }
}
