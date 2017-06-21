package LeetCode;

public class Palindrome {
	
	 public static boolean isPalindrome(int x) {
	        int []a=new int[10];
	        x=Math.abs(x);
	        int i=0;
	        int j=0;
	        while(x!=0){
	            int temp=x%10;
	            a[j++]=temp;
	            x=x/10;
	        }
	        j=j-1;
	        while(i!=j){
	            if(a[i]!=a[j]) 
	            return false;
	        }
	        return true;
	    }
	 public static boolean model1(int x){          //�����ж�һ��  ȱ���Ա����������ж�
		 if (x<0 || (x!=0 && x%10==0)) return false;
		    int rev = 0;
		    while (x>rev){
		    	rev = rev*10 + x%10;
		    	x = x/10;
		    }
		    return (x==rev || x==rev/10);
	 }
}
