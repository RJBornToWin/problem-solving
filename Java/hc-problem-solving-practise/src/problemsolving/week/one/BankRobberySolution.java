package problemsolving.week.one;

import java.util.Stack;

public class BankRobberySolution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BankRobbery br = new BankRobbery();
		int[] coins = {21, 4, 6, 6, 1};
				// {2, 4, 3, 6, 1};
				// {2, 4, 3, 2, 1}; 
				// {2, 4, 7, 7, 1};
				// {8, 8, 4, 9, 9};
				
		System.out.print("MAx: " + br.calculateMaxGold(5, coins));
		
	}

}

class BankRobbery {
	public int calculateMaxGold(int N, int[] banks) {
		return calcMax(N, banks);
	}
	
	private int calcMax(int N, int[] banks) {
		
		int max = 0;
		Stack<Integer> st = new Stack<Integer>();
		
		for (int i=N-1; i >= 0; i--) {
			
			int commonFactor = banks[i];
			max =  Math.max(commonFactor, max);
			st.push(commonFactor);
			System.out.println(st.peek());	
			
			int localIndex = i -1;
			
			while (localIndex >= 0 && banks[localIndex] > 0) {
				if (banks[localIndex] >= commonFactor) {
					st.push(banks[localIndex]);
					System.out.println(st.peek());
					int gold = commonFactor * (i-localIndex+1);
					st.push(gold);
					System.out.println(st.peek());	
					max = Math.max(gold, max);
				}
				else {
						
					commonFactor = banks[localIndex];
					int gold = commonFactor * (i-localIndex+1);
					st.push(gold);
					System.out.println(st.peek());	
					max = Math.max(gold, max);
				}
				localIndex--;

			}
			System.out.println("--------");	
			
		}
		
		//while (!st.isEmpty()) {
		//	System.out.println(st.pop());	
		//}
		
		
		return max;
	}
}