public class Main
{
	public static void main(String[] args)
	{
		LinkedList list = new LinkedList();

		list.add(0,0,0);
		list.add(1,1,1);
		list.add(2,2,2);
		list.add(3,3,3);
		list.add(4,4,4);
		list.add(5,5,5);
		list.add(6,6,4);
		list.add(7,7,3);
		list.add(8,8,2);
		list.add(9,9,1);
		list.add(10,10,0);
		System.out.println(list);
		list.remove(8);
		list.remove(8);
		list.remove(8);
		System.out.println(list);
		list.removeOverlappingData();
		System.out.println(list);
		LinkedList reverse = list.reverse();
		System.out.println(reverse);
		list.reversePrint();
	}
}
