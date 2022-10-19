package model;

public class MyPriorityQueue<P extends Person> {

	private PQNode<P> root;

	public MyPriorityQueue() {
		root = null;
	}

	public PQNode<P> getRoot() {
		return root;
	}

	public void setRoot(PQNode<P> root) {
		this.root = root;
	}

	public PQNode<P> peek() {

		return root;
	}

	public void offer(P p) {

		PQNode<P> newNode = new PQNode<>(p);

		if(root == null) {

			root = newNode;

		} else {

			offer(root, newNode);
		}
	}

	private PQNode<P> offer(PQNode<P> current, PQNode<P> newNode) {

		//		System.out.println("\n" + newNode.getP().getName() + " in node form: " + newNode.nodeForm());
		//		
		//		System.out.println(current.getP().getName() + " location: " + current.getP().getLocation());
		//		System.out.println(newNode.getP().getName() + " location: " + newNode.getP().getLocation());

		if(current != null) {

			if(newNode.getP().getLocation() < current.getP().getLocation()) {

				if(current.getLeft() == null) {

					current.setLeft(newNode);
					newNode.setParent(current);
					//					System.out.println(newNode.getP().getName() + " in node form: " + newNode.nodeFormat());
					return newNode;

				}  else {

					return offer(current.getLeft(), newNode);
				}
			} 

			if(newNode.getP().getLocation() > current.getP().getLocation()) {

				if(current.getRight() == null) {

					current.setRight(newNode);
					newNode.setParent(current);
					//					System.out.println(newNode.getP().getName() + " in node form: " + newNode.nodeFormat());
					return newNode;

				} else {

					return offer(current.getRight(), newNode);
				}
			}
		}

		return newNode;
	}

	public int size() {

		if(root == null) {

			return 0;

		} else {

			return count(root, 1);
		}
	}

	private int count(PQNode<P> current, int count) {

		if(current != null) {

			if(current.getLeft() != null) {

				count = count + 1;
				count = count(current.getLeft(), count);
			}

			if(current.getRight() != null) {

				count = count + 1;
				count = count(current.getRight(), count);
			}
		} 

		return count;
	}

	public P poll() {

		if(root != null) {

						System.out.println("Poll Root: " + root);

			PQNode<P> oldRoot = root;
			PQNode<P> minNode = null;

			if(root.getRight() != null) {

				minNode = minValueByRight(root.getRight());

			} else if(root.getLeft() != null){

				minNode = root.getLeft();
			}

			if(minNode != null) {

								System.out.println("Min: " + minNode.nodeFormat());

				minNode.setParent(null);
				minNode.setRight(root.getRight());
				minNode.setLeft(root.getLeft());

				root = minNode;

			} else {

				root = null;
			}

			return oldRoot.getP();
		} 

		return null;
	}

	private PQNode<P> minValueByRight(PQNode<P> current) {

		if(current != null) {

			if(current.getLeft() != null) {

				return minValueByRight(current.getLeft());
			}
		}

		return current;
	}


	public static class PQNode<P> {

		private P p;
		private PQNode<P> left;
		private PQNode<P> right;
		private PQNode<P> parent;

		public PQNode(P p) {
			this.p = p;
			left = null;
			right = null;
			parent = null;
		}

		public P getP() {
			return p;
		}

		public PQNode<P> getLeft() {
			return left;
		}

		public PQNode<P> getRight() {
			return right;
		}

		public PQNode<P> getParent() {
			return parent;
		}

		public void setP(P p) {
			this.p = p;
		}

		public void setLeft(PQNode<P> left) {
			this.left = left;
		}

		public void setRight(PQNode<P> right) {
			this.right = right;
		}

		public void setParent(PQNode<P> parent) {
			this.parent = parent;
		}

		@Override
		public String toString() {
			return p.toString();
		}

		public String nodeFormat() {

			String line = "";

			if(parent != null) {

				line += parent.nodeFormat() + " => ";
			}

			line += "[" + left + " <- "+ p.toString() + " -> " + right + "]";

			return line;

			//			return parent.toString()+ " -> [" + left + " <- " + p.toString() + " -> " + right + "]";
		}
	}
}