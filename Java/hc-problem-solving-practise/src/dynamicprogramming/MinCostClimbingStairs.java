package dynamicprogramming;

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

class SolutionUS {
    public int findCircleNum(int[][] isConnected) {
        int[] v = new int[isConnected.length];
        for (int r=0; r<=isConnected.length-1; r++) {
         v[r] = r;    
        }
        
        for (int r=0; r<=isConnected.length-1; r++) {
            for(int c=0; c<=isConnected.length-1; c++) {
                if (r!=c) {
                    if (isConnected[r][c] == 1 && !(r>=c)) {
                        
                        if (v[c] == c) {
                            System.out.println(r + ":" + c + ",,");
                            v[c] = r;
                        }
                        else {
                             System.out.println(r + ":" + c+",");
                             if (v[r] != v[c]) {
                                 v[v[r]] = c;
                                 v[r] = c;
                             }
                        }
                            
                    }
                }
            }
        }
        System.out.println("");
        //List<Integer> values = Arrays.asList(new Integer[](v));
        //System.out.println("Values: " + v);
        
        int count = 0;
        for (int i=0; i < v.length; i++) {
            System.out.println(v[i] + "|--");
            if (v[i] == i) {
                count++;
            }
        }
        
        return count;
        
    }
}