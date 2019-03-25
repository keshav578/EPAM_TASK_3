package Glowing_Bulbs;

import java.util.ArrayList;
import java.util.Scanner;
 
public class Glowing_Bulbs{
		
	public static void getPrimes(String str, ArrayList<Integer> primes){
		for(int i = 0; i < str.length(); i++){
			if(str.charAt(i) - '0' > 0){
				primes.add(i+1);
			}
		}
	}
 
	static void processSubsets(ArrayList<Integer> set, int[] subset, int subsetSize, int nextIndex, ArrayList<Long> list) {
	    if (subsetSize == subset.length) {
	    	long temp = 1;
	        for(Integer i : subset){
	        	temp *= i;
	        }
	        list.add(temp);
	        
	    } else {
	        for (int j = nextIndex; j < set.size(); j++) {
	            subset[subsetSize] = set.get(j);
	            processSubsets(set, subset, subsetSize + 1, j + 1, list);
	        }
	    }
	}
	
	public static long findKth(ArrayList<Integer> primes, long k, int n){
		long sol = 0, temp;
		ArrayList<Long> list;
		
		list = new ArrayList<Long>();
		
		for(int i = 1; i <= n; i++){
			temp = 0;
			list.clear();
			processSubsets(primes, new int[i], 0, 0, list);
			
			for(Long j : list){		
				//System.out.println(k/j);
				temp += k/j;
			}
			
			if(i % 2 == 0){
				sol -= temp;
			} else {
				sol += temp;
			}
		}
		
		return sol;
				
	}
 
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int t;
		long k;
		Scanner reader;
		String str;
		ArrayList<Integer> primes;
		
		reader = new Scanner(System.in);
		t = Integer.parseInt(reader.nextLine());
		primes = new ArrayList<Integer>();
		
		while(t-- > 0){
			str = reader.nextLine();
			k = Long.parseLong(reader.nextLine());
			primes.clear();
			
			getPrimes(str, primes);
			
			/*for(Integer p : primes){
				System.out.println(p);
			}*/
			
			long r = 2*k;
			
			/*sol = findKth(primes, k, primes.size());
			System.out.println(sol);*/
			
			while(findKth(primes, r, primes.size()) < k){
				r *= 2;
			}
			
			long left = k, right = r, mid=0;
			long pom;
			
			while(left <= right){
				mid = (left + right) / 2;
				pom =  findKth(primes, mid, primes.size());
				//System.out.println(mid + " " + pom);
				if(k < pom){
					right = mid - 1;
				}else if(k > pom){
					left = mid + 1;
				} else {
					break;
				}
			}
			
			while(k == findKth(primes, mid, primes.size())){
				mid--;
			}
			
			mid++;
			
			System.out.println(mid);
			
		}
	}
 
}
