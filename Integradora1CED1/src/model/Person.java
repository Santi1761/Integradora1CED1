package model;

public class Person {
	private String name;
	private int id;
	private char gender;
	private int age;
	private String type_Atention;
	private int location;
	
	
	public Person(String name, int id, char gender, int age, String type_Atention) {
		super();
		this.name = name;
		this.id = id;
		this.gender = gender;
		this.age = age;
		this.type_Atention = type_Atention;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getType_Atention() {
		return type_Atention;
	}

	public void setType_Atention(String type_Atention) {
		this.type_Atention = type_Atention;
	}
	
	
	
	
	public int getLocation() {
		return location;
	}

	public void setLocation(int location) {
		this.location = location;
	}

	public int compareTo(Person p) {
		
		if(location < p.getLocation()) {
			
			return -1;
			
		} else if(location > p.getLocation()) {
			
			return 1;
		}
		
		return 0;
	}
	

}
