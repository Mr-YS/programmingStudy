public class Graph
{
	LinkedList list;
	private int nv = 0;
	private int ne = 0;
	private LinkedList[] arr;

	public Graph(int nv){
		arr = new LinkedList[nv];
		for(int i=0;i<nv;i++)
		{
			arr[i] = new LinkedList();
		}
		this.nv = nv;
	}
	public String toString(){
		String str = "";
		str += "No.Edge = "+ne+"\n";
		for(int i=0;i<nv;i++)
		{
			str += i+" : "+arr[i].toStringId()+"\n";
		}

		return str;
	}

	public void set(int id1,int id2)
	{
		arr[id1].add(0,id2,1);
		arr[id2].add(0,id1,1);
		ne++;
	}
}
