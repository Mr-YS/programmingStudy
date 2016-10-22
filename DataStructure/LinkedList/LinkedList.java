public class LinkedList{
	class Node{
		private int id;
		private Object data;
		private Node next;
		private Node prev;
		
		//constructor
		public Node(int id, Object data){
			this.id = id;
			this.data = data;
			this.next = null;
			this.prev = null;
		}
		
		//int to String
		public String toString()
		{
			return String.valueOf(this.data);
		}
	}

	private Node head;
	private Node tail;
	private int size = 0;
	
	//making new list & adding new data
	public void add(int loc, int id, Object data){
		Node newNode = new Node(id, data);
		if(size == 0){
			head = newNode;
			tail = newNode;
		}
		else if(loc == 0){
			newNode.next = head;
			newNode.next.prev = newNode;
			head = newNode;
		}
		else if(loc == size){
			newNode.prev = tail;
			newNode.prev.next = newNode;
			tail = newNode;	
		}
		else{
			Node temp1 = search(loc-1);

			Node temp2 = temp1.next;
			temp1.next = newNode;
			newNode.next = temp2;
			temp2.prev = newNode;
			newNode.prev = temp1;			
		}	
		size++;
		return;
	}
	public Node search(int index){
		Node temp = head;
		for(int i=0;i<index;i++){
			temp = temp.next;
		}
		return temp;
	}
	public boolean checkNull(Object input){
		if(input == null)
			return false;
		return true;
	}
	public void remove(int loc){
		if(size == 0 || loc >= size)
		{
			System.out.println("[ERROR : size == 0, loc >= size]");
			return;
		}
		else if(loc == 0)
		{
			Node temp = head;
			head = temp.next;
			head.prev = null;
			temp = null;
		}
		else if(loc == size-1)
		{
			Node temp = tail;
			tail = temp.prev;
			tail.next = null;
			temp = null;
		}
		else
		{
			Node temp = search(loc-1);
			Node toBeDeleted = temp.next;
			temp.next = temp.next.next;
			temp.next.prev = temp;
			toBeDeleted = null;
		}
		size--;
		return;
	}
	public int[] getLoc(Object data){
		int count = 1;
		Node temp = head;
		
		int[] arr = new int[size+1];
		
		if(checkNull(data) == false)
		{
			arr[0] = -2;
			return arr;
		}
		for(int i=0;i<size-1;i++)
		{
			if(temp.data == data)
			{
				arr[count] = i;
				count++;
			}
			temp = temp.next;
		}
		arr[0] = count;

		return arr;
	}
	public void getLocPrint(Object data){
		int count = 0;
		int arrcount = 0;
		Node temp = head;
		
		int[] arr = new int[size];
		
		for(int i=0;i<arr.length-1;i++)
		{
			arr[i] = -1;
		}
		for(int i=0;i<size-1;i++)
		{
			if(temp.data == data)
			{
				count++;
				arr[arrcount] = i;
				arrcount++;
			}
			temp = temp.next;
		}
		System.out.print(count+" Results Found. Location of ["+data+"] : ");
		int j = 0;
		while(arr[j] != -1)
		{
			System.out.print("["+arr[j]+"]");
		}
	}
	public void removeOverlappingData()
	{
		Node temp1 = head;
		Node temp2;

		for(int i=0;i<size;i++)
		{
			temp2 = temp1.next;
			int j = i+1;
			while(temp2 != null)
			{
				if(temp1.data == temp2.data)
					remove(j);
				else
					j++;
				temp2 = temp2.next;
			}
			temp1 = temp1.next;
		}
	}
	public LinkedList reverse()
	{
		LinkedList list = new LinkedList();
		Node temp = head;
		
		while(temp != null)
		{
			list.add(0,temp.id,temp.data);
			temp = temp.next;
		}

		return list;
	}
	public void reversePrint()
	{
		Node temp = tail;

		System.out.print("{size = "+size+"}<Reverse Printer>[");
		while(temp.prev != null)
		{
			System.out.print(temp.data+",");
			temp = temp.prev;
		}
		System.out.println(temp.data+"]");
	}
	public void reverseOnlyNextChange()
	{
		Node temp1 = head;
		Node temp2 = temp1.next;
		Node temp3;

		for(int i=0;i<size-2;i++)
		{
			temp3 = temp2.next;
			temp2.next = temp1;
			temp1 = temp2;
			temp2 = temp3;
		}
		temp2.next = temp1;
		head.next = null;
		Node temp = head;
		head = tail;
		tail = temp;
	}
	public int size(){
		return size;
	}
	public Object getData(int loc){
		return search(loc).data;
	}
	public int getId(int loc){
		return search(loc).id;
	}
	Node node(int index)
	{
		Node x = head;
		for(int i=0;i<index;i++)
			x = x.next;
		return x;
	}
	public String toString()
	{
		if(head == null)
			return "{size = 0}[]";

		Node temp = head;
		String str = "{size = "+size+"}[";
		while(temp.next != null)
		{
			str += temp.data + ",";
			temp = temp.next;
		}
		str += temp.data;
		return str + "]";
	}
}
