package problemsolving.dynamicprogramming;

import java.util.ArrayList;

public class TimeConversion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TimeConversionSolution tp = new TimeConversionSolution();	
		tp.convertTime("02:30", "04:08"); // 60, 60, 5, 3
	}

}

class TimeConversionSolution{
    public int convertTime(String current, String correct) {
        int[] options =  {1, 10, 15, 25}; //{1,5,15,60}; //
        
        int diff = findDifference(current, correct);
        int op = 0;
        if (diff > 0) {
            op = findMinOp(diff, options);
        }
        System.out.println(op);
        return op;
    }
    
    int findDifference(String current, String correct) {
        int curH = Integer.parseInt(current.substring(0,2));
        int curM = Integer.parseInt(current.substring(3,5));
        
        int corH = Integer.parseInt(correct.substring(0,2));
        int corM = Integer.parseInt(correct.substring(3,5));
        
        int giv = curH * 60 + curM;
        int tar = corH * 60 + corM;
        
        return tar-giv;
    }
    
    int findMinOp(int totMins, int[] options) {
        int op = 0;
        ArrayList<Integer> ls = new ArrayList<Integer>();
        for (int i=options.length-1; i>=0; i--) {
            while(totMins >= options[i]) {
                System.out.print(options[i] + "|");
                ls.add(options[i]);
                totMins -= options[i];
                op++;
            }
        }
        
        return op;
    }
}