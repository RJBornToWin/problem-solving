package problemsolving.hr.medium;

import java.util.*;

public class HuffmanDecoding {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

    

}


abstract class Node implements Comparable<Node> {
    public  int frequency; // the frequency of this tree
    public  char data;
    public  Node left, right; 
    public Node(int freq) { 
      frequency = freq; 
    }
 
    // compares on the frequency
    public int compareTo(Node tree) {
        return frequency - tree.frequency;
    }
}
 
class HuffmanLeaf extends Node {
    
 
    public HuffmanLeaf(int freq, char val) {
        super(freq);
        data = val;
    }
}
 
class HuffmanNode extends Node {
    
    public HuffmanNode(Node l, Node r) {
        super(l.frequency + r.frequency);
        left = l;
        right = r;
    }

}


class Decoding {

/*  
	class Node
		public  int frequency; // the frequency of this tree
    	public  char data;
    	public  Node left, right;
    
*/ 
    int index = 0;
	void decode(String s, Node root) {
            StringBuilder sb = new StringBuilder(s);
            System.out.print(traverse(root, sb, false).toString());
    }
    
	String traverse(Node r, StringBuilder sb, boolean found) {
    	if (r.data >= 'a' && r.data <= 'z' ||
                r.data >= 'A' && r.data <= 'Z') {
                System.out.print(r.data+" at " + index + "|");

                return ""+r.data;
            }
            
            StringBuilder s = new StringBuilder();
            
            while (sb.length() > index) {
                //System.out.print(sb.charAt(index)+"|");
                if (sb.charAt(index) == '0') {
                    index++;
                   s.append(traverse(r.left, sb, found)).toString();
                }
                else if(sb.charAt(index) == '1') {
                    index++;
                    s.append(traverse(r.right, sb, found)).toString();
                }
                else {
                    s.append(sb.charAt(index));
                    index++;
                }
                
            }
            
            return s.toString();
    }
}

