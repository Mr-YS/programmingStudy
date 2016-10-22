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
		
		boolean[] mstSet = new boolean[matrix.length];
		
		for(int i=0;i<mstSet.length;i++)
			System.out.println(".::"+mstSet[i]);
		print(matrix);
		Vertex[] arr = converter(matrix);
		quickSort(arr,0,arr.length-1);
		print(arr);
		
		int sum = 0;

		for(int i=0;i<arr.length;i++)
		{
			if(mstSet[arr[i].getA()] == true && mstSet[arr[i].getB()] == true)
			{
				continue;
			}
			sum += arr[i].getWeight();
			System.out.println("sum:"+sum+"  a:"+arr[i].getA()+"  b:"+arr[i].getB());
			mstSet[arr[i].getA()] = true;
			mstSet[arr[i].getB()] = true;
		}
		System.out.println("mst = "+sum);
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
		Vertex temp;
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
				temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
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
	
	public int getA()
	{
		return a;
	}

	public int getB()
	{
		return b;
	}

	public void setWeight(int weight)
	{
		this.weight = weight;
	}
}
