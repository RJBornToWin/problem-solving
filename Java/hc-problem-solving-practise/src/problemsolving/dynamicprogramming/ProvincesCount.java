package problemsolving.dynamicprogramming;

public class ProvincesCount {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] isConnected = {{1,1,0,0,0,0,0,1,0,0,0,0,0,0,0},
								{1,1,0,0,0,0,0,0,0,0,0,0,0,0,0},
								{0,0,1,0,0,0,0,0,0,0,0,0,0,0,0},
								{0,0,0,1,0,1,1,0,0,0,0,0,0,0,0},
								{0,0,0,0,1,0,0,0,0,1,1,0,0,0,0},
								{0,0,0,1,0,1,0,0,0,0,1,0,0,0,0},
								{0,0,0,1,0,0,1,0,1,0,0,0,0,1,0},
								{1,0,0,0,0,0,0,1,1,0,0,0,0,0,0},
								{0,0,0,0,0,0,1,1,1,0,0,0,0,1,0},
								{0,0,0,0,1,0,0,0,0,1,0,1,0,0,1},
								{0,0,0,0,1,1,0,0,0,0,1,1,0,0,0},
								{0,0,0,0,0,0,0,0,0,1,1,1,0,0,0},
								{0,0,0,0,0,0,0,0,0,0,0,0,1,0,0},
								{0,0,0,0,0,0,1,0,1,0,0,0,0,1,0},
								{0,0,0,0,0,0,0,0,0,1,0,0,0,0,1}};
		ProvincesCountSolution ps = new ProvincesCountSolution();
		System.out.println(ps.findCircleNum(isConnected)); //3
	}

}

class ProvincesCountSolution {
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
                            v[c] = r;
                        }
                        else {                            
                            if (v[r] != v[c]) {
                                int index = v[c];
                                while (index != v[index] || v[index] != r) {
                                    int temp = v[index];
                                    v[index] = r;
                                    index = temp;
                                    
                                }
                            }
                        }
                    }
                }
            }
        }
        
        int count = 0;
        for (int i=0; i < v.length; i++) {
            if (v[i] == i) {
                count++;
            }
        }
        
        return count;
        
    }
}