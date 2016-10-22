public class Main
{
	public static void main(String[] args)
	{
		Graph graph = new Graph(6);

		graph.set(0,1);
		graph.set(0,3);
		graph.set(0,5);
		graph.set(1,4);
		graph.set(1,5);
		graph.set(3,5);
		System.out.println(graph);
	}
}
