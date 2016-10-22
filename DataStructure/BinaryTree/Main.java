public class Main
{
	public static void main(String[] args)
	{
		BinaryTree tree = new BinaryTree();

		tree.add(5);
		tree.add(7);
		tree.add(3);
		tree.add(2);
		tree.add(6);
		tree.add(8);
		tree.add(4);
		tree.postOrder();
		System.out.println("mc + "+tree.minimumChild(tree.getRoot())+" ... ");
		/*tree.remove(2);
		tree.remove(3);
		tree.remove(7);*/
		tree.remove(5);
		tree.postOrder();
	}
}
