package model;

public class MyStack<S> {

	private SNode<S> head;

	public MyStack() {
		head = null;
	}

	public SNode<S> getHead() {
		return head;
	}

	public void setFirst(SNode<S> head) {
		this.head = head;
	}

	public SNode<S> peek() {

		if(head != null) return head;

		else return null;
	}

	public S pop() {

		if(head != null) {

			SNode<S> aux = head;
			head = head.getNext();

			return aux.getS();
		}

		return null;
	}

	public void push(S s) {

		if(head == null) {

			head = new SNode<>(s);

		} else {

			SNode<S> aux = head;
			SNode<S> newNode;
			newNode = new SNode<>(s);
			head = newNode;
			head.setNext(aux);
			aux.setPrev(head);
		}
	}

	public int size() {

		if(head == null) {

			return 0;

		} else if(head.getNext() == null) {

			return 1;

		} else {

			int i = 2;

			return count(head.getNext(), i);
		}
	}

	private int count(SNode<S> current, int i) {

		if(current != null) {

			if(current.getNext() == null) {

				return i;

			} else {


				return count(current.getNext(), i+1);
			}
		}

		return 0;
	}

	@Override
	public String toString() {

		String line = "[";

		if(head != null) {

			line += head.toString();
			SNode<S> current = head.getNext();
			boolean canContinue = true;

			while(canContinue) {

				if(current != null) {

					line += ", " + current;
					current = current.getNext();

				} else {

					canContinue = false;
				}
			}
		}

		line += "]";

		return line;
	}


	public static class SNode<S> {

		private S s;
		private SNode<S> next;
		private SNode<S> prev;

		public SNode(S s) {
			this.s = s;
			next = null;
			prev = null;
		}

		public S getS() {
			return s;
		}

		public SNode<S> getNext() {
			return next;
		}

		public SNode<S> getPrev() {
			return prev;
		}

		public void setS(S s) {
			this.s = s;
		}

		public void setNext(SNode<S> next) {
			this.next = next;
		}

		public void setPrev(SNode<S> prev) {
			this.prev = prev;
		}

		@Override
		public String toString() {
			return s.toString();
		}
	}
}