package problemsolving.lc.easy;

public class CountingOdd {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CountingOddSolution co = new CountingOddSolution();
		System.out.println(co.countOdds(1, 6));
	}

}

class CountingOddSolution {
    public int countOdds(int low, int high) {
        int ct = 0;
        
        int noBtw = high - low - 1;
        if (noBtw % 2 == 0) {
            ct = noBtw/2;
            if (low % 2 != 0) {
                ct++;
            }
            if(high % 2 != 0){
                ct++;
            }
            return ct;
        }
        else {
            if (low % 2 == 0) {
                return (noBtw+1)/2;
            }
            else {
                return ((noBtw+1)/2) + 1;
            }
        }
    }
}
