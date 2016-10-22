public class BinaryTree
{
	class Node{
		private int data;
		private Node left;
		private Node right;

		public Node(int data){
			this.data = data;
			this.left = null;
			this.right = null;
		}

		public String toString()
		{
			return String.valueOf(this.data);
		}
	}	

	private Node root;
	private int size = 0;

	public void add(int data)
	{
		Node newNode = new Node(data);
		if(size == 0)
		{
			root = newNode;
			size++;
			return;
		}	
		add(newNode, root);
	}
	public void add(Node newNode, Node target)
	{
		if(newNode.data < target.data && target.left == null)
		{
			target.left = newNode;
		}
		else if(newNode.data > target.data && target.right == null)
		{
			target.right = newNode;
		}
		else if(newNode.data < target.data && target.left != null)
		{
			add(newNode,target.left);
		}
		else if(newNode.data > target.data && target.right != null)
		{
			add(newNode,target.right);
		}
		else
		{
			System.out.println("Your input is already existing.");
		}
		return;
	}
	public void postOrder()
	{
		postOrder(root);
	}
	public void postOrder(Node target)
	{
		if(target == null)
			return;
		postOrder(target.left);
		postOrder(target.right);
		System.out.print(target.data+",");
	}
	public void remove(int data)
	{
		if(size == 0)
			return;

		Node target = root;
		Node targetParent = null;
		boolean left = true;

		while(true)
		{
			if(target.data == data)
				break;
			else if(target.data < data)
			{
				targetParent = target;
				target = target.right;
				left = false;
			}
			else
			{
				targetParent = target;
				target = target.left;
				left = true;
			}
		}
		System.out.println("ct:"+target+"/////");
		System.out.println("ctp:"+targetParent+"/////");
		
		if(checkChild(target) == 0)
		{
			if(left == true)
				targetParent.left = null;
			else
				targetParent.right = null;
		}
		else if(checkChild(target) == 1)
		{
			if(left == true)
			{
				if(target.left != null)
					targetParent.left = target.left;
				else
					targetParent.left = target.right;
			}
			else
			{
				if(target.left != null)
					targetParent.right = target.left;
				else
					targetParent.right = target.right;
			}
		}
		else if(checkChild(target) == 2)
		{	
			Node temp = minimumChild(target);
			remove(minimumChild(target).data);
			temp.left = target.left;
			temp.right = target.right;
			if(targetParent != null)
			{
				if(left == true)
					targetParent.left = temp;
				else
					targetParent.right = temp;
			}
		}
		target = null;
	}
	public int checkChild(Node target)
	{
		if(target == null)
			return -1;
		else if(target.left == null && target.right == null)
			return 0;
		else if(target.left == null || target.right == null)
			return 1;
		return 2;
	}
	public Node getRoot()
	{
		return root;
	}
	public Node minimumChild(Node target)
	{	
		if(target.left == null)
			return target;
		else
			return minimumChild(target.left);
	}
}
