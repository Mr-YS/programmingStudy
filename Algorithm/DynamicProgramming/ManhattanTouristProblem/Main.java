public class Main
{
	public static void main(String[] args)
	{
		//Edge[][] arr = new Edge[4][4];
		int width = 4;
		int height = 4;
		
		int[][] right = {
							{1,2,5},
							{2,1,5},
							{2,3,4},
							{0,0,0}
						};
		int[][] down = {
							{5,3,10,5},
							{3,5,3,1},
							{0,0,5,2}
					   };
		
		int[][] mh = new int[height][width];
		
		mh[0][0] = 0;

		for(int j=1;j<width;j++)
		{
			mh[0][j] = mh[0][j-1] + right[0][j-1];
		}
		for(int i=1;i<height;i++)
		{
			mh[i][0] = mh[i-1][0] + down[i-1][0];
		}

		for(int i=1;i<height;i++)
		{
			for(int j=1;j<width;j++)
			{
				if(mh[i][j-1] + right[i][j-1] >= mh[i-1][j] + down[i-1][j])
				{
					mh[i][j] = mh[i][j-1] + right[i][j-1];
				}
				else
				{
					mh[i][j] = mh[i-1][j] + down[i-1][j];
				}
			}
		}

		System.out.println(mh[height-1][width-1]);
	}
}

 /*
class Edge
{
	public Edge(int right, int down)
	{
		this.right = right;
		this.down = down;
	}

	public String toString()
	{
		return "[right: "+right+"][down: "+down+"]";
	}

	private int right;
	private int down;

	public int getRight()
	{
		return right;
	}
	public int getDown()
	{
		return down;
	}
}*/
