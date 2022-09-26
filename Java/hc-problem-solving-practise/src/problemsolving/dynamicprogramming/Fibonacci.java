package problemsolving.dynamicprogramming;

public class Fibonacci {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 1 1 2 3 5 8 13...
		FibonacciSolution s = new FibonacciSolution();
		System.out.println(s.fib(6));
		System.out.println(s.fibCached(6)); // 8
	}

}

class FibonacciSolution {
    int[] cache = new int[30];
    public int fibCached(int n) {
        if (n==0 || n==1)
            return n;
        
        int fib2 = 0, fib1 = 0;
        if(cache[n-2] > 0) {
            fib2 = cache[n-2]; 
        }
        else {
            fib2 = fib(n-2);
            cache[n-2] = fib2;
        }
        
        if(cache[n-1] > 0) {
            fib1 = cache[n-1]; 
        }
        else {
            fib1 = fib(n-1);
            cache[n-1] = fib1;
        }
        
        cache[n-2] = fib1;
        // System.out.println(fib2 + fib1 + "|");
        return fib2 + fib1; 
    }
    
    public int fib(int n) {
        int fib0 = 0, fib1 = 1, fib2 = 1;
        if(n == 0) return 0;
        if(n == 1 || n == 2) return 1;
        for(int i=2;i<=n;i++){
            fib2  = fib0 + fib1;
            fib0 = fib1;
            fib1 = fib2;
        }
        return fib2;
    }
}