import java.util.*;

public class FibonacciSequence
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();	
		
		long s1 = System.currentTimeMillis();
		System.out.println(fiboRecursive(num));
		long e1 = System.currentTimeMillis();
		System.out.println("1: " + ( e1 - s1 )/1000.0 );
		long s2 = System.currentTimeMillis();
		System.out.println(fiboForLoop(num));
		long e2 = System.currentTimeMillis();
		System.out.println("2: " + ( e2 - s2 )/1000.0 );
		long s3 = System.currentTimeMillis();
		System.out.println(fiboDynamicProgramming(num));
		long e3 = System.currentTimeMillis();
		System.out.println("3: " + ( e3 - s3 )/1000.0 );
	}
	public static long fiboRecursive(int num)
	{	
		if(num == 2 || num == 1)
			return 1;
		return fiboRecursive(num - 1) + fiboRecursive(num - 2);
	}
	public static long fiboForLoop(int num)
	{
		long f1 = 1, f2 = 1;
		long temp;
		for(int i = 0;i<num-2;i++)
		{
			temp = f1;
			f1 += f2;
			f2 = temp;
		}
		return f1;
	}
	public static long fiboDynamicProgramming(int num)
	{
		long[] arr = new long[num];
		arr[0] = 1;
		arr[1] = 1;
		for(int i = 0;i<arr.length-2;i++)
			arr[i+2] = arr[i+1] + arr[i];

		return arr[num-1];
	}
}
