package org.hc.trucktour;


import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;



class Result {

    /*
     * Complete the 'truckTour' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY petrolpumps as parameter.
     */

    public static int truckTour(List<List<Integer>> petrolpumps) {
    	// Write your code here
    	int start = 0;
        for (int sPump = 0; sPump < petrolpumps.size(); sPump++) {
        	int petrolInTank = 0;
            start = sPump;
            int noOfPumps = 0;
            int pumpsCount = petrolpumps.size();
            while (pumpsCount > 0) {
                petrolInTank = petrolInTank + petrolpumps.get(start).get(0);
                if (petrolInTank >= petrolpumps.get(start).get(1)) {
                	petrolInTank = petrolInTank - petrolpumps.get(start).get(1);
                	noOfPumps++;
                    start++;
                    pumpsCount--;
                    if (start == petrolpumps.size()) {
                        start = 0;
                    }
                }
                else {
                    break;
                }
            }
            if (noOfPumps == petrolpumps.size())
                return sPump;
            
        }

        return start;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        List<List<Integer>> petrolpumps = new ArrayList<>();

        int result = Result.truckTour(petrolpumps);

        System.out.print(result);
    }
}
