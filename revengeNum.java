package LeetCode;

public class revengeNum {

	    public int reverse(int x) {
	      int b=0;
	      while(x!=0)
	      {
	          int temp1=x%10;
	          int temp2=b*10+temp1;
	          if((temp2-temp1)/10!=b)
	          return 0;
	          b=temp2;
	          x=x/10;
	      }
	      return b;
	    }
	
}

