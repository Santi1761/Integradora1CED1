package model;

public class MyHashMap<K, V> {

	private HMNode<K, V> first;

	public MyHashMap() {

		first = null;
	}

	public HMNode<K, V> getFirst() {
		return first;
	}

	public void setFirst(HMNode<K, V> first) {
		this.first = first;
	}

	public void put(K key, V value) {

		HMNode<K, V> newNode = new HMNode<>(key, value);

//		System.out.println(containsKey(key) + ", " + containsValue(value));

		if(first == null) {

			//			System.out.println("first = null");

			first = newNode;

		} else {

			//			System.out.println("else");

			if(!containsKey(key) && !containsValue(value)) {

				assignPosition(newNode, first);

			}

		}
		//		System.out.println("\nNew Node: " + newNode);

	}

	private void assignPosition(HMNode<K, V> newNode, HMNode<K, V> current) {

		//		System.out.println("Assign position");

		if(current.getNext() == null) {

			//			System.out.println("next = null");

			current.setNext(newNode);
			current.getNext().setPrev(current);

			//			System.out.println(newNode + " -> " + newNode.nextAndPrev());
			//			System.out.println(current + " -> " + current.nextAndPrev());

		} else {

			assignPosition(newNode, current.getNext());
		}
	}

	public V get(K key) {

		if(first.getKey() == key) {

			return first.getValue();

		} else {

			return findValueByKey(key, first);
		}
	}

	private V findValueByKey(K key, HMNode<K, V> current) {
		
		if(current != null) {
			
			if(current.getKey() == key) {
				
				return current.getValue();
				
			} else {
				
				return findValueByKey(key, current.getNext());
			}
		}
		
		return null;
	}

	public boolean containsKey(K key) {

		if (first != null) {

			if(first.getKey().equals(key)) {

				return true;

			} else {

				return findIfKeyExists(key, first.getNext());
			}
		}

		return false;
	}

	private boolean findIfKeyExists(K key, HMNode<K, V> current) {

		if(current != null) {

			if(current.getKey().equals(key)) {

				return true;

			} else {

				return findIfKeyExists(key, current.getNext());
			}
		}

		return false;
	}

	public boolean containsValue(V value) {

		//		System.out.println("First: " + first.getValue());
		//		System.out.println("Value: " + value);

		if (first != null) {

			if(first.getValue() == value) {

				return true;

			} else {

				return findIfValueExists(value, first.getNext());
			}

		}

		return false;
	}

	private boolean findIfValueExists(V value, HMNode<K, V> current) {

		if(current != null) {

			if(current.getValue().equals( value)) {

				return true;

			} else {

				return findIfValueExists(value, current.getNext());
			}
		}

		return false;
	}

	public void replace(K key, V value) {

		if(containsKey(key)) {

			if(first.getKey().equals(key)) {

				first.setValue(value);

			} else {

				findKeyOfValue(key, value, first.getNext());
			}
		}
	}

	private void findKeyOfValue(K key, V value, HMNode<K, V> current) {

		if(current.getKey().equals(key)) {

			current.setValue(value);

		} else {

			findKeyOfValue(key, value, current.getNext());
		}
	}

	public int size() {

		return count(first, 0);
	}

	private int count(HMNode<K, V> current, int count) {

		if(current != null) {

			return count(current.getNext(), count+1);
		} 

		return count;
	}

	@Override
	public String toString() {

		String line = "{";

		HMNode<K, V> current = first;

		while(current != null) {

			line += current.toString();

			if(current.getNext() != null) {

				line += ", ";
			}

			current = current.getNext();
		}

		line += "}";

		return line;
	}


	public static class HMNode<K, V> {

		private K key;
		private V value;
		private HMNode<K, V> next;
		private HMNode<K, V> prev;

		public HMNode(K key, V value) {
			this.key = key;
			this.value = value;
		}

		public K getKey() {
			return key;
		}

		public V getValue() {
			return value;
		}

		public HMNode<K, V> getNext() {
			return next;
		}

		public HMNode<K, V> getPrev() {
			return prev;
		}

		public void setKey(K key) {
			this.key = key;
		}

		public void setValue(V value) {
			this.value = value;
		}

		public void setNext(HMNode<K, V> next) {
			this.next = next;
		}

		public void setPrev(HMNode<K, V> prev) {
			this.prev = prev;
		}

		public String nextAndPrev() {

			return "Next=" + next + ", Prev=" + prev;
		}

		@Override
		public String toString() {

			return key + "=" + value;
		}
	}
}