package problemsolving.week.one;

public class CoinChangeSolution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CoinChange cc = new CoinChange();
		int[] coins = {1, 2, 5};
		System.out.print(cc.findMinimumCoins(coins, 9));
	}

}

class CoinChange {
	int dp[];
	
	public int findMinimumCoins(int[] coins, int amount) {
		if (amount <= 0) return 0;
		dp = new int[amount]; // dp of 0 for each amount
		return getCoins(coins, amount);
	}
	
	public int getCoins(int[] coins, int rem) {
		if (rem == 0) return 0;
		else if (rem < 0) return -1;
		
		if (dp[rem-1] != 0)
			return dp[rem-1];
		
		int min = Integer.MAX_VALUE;
		for(int coin : coins) {
			int res = getCoins(coins, rem-coin);
			if (res >= 0) {
				min = Math.min(min, res+1);
			}	
		}
		
		dp[rem-1] = min;
		return (min == Integer.MAX_VALUE) ? -1 : min;
	}
}