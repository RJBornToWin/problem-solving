package problemsolving.dynamicprogramming;


public class MinCoinsRequired {
	
	static int[] coins = {9, 6, 5, 1}; // V = 11; 
	// {25, 10, 5}; // V = 30 , ans = 2
	

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub	
	}

	public static int noOfCoins(int sum, int sindex) {
		return sindex;
		
		//	Input: coins[] = {25, 10, 5}, V = 30
		//	Output: Minimum 2 coins required We can use one coin of 25 cents and one of 5 cents 

		//	Input: coins[] = {9, 6, 5, 1}, V = 11
		//	Output: Minimum 2 coins required We can use one coin of 6 cents and 1 coin of 5 cents
		
		// input constraints ? sum > 0, unique vals in coins, coins in sorted array?
		

		
	}
}