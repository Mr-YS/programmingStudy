public class Main{
	public static void main(String[] args){
		int n = 10;
		int[] coinList = {5,3,1};
		System.out.println(Integer.MAX_VALUE);
		System.out.println(Integer.MAX_VALUE+1);
		System.out.println(Integer.MAX_VALUE*2);
		System.out.println("result: "+dynamicCP(10,coinList));
	}
	public static int dynamicCP(int n, int[] coinList)
	{	
		int[] arr = new int[n+1];
		for(int i=0;i<arr.length;i++)
		{
			arr[i] = Integer.MAX_VALUE;
		}
		arr[0] = 0;

		for(int i=0;i<arr.length;i++)
		{
			for(int j=0;j<coinList.length;j++)
			{
				if(i >= coinList[j])
				{	
					if(arr[i] > arr[i-coinList[j]] + 1)
						arr[i] = arr[i-coinList[j]] + 1;
				}
			}
			System.out.println("i= "+i+" +++ arrI= "+arr[i]);
		}	
		return arr[n];
	}
}
