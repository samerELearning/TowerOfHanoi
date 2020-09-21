package assignment3;
/******************************************************************
 * IterativeTOH.java
 * @author Samer Saber
 * Last modified on Saturday, 21 of March 2020
 * This class contains an iterative method to solve the Tower Of Hanoi problem.
 */
public class IterativeTOH
{
	private static int counter = 1;//counter for steps
	
	public static void towerOfHanoi(int num_of_discs)
	{
		int[] a = new int[num_of_discs + 1];//Array 'a' represents Column A
		int i_a = num_of_discs;//Index of first disc on top
		a[0] = num_of_discs + 1;//The first disc is set to be the largest and is considered as a fixed stand,
								//since it cannot be put on top of any disc.
		
		int[] b = new int[num_of_discs + 1];//Array 'b' represents Column B
		int i_b = 0;//Index of first disc on top
		b[0] = num_of_discs + 1; //The first disc is set to be the largest and is considered as a fixed stand,
								 //since it cannot be put on top of any disc.
		
		int[] c = new int[num_of_discs + 1];//Array 'c' represents Column C
		int i_c = 0;//Index of first disc on top
		c[0] = num_of_discs + 1; //The first disk is set to largest and is considered as a fixed stand,
								 //since it cannot be put on top of any disc.
		
		for(int i=0; i<num_of_discs; i++) //Filling 'Array a'/'Column A' with discs from largest to smallest
			a[i + 1] = num_of_discs - i;// a = {n,n-1,n-2,...,1}
		
		boolean m_a = true,//Verification that a move was made from any column to column A
				m_b = true,//Verification that a move was made from any column to column B
				m_c = true;//Verification that a move was made from any column to column C
		
		while( (c.length - 1) != i_c)
		{
		//Keeps looping until 'column C' is full
			
			//A EVEN
			if( (i_a % 2) == 0 && m_a)
			{
			//if Number of discs is even at 'column A', and the previous move was not made from any column to 'column A'
			//then move from A to B
				if( a[i_a] < b[i_b] )
				{
				//if the top disc at 'column A' is smaller than the top disc at 'column B'
					System.out.println(counter++ + "-Move disk " + a[i_a] + " from A to B");
					m_b = false;//'false' means a disk was moved from any column to column B
					m_a = true;//'true' means no disk was moved from any column to column A
					m_c = true;//'true' means no disk was moved from any column to column C
					b[++i_b] = a[i_a--];//Move from A to B
				}
			}
			
			//A ODD
			if( (i_a % 2) == 1 && m_a)
			{
			//if Number of discs is odd at 'column A', and the previous move was not made from any column to 'column A'
			//then move from A to C
				if( a[i_a] < c[i_c] )
				{//if the top disc at 'column A' is smaller than the top disc at 'column C'
					System.out.println(counter++ + "-Move disk " + a[i_a] + " from A to C");
					m_c = false;//'false' means a disk was moved from any column to column C
					m_a = true;//'true' means no disk was moved from any column to column A
					m_b = true;//'true' means no disk was moved from any column to column B
					c[++i_c] = a[i_a--];//Move from A to C
				}
			}
			
			//B EVEN
			if( (i_b % 2) == 0 && m_b)
			{
			//if Number of discs is even at 'column B', and the previous move was not made from any column to 'column B'
			//then move from B to A
				if(b[i_b] < a[i_a])
				{
				//if the top disc at 'column B' is smaller than the top disc at 'column A'
					System.out.println(counter++ + "-Move disk " + b[i_b] + " from B to A");
					m_a = false;//'false' means a disk was moved from any column to column A
					m_b = true;//'true' means no disk was moved from any column to column B
					m_c = true;//'true' means no disk was moved from any column to column C
					a[++i_a] = b[i_b--];//Move from B to A
				}
			}
			
			//B ODD
			if( (i_b % 2) == 1 && m_b)
			{
			//if Number of discs is odd at 'column B', and the previous move was not made from any column to 'column B'
			//then move from B to C
				if(b[i_b] < c[i_c])
				{
				//if the top disc at 'column B' is smaller than the top disc at 'column C'
					System.out.println(counter++ + "-Move disk " + b[i_b] + " from B to C");
					m_c = false;//'false' means a disk was moved from any column to column C
					m_a = true;//'true' means no disk was moved from any column to column A
					m_b = true;//'true' means no disk was moved from any column to column B
					c[++i_c] = b[i_b--];//Move from A to C
				}
			}
			
			//C EVEN
			if( (i_c % 2) == 0 && m_c)
			{
			//if Number of discs is even at 'column C', and the previous move was not made from any column to 'column C'
			//then move from C to A
				if(c[i_c] < a[i_a])
				{
				//if the top disc at 'column C' is smaller than the top disc at 'column A'
					System.out.println(counter++ + "-Move disk " + c[i_c] + " from C to A");
					m_a = false;//'false' means a disk was moved from any column to column A
					m_b = true;//'true' means no disk was moved from any column to column B
					m_c = true;//'true' means no disk was moved from any column to column C
					a[++i_a] = c[i_c--];//Move from B to A
				}
			}
			
			//C ODD
			if( (i_b % 2) == 1 && m_c)
			{
			//if Number of discs is odd at 'column C', and the previous move was not made from any column to 'column C'
			//then move from C to B
				
				if(c[i_c] < b[i_b])
				{
				//if the top disc at 'column C' is smaller than the top disc at 'column B'
					System.out.println(counter++ + "-Move disk " + c[i_c] + " from C to B");
					m_b = false;//'false' means a disk was moved from any column to column B
					m_a = true;//'true' means no disk was moved from any column to column A
					m_c = true;//'true' means no disk was moved from any column to column C
					b[++i_b] = c[i_c--];//Move from C to B
				}
			}
			
		}
	}
	
	public static void main(String[] args)
	{
		towerOfHanoi(9);
	}
}
