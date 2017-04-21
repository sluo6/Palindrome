public class ArrayDeque<Item> implements Deque<Item>{
	private Item[] items;
	private int size;
	private int nextFirst;
	private int nextLast;
	private int arraySize;
	private int newSize;
	
	private static int FACTOR=2;
	
	public ArrayDeque(){
		size = 0;
		nextFirst = 0;
		nextLast = 1;
		arraySize = 8;
		items = (Item[]) new Object[arraySize];
	}
	
	/*reSize the array when array is too small or too large*/
	private void reSize(int capacity){
		Item[] copyTo = (Item[]) new Object[capacity];
		for(int i=0; i<size; i++){
			copyTo[i]= get(i);
		}
			nextFirst = capacity - 1;
			nextLast = size;
			items = copyTo;
			arraySize = newSize;		
	}
	
	private int minusOne(int index){
		int position;
		if(index==0){
			position = arraySize - 1;
		}
		else{
			position = index - 1;
		}
		return position;
	}
	
	private int plusOne(int index){
		int position;
		position = (index + 1)%arraySize;
		return position;
	}
	
	@Override
	public void addFirst(Object x) {
		if (size == arraySize){
			newSize=arraySize*FACTOR;
			reSize(newSize);			
		}
		size+=1;
		items[nextFirst]=(Item)x;
		nextFirst = minusOne(nextFirst);		
	}

	@Override
	public void addLast(Object x) {
		if (size == arraySize){
			newSize=arraySize*FACTOR;
			reSize(newSize);			
		}
		size+=1;
		items[nextLast]=(Item)x;
		nextLast = plusOne(nextLast);
	}

	@Override
	public boolean isEmpty() {
		if (size==0){
			return true;
		}
		else
			return false;
	}

	@Override
	public int size() {		
		return size;
	}

	@Override
	public void printDeque() {
		int i = plusOne(nextFirst);
		int j = 0;
		while (j<size){
			System.out.println(j + " "+ items[i]);
			System.out.println(" ");
			i=plusOne(i);
			j+=1;
		}		
	}

	@Override
	public Item removeFirst() {
		if(arraySize/size>FACTOR){
			newSize=arraySize/FACTOR;
			reSize(newSize);	
		}
		size-=1;
		int position = plusOne(nextFirst);	
		Item removed = items[position];
		items[position]	= null;
		nextFirst = plusOne(nextFirst);
		return removed;
	}

	@Override
	public Item removeLast() {
		if(arraySize/size>FACTOR){
			newSize=arraySize/FACTOR;
			reSize(newSize);
		}
		size-=1;
		int position = minusOne(nextLast);
		Item removed = items[position];
		items[position]= null;
		nextLast = minusOne(nextLast);		
		return removed;
	}

	@Override
	public Item get(int index) {
		int position = (nextFirst + index+1)%arraySize;
		return items[position];
	}

}