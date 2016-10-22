public class Main
{
	public static void main(String[] args)
	{
		int numNode = 5;

		int[][] matrix = {
							{0,5,10,8,7},
							{5,0,5,3,6},
							{10,5,0,1,3},
							{8,3,1,0,1},
							{7,6,3,1,0}
						 };
		
		boolean[] temp = new boolean[matrix.length];
		
		for(int i=0;i<temp.length;i++)
			System.out.println(".::"+temp[i]);
		print(matrix);
		Vertex[] arr = converter(matrix);
		quickSort(arr,0,arr.length-1);
		print(arr);
	}
	public static void print(Vertex[] arr)
	{
		System.out.print("[");
		for(int i=0;i<arr.length;i++)
			System.out.print(arr[i]);
		System.out.print("]");
	}
	public static void print(Object[] arr)
	{	
		System.out.print("[");
		for(int i=0;i<arr.length;i++)
			System.out.print(arr[i]+",");
		System.out.println("]");
	}
	public static void print(int[][] arr)
	{
		for(int i=0;i<arr.length;i++)
		{
			for(int j=0;j<arr[i].length;j++)
			{
				System.out.print(arr[i][j]+"/");
			}
			System.out.println();
		}
	}
	public static boolean check(int[] arr)
	{
		return true;
	}
	public static Vertex[] converter(int[][] arr)
	{
		int n = arr.length;
		Vertex[] temp = new Vertex[(n*n-n)/2];
		
		int count = 0;
		for(int i=0; i<n; i++)
		{
			for(int j=0; j<i; j++)
			{
				temp[count] = new Vertex(arr[i][j],i,j);
				count++;
			}
		}

		for(int i=0;i<temp.length;i++)
			System.out.println("[[["+temp[i].getWeight()+"}}}");

		return temp;
	}
	public static void quickSort(Vertex[] arr, int left, int right)
	{
		int count = partition(arr, left, right);
		if(left < count - 1)
		{
			quickSort(arr, left, count -1);
		}
		if(count < right)
		{
			quickSort(arr, count, right);
		}
	}
	public static int partition(Vertex[] arr, int left, int right)
	{
		int i = left;
		int j = right;
		int temp;
		int pivot = arr[(left+right)/2].getWeight();

		while(i<=j)
		{
			while(arr[i].getWeight() < pivot)
			{
				i++;
			}
			while(arr[j].getWeight() > pivot)
			{
				j--;
			}
			if(i<=j) {
				temp = arr[i].getWeight();
				arr[i].setWeight(arr[j].getWeight());
				arr[j].setWeight(temp);
				i++;
				j--;
			}
		}
		return i;
	}
}

class Vertex
{
	public Vertex(int weight, int a, int b)
	{
		this.weight = weight;
		this.a = a;
		this.b = b;
	}
	public String toString()
	{
		return "(w:"+weight+",a:"+a+",b:"+b+")";
	}

	private int weight;
	private int a;
	private int b;

	public int getWeight()
	{
		return weight;
	}

	public void setWeight(int weight)
	{
		this.weight = weight;
	}
}
