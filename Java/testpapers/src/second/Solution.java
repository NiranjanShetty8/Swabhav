package second;

public class Solution {

	public static int[] solution(int h, int[] q) {
		int sol[] = new int[q.length];
		int root = (int) Math.pow(2, h) - 1;
		for (int index = 0; index < q.length; index++) {
			if (q[index] <= 0 || q[index] >= root) {
				sol[index] = -1;
				continue;
			} else if (q[index] >= root - (h - 1)) {
				sol[index] = q[index] + 1;
				continue;
			} else if (q[index] == 2) {
				sol[index] = 3;
				continue;
			} else if ((((q[index]) & q[index] + 1)) == 0) {
				sol[index] = (q[index] * 2) + 1;
				continue;
			} else if ((((q[index]) & q[index] - 1)) == 0) {
				sol[index] = (q[index] + 2);
				continue;
			} else if ((((q[index]) & q[index] + 2)) == 0) {
				sol[index] = q[index] + 1;
				continue;
			} else if (((((q[index]) - 1) & (q[index] - 2) - 1)) == 0) {
				sol[index] = (q[index] + 1);
				continue;
			}  else if (((((q[index]) - 2) & (q[index] - 3) - 1)) == 0) {
				sol[index] = (q[index] + 4);
				continue;
			} else if (((((q[index]) - 3) & (q[index] - 4) - 1)) == 0) {
				sol[index] = (q[index] + 2);
				continue;
			} else if (q[index] % 3 == 0) {
				sol[index] = q[index] + 1;
				continue;
			}else {
				System.out.println("here is " + q[index]);
				sol[index] = q[index] + 1;
			}
		}
		return sol;
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
//public int arrayGenerator(int number) {
//	for(int i=height-1;i>1;i--) {
//		sol[2*current+1] = temp - (int)Math.pow(2,i);
//		
//		
//		sol[2*current+2] = temp-1;
//		
//	}
//	
//}