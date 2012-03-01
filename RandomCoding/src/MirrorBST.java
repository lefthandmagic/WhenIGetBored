
public class MirrorBST {


	void mirror(BSTNode node) {
		
		if(node == null) {
			return;
		}
		
		BSTNode tempNode = node.getLeftChild();
		node.setLeftChild(node.getRightChild());
		node.setRightChild(tempNode);
		
		mirror(node.getLeftChild());
		mirror(node.getRightChild());
		
	}
	

}
