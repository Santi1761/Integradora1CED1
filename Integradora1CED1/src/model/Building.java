package model;

public class Building {
	
	
	private char id;
	private Control control;
	private MyHashMap<Integer, MyQueue<Person>> laboratory_units;
	
	public Building(char id) {
		this.id = id;
		control = new Control();
		laboratory_units = new MyHashMap<>();
	}

	public char getId() {
		return id;
	}

	public void setId(char id) {
		this.id = id;
	}

	public Control getControl() {
		return control;
	}

	public void setControl(Control control) {
		this.control = control;
	}

	public MyHashMap<Integer, MyQueue<Person>> getLaboratory_units() {
		return laboratory_units;
	}

	public void setLaboratory_units(MyHashMap<Integer, MyQueue<Person>> laboratory_units) {
		this.laboratory_units = laboratory_units;
	}

	@Override
	public String toString() {
		return " [id=" + id + "/n"+", control=" + control + "/n" + ", laboratory_units=" + laboratory_units + "]";
	}
	
	

}
