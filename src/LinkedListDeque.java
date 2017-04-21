
public class LinkedListDeque<Item> implements Deque<Item>{
	
	public class Node{
		public Item item;
		public Node next;
		public Node previous;
		
		public Node(Node p, Item i, Node n){
			this.item = i;
			this.next = n;
			this.previous = p;			
		}
	}
	
	private Node sentinel;
	private int size;
	
	public LinkedListDeque(){		
		size = 0;
		sentinel = new Node (null, null, null);
		//IMPORTANT!!!When list is empty, sentinel node should point to itself.
		sentinel.next=sentinel;
		sentinel.previous=sentinel;
	}
	
	public LinkedListDeque(Item i){
		size = 1;
		Node newNode = new Node(sentinel, i, sentinel);
		sentinel.next = newNode;
		sentinel.previous= newNode;
	}
	
	@Override
	public void addFirst(Item x) {
		size+=1;
		Item X = (Item)x;

		Node oldNode = sentinel.next;
		Node newNode = new Node(sentinel, X, oldNode);
		sentinel.next = newNode;
		oldNode.previous = newNode;
		}

	public Node getLastNode(){
		Node SearchNode = sentinel;
		while(SearchNode.next!=sentinel){
			SearchNode = SearchNode.next;
		}		
		return SearchNode;
	}
	@Override
	public void addLast(Item x) {
		size+=1;
		Item X = (Item)x;
		Node oldNode = getLastNode();
		Node newNode = new Node(oldNode, X, sentinel);
		oldNode.next = newNode;
		sentinel.previous = newNode;		
	}

	@Override
	public boolean isEmpty() {
		if (size ==0)
			return true;
		else
		return false;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public void printDeque() {
		Node lastNode = getLastNode();
		for(Node x = sentinel.next; x.next!=sentinel; x = x.next){
			Item i = x.item;
			System.out.print(i + " ");
			}
		System.out.print(lastNode + " ");
		System.out.println();
	}

	@Override
	public Item removeFirst() {
		//Don't forget to resize!!!
		size-=1;
		Node firstNode = sentinel.next;
		sentinel.next = firstNode.next;
		firstNode.previous = sentinel;
		return firstNode.item;		
	}

	@Override
	public Item removeLast() {
		//Don't forget to resize!!!
		size-=1;
		Node lastNode = getLastNode();
		lastNode.previous.next = sentinel;
		sentinel.previous = lastNode.previous;
		return lastNode.item;
		
	}

	@Override
	public Item get(int index) {
		Node currentNode = sentinel.next;

		for (int i=0; i<index; i++){
			currentNode = currentNode.next;
		}
		return currentNode.item;
	}
	
	public Node getRecursiveNode(int index){		
		return getRecursiveNode(index-1).next;	
	}
	
	public Item getRecursive(int index){
		return getRecursiveNode(index).item;
	}


}
