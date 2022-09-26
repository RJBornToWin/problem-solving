package problemsolving.hr.medium;


import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

public class CountingSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<List<String>> arr = new ArrayList<>();
		List<String> sub = new ArrayList<>();
		sub.add(null);
		sub.add(null);
		sub.add(null);
		sub.add(null);
		sub.add(null);
		sub.add(null);
		sub.add(null);
		Result.countSort(arr);
	}

}


class Result {

    /*
     * Complete the 'countSort' function below.
     *
     * The function accepts 2D_STRING_ARRAY arr as parameter.
     */

    public static void countSort(List<List<String>> arr) {
        // Write your code here
        int max = -1;
        int size = arr.size();
        HashMap<Integer, String> fList = new HashMap<>(size);
        
        for (int i =0; i<size; i++) {
            int num = Integer.parseInt(arr.get(i).get(0));
            if (num > max)
                max = num;
        }
        // Count of each string
        int[] count = new int[max+1];
        
        for (int i =0; i<size; i++) {
            count[Integer.parseInt(arr.get(i).get(0))]++;
        }
        
        // cumulative array
        for (int i = 1; i < count.length; i++) {
            count[i] += count[i-1];
        }

        int mid = (size/2);
        for (int i = size-1; i >= mid; i--) {
            fList.put(count[Integer.parseInt(arr.get(i).get(0))]--, arr.get(i).get(1) + " ");
        }
        
        for (int i = mid-1; i >= 0; i--) {
            fList.put(count[Integer.parseInt(arr.get(i).get(0))]--, "- ");
        }
        
        StringBuilder b = new StringBuilder();
        for (int i=0; i<=fList.size(); i++) {
            if (fList.get(i) != null) 
                b.append(fList.get(i));
        }
        
        System.out.println(b.toString());
    }

}

