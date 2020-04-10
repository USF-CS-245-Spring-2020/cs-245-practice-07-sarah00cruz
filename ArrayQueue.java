public class ArrayQueue<T> implements Queue<T> {
	private int front, back, count, capacity;
	private T[] arr;

	//constructor
	public ArrayQueue(){
		capacity = 10;
		front = 0;
		back = -1;
		count = 0;
		arr = (T[]) new Object[capacity];
	}

	//add item to back
	@Override
	public void enqueue(T item){
		++count;
		if (count == capacity)
			grow_array();
		arr[(++back) % (capacity)] = item;
	}

	//remove front, lessen size
	@Override
	public T dequeue() throws Exception{
		if(empty()) 
			throw new Exception("Stack is empty, grow array. ");
		count--;
		return arr[(front++) % (capacity)]; 
	}
	
	@Override
	public boolean empty(){
		return count == 0;
	}

	private void grow_array(){
		capacity *= 2;
		T[] temp = (T[]) new Object[capacity];
		for (int i = 0; i < arr.length; i++)
			temp[i] = arr[(front + i) % (arr.length)];
		arr = temp;
	}
}