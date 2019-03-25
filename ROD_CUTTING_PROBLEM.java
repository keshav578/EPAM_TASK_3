package ROD_CUTTING_PROBLEM;

//import for Scanner and other utility classes

import java.util.*;

public class ROD_CUTTING_PROBLEM {
	public static void main (String arg[]) throws Exception {
		
		Scanner l = new Scanner(System.in);
		
		int t=l.nextInt();
		
		for (int i = 0 ; i<t ; i++)
		
		{
			int n = l.nextInt();
			int count=0,m=n+1;
			if(m==1)
		
			{
				System.out.println(0);
				
			}
			else 
			{
                while(m>0)
                {
                    m=m/2;
                    count++;
                }
                
                System.out.println(count-2);
            }
		}
		
	}
	
	

}
