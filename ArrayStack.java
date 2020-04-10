public class ArrayStack<T> implements Stack<T>{
	private int top;
	private int size;
	private T[] arr;

	//constructor
	public ArrayStack(){
		size = 10;
		top = 0;
		arr = (T[]) new Object[size];
	}

	@Override
	public void push(T item){
		if (top == size)
			grow_array();
		arr[top++] = item;
	}

	@Override
	public T pop() throws Exception{
		//base case if stack is empty
		if(empty()) 
			throw new Exception("Stack is empty, nothing to return.");
		return arr[--top];
	}

	@Override
	public T peek() throws Exception{
		//base case if stack is empty
		if(empty()) 
			throw new Exception("Stack is empty, nothing to return.");
		return arr[top];
	}

	@Override
	public boolean empty(){
		return top == 0;
	}

	private void grow_array(){
		size *= 2;
		T[] temp = (T[]) new Object[size];
		for(int i = 0;i<top; i++)
			temp[i] = arr[i];
		arr = temp;
	}
}