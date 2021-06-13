package temp;

import java.util.Map;

class Tree {
	Tree left;
	Tree right;
	int value;
	
	
}

class List {
	int value;
	List next;
	
	List(int v) {
		this.value = v;
	}
}

public class MMTTest {

	public static boolean containsTargetSum(Tree rootNode, int targetSum, Map<Integer, Integer> vectorMap) {
		if (rootNode == null) {
			for (Map.Entry currRow : vectorMap.entrySet()) {
				int key = (Integer) currRow.getKey();
				int val = (Integer) currRow.getValue();
				if (key * 2 != targetSum) {
					if (vectorMap.containsKey(targetSum-key))
						return true;
				} else {
					return val > 1 ? true : false;
				}
			}
		}
		
		
//		vectorMap
		
		return false;
	}
	
	public static List mergeLinkedList(List A, List B) {
		List response = new List(0);
		List temp = response;
		while (A != null && B != null) {
			int tempVal;
			if (A.value < B.value) {
				
				tempVal = A.value;
				A = A.next;
			} else {
				
				tempVal = B.value;
				B = B.next;
			}
			
			List tempNode = new List(tempVal);
			temp.next = tempNode;
			temp = temp.next;
		}
		
		while (A != null) {
			List tempNode = new List(A.value); 
			temp.next = tempNode;
			A = A.next;
		}
		while (B != null) {
			List tempNode = new List(B.value); 
			temp.next = tempNode;
			B = B.next;
		}
		return response.next;
	}
	
	public static void main(String[] args) {
		Tree root = null; 
		
//		containsTargetSum( root.left, 6, 5);
//		containsTargetSum( root.right, 6, 5);
	}
	
}
/*				5
			6		2
		3	0		1	5

Step 1:
Node 6, 6, 5 => false				Node 2
	Node 3, 6, 5 => false
		Node ?, 6, 5 --> false




*/


/*
		 	   		|
A-> 21   42   57

		 	   |
B-> 15   45   98  100  101

					|
R-> 15  21  42  45  57	 89 1

*/