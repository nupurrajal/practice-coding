package temp;

import java.util.HashMap;

public class Braille {

	public static HashMap<Character, String> brailleAlphabet = new HashMap();
    public static String capitalString = "000001";
    
    static {
        brailleAlphabet.put('a', "100000");
        brailleAlphabet.put('b', "110000");
        brailleAlphabet.put('c', "100100");
        brailleAlphabet.put('d', "100110");
        brailleAlphabet.put('e', "100010");
        brailleAlphabet.put('f', "110100");
        brailleAlphabet.put('g', "110110");
        brailleAlphabet.put('h', "110010");
        brailleAlphabet.put('i', "010100");
        brailleAlphabet.put('j', "010110");
        brailleAlphabet.put('k', "101000");
        brailleAlphabet.put('l', "111000");
        brailleAlphabet.put('m', "101100");
        brailleAlphabet.put('n', "101110");
        brailleAlphabet.put('o', "101010");
        brailleAlphabet.put('p', "111100");
        brailleAlphabet.put('q', "111110");
        brailleAlphabet.put('r', "111010");
        brailleAlphabet.put('s', "011100");
        brailleAlphabet.put('t', "011110");
        brailleAlphabet.put('u', "101001");
        brailleAlphabet.put('v', "111001");
        brailleAlphabet.put('w', "010111");
        brailleAlphabet.put('x', "101101");
        brailleAlphabet.put('y', "101111");
        brailleAlphabet.put('z', "101011");
        brailleAlphabet.put(' ', "000000");
    }
    
    public static String solution(String s) {
    	// Your code here
    	StringBuilder brailleResult = new StringBuilder();
		for (Character c : s.toCharArray()) {
			if (Character.isAlphabetic(c) && (Character.isUpperCase(c))) {
				brailleResult.append(capitalString);
				c = Character.toLowerCase(c);
			}
			brailleResult.append(brailleAlphabet.get(c));
		}
    	
    	return brailleResult.toString();
    }
    
    public static void main(String[] args) {
		String str = "The quick brown fox jumps over the lazy dog";
		System.out.println(solution(str));
	}
}
