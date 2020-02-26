package transaction_app;

class Solution {
	public boolean isNumber(String s) {
		int flag =0;
		char[] example = s.toCharArray();
		if (resolveSpaces(example)) {
			for (int index = 0; index < example.length; index++) {
				int comp = example[index];
				if(Character.isDigit(example[index])) {
					flag = 1;
				}
				if (Character.isDigit(example[index]) || comp == ' ' || comp == 'e' || comp == 43 || comp == 45 || comp == 46) {
					if (index == example.length - 1 && flag ==1 ) {
						return true;
					}
					continue;
				}
				return false;
			}
		}
		return false;
	}

	public boolean resolveSpaces(char[] c) {
		int length = c.length;
		int flagS = 0;
		int flagE = length;
		int index = 0;
		if (c[0] == ' ') {
			while (c[index] == ' ' && index < flagE) {
				index++;
			}
			flagS = index;
		}
		if (c[length - 1] == ' ' && length >= 0) {
			while (c[length - 1] == ' ') {
				length--;
			}
			flagE = length;
		}
		for (int i = flagS; i < flagE; i++) {
			if (c[i] == ' ') {
				return false;
			} 
		}
		return true;
	}

	public static void main(String args[]) {
		Solution s = new Solution();
		String name = " 1000 ";
		char[] arr = name.toCharArray();
		System.out.println(s.isNumber(name));
		System.out.println(s.resolveSpaces(arr));

	}
}
