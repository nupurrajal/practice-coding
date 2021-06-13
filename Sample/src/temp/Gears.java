package temp;

public class Gears {

	public static int[] solution(int[] pegs) {
        // Your code here
		int pegPossibility = 0;
		int[] error = new int[] {-1, -1};
		if (pegs.length == 1)
			return new int[] {pegs[0], 1};
		for (int pegIndex = 0; pegIndex < pegs.length; pegIndex++) {
			int onePow = (int) (Math.pow(-1, pegIndex+1));
			if (pegIndex == 0 || pegIndex == pegs.length-1) {
				pegPossibility += onePow * pegs[pegIndex];
			} else {
				pegPossibility += onePow * 2 * pegs[pegIndex];
			}
		}
		int result[] = new int[2];
		pegPossibility *= 2;
		if (pegs.length % 2 == 0) {
			if (pegPossibility % 3 != 0) {
				result = new int[] {pegPossibility, 3};
			} else {
				result = new int[] {pegPossibility / 3, 1};
			}
		} else {
			result = new int[] {pegPossibility, 1};
		}
		if (result[0] * result[1] < 2) {
			return error;
		}
		
		return result;
    }
	
	public static void main(String[] args) {
		int[] testArray = new int[] {4, 30, 50, 70};
		int[] result = solution(testArray);
		System.out.println(result[0] + " " + result[1]);
	}
}
