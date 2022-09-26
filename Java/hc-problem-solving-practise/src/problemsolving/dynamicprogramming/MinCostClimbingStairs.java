package problemsolving.dynamicprogramming;

public class MinCostClimbingStairs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MinCostClimbingStairsSolution s = new MinCostClimbingStairsSolution();
		int[] cost = {841,462,566,398,243,248,238,650,989,576,361,126,334,729}; //2794
		System.out.println(s.minCostClimbingStairs(cost));
	}

}

class MinCostClimbingStairsSolution {
    
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length];
        int k = cost.length;
        return minCost(k, cost, dp);
    }
    
    int minCost(int n, int[] cost, int[] dp) {
        if (n == 1|| n == 0)
            return cost[n];
        else if (n == cost.length)
            return Math.min(minCost(n-1, cost, dp), minCost(n-2, cost, dp));
        
        int cache1 = dp[n-1];
        if (cache1 == 0) {
            dp[n-1] = cache1 = minCost(n-1, cost, dp);
        } 
        
        int cache2 = dp[n-2];
        if (cache2 == 0) {
            dp[n-2]=cache2 = minCost(n-2, cost, dp);
        }
        
        return Math.min(cache1, cache2) + cost[n];
    }
}
