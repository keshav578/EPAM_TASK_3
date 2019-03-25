package Help_Out_Indian_Armu;

import java.util.*;

class HElp_Out_Indian_Army {
    public static void main(String args[] ) throws Exception {
        sc = new Scanner(System.in);
        
        long n = sc.nextLong();
        long start = sc.nextLong();
        long end = sc.nextLong();
        PriorityQueue<CheckPoint> pq = new PriorityQueue<CheckPoint>((int) n, checkComparator);
        CheckPoint c;
        
        for(int i=0;i<n;i++){
        	long x = sc.nextLong();
        	long p = sc.nextLong();
        	c = new CheckPoint(x,p);
        	pq.add(c);
        }
        
        long res = 0;
        while(!pq.isEmpty() && start < end) {
        	c = pq.poll();
        	long left = c.getLeft();
        	long right = c.getRight();
        	if(start < left) {
        		left = ((left > end) ? end : left); 
        		res = res + left - start;
        	}
        	if(start < right)
        		start = right;
        }
        if(start < end)
        	res = res + end - start;
        System.out.println(res);
    }
    
    public static Comparator<CheckPoint> checkComparator = new Comparator<CheckPoint>() {
    	public int compare(CheckPoint c1, CheckPoint c2) {
    		if(c1.getLeft() < c2.getLeft())
    			return -1;
    		else
    			return 1;
    	}
    };
	private static Scanner sc;
    
    static class CheckPoint {
    	long x;
    	long p;
    	long left;
    	long right;
    	public CheckPoint(long x, long p) {
    		this.x = x;
    		this.p = p;
    	}
    	
    	public long getLeft() {
    		return x-p;
    	}
    	
    	public long getRight() {
    		return x+p;
    	}
    }
}