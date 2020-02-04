package tree;

public class Solution {
	public static int getParent(int h, int q) {
		int maxNode = (int) Math.pow(2, h) - 1;
		// head
		if (q == maxNode) {
			return -1;
		}
		// left arm
		if (((q + 1) & q) == 0) {
			return ((q + 1) << 1) - 1;
		}
		// right arm
		if (q > maxNode - h) {
			return q + 1;
		}
		int nextPowerO2 = nextPowerOfTwo(q);
		if(nextPowerO2/2 >q) {
			return(getParent(h-1, q));
		}
		int half = nextPowerO2/2 -1;
		int p = power(q);
		int parent = getParent(p-1, q-half);
		if(parent ==-1) {
			return q+1;
		}
		return half+ parent;
	}

	public static int[] solution(int h, int[] q) {
		int[] sol = new int[q.length];
		for (int index = 0; index < q.length; index++) {
			sol[index] = getParent(h, q[index]);
		}
		return sol;
	}

	public static int nextPowerOfTwo(int no) {
		int value = 1;

		while (value <= no) {
			value = value << 1;
		}
		return value;
	}
	
	public static int power(int power) {
		int count =1;
		while(power >> 1 !=0) {
			count++;
			power = power >> 1;
		}
		return count;
	}

	public static void main(String[] args) {
		int[] test = new int[63];
		int k = 1;
		for (int j = 0; j < 63; j++) {
			test[j] = j + 1;
		}
		int[] ans = solution(6, test);
		for (int i : ans) {
			System.out.println(k + " " + i);
			k += 1;
		}

	}
}
