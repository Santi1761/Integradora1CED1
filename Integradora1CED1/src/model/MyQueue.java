package model;

public class MyQueue<Q> {

	private QNode<Q> head;

	public MyQueue() {
		head = null;
	}

	public QNode<Q> getHead() {
		return head;
	}

	public void setHead(QNode<Q> head) {
		this.head = head;
	}

	public void add(Q q) {

		QNode<Q> tail = new QNode<>(q);
		
		if(head == null) {
			
			head = tail;
			
		} else {
			
			add(head, tail);
		}
	}

	private void add(QNode<Q> current, QNode<Q> tail) {
		
		if(current != null) {
			
			if(current.getNext() == null) {
				
				current.setNext(tail);
				tail.setPrev(current);
				
			} else {
				
				add(current.getNext(), tail);
			}
		}
	}

	public Q element() {
		
		if(head != null) {
			
			return head.getQ();
		}
		
		return null;
	}
	

	public static class QNode<Q> {

		private Q q;
		private QNode<Q> next;
		private QNode<Q> prev;

		public QNode(Q q) {
			this.q = q;
			next = null;
			prev = null;
		}

		public Q getQ() {
			return q;
		}

		public QNode<Q> getNext() {
			return next;
		}

		public QNode<Q> getPrev() {
			return prev;
		}

		public void setQ(Q q) {
			this.q = q;
		}

		public void setNext(QNode<Q> next) {
			this.next = next;
		}

		public void setPrev(QNode<Q> prev) {
			this.prev = prev;
		}
	}
}