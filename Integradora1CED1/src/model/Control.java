package model;

public class Control {
	
	public Control() {
		
	}
	private HashTable<String, Person> patients;
	
	
	public boolean patientVerifier(String name) {
		return patients.search(name) != null;
		
	}
	
	public void add(String name, String id, int gender, int age, boolean priority, int level) {
		
	}
	
	public void depositLine(String name,  int option){
        
    }
	
	public String removeLine(int option) {
		return null;
        
    }
}
