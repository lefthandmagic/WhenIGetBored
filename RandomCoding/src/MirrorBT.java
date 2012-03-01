
public class MirrorBT {


	void mirror(BTNode node) {
		
		if(node == null) {
			return;
		}
		
		BTNode tempNode = node.getLeftChild();
		node.setLeftChild(node.getRightChild());
		node.setRightChild(tempNode);
		
		mirror(node.getLeftChild());
		mirror(node.getRightChild());
		
	}
	

}
