package problemsolving.lc.easy;

public class RobotInOrigin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RobotInOriginSolution ro =  new RobotInOriginSolution();
		System.out.println(ro.judgeCircle("LLRR")); // True

	}

}

class RobotInOriginSolution {
    public boolean judgeCircle(String moves) {
        int vpos = 0;  int hpos = 0;
        for (char c: moves.toCharArray()) {
            if (c == 'U') 
                vpos++;
            else if(c == 'R') 
                hpos++;
            else if (c == 'D') 
                vpos--;
            else if (c== 'L') 
                hpos--;
        }
        
        return (vpos == 0 && hpos==0);
    }
    
    
}