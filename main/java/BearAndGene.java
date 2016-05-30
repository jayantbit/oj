import java.util.Scanner;

/**
 * Created by jayant.mukherji on 24/05/16.
 */
public class BearAndGene {


  static int index(char ch)
  {
    switch (ch)
    {
      case 'A': return 0;
      case 'C': return 1;
      case 'T': return 2;
      case 'G': return 3;
    }
    return -1;
  }
  static  int rem[]=new int[4];
  static int win[]=new int[4];

  static int compare( )
  {
    int flag=0;
    for(int i=0;i<4;i++)
    {
      if(rem[i]==0)continue;
      if(rem[i]>win[i])return 1;
      if(rem[i]<win[i])flag=-1;
    }
    return flag;
  }

  public static void main(String[] args) {
    Scanner in =new Scanner(System.in);
    int i,j,k;

    int len= in.nextInt();
    String str=in.next();

    for(i=0;i<len;i++)
      rem[index(str.charAt(i))]++;

    for(i=0;i<4;i++)
    rem[i]=Math.max(0,rem[i]-len/4);


    int ans=Integer.MAX_VALUE;

    if(compare()==0)ans=0;

    win[index(str.charAt(0))]++;
    for(i=j=0;i<len && j<len && i<=j;)
    {
      k=compare();
      //System.out.println(i+" "+j+" "+k);
      if(k==1)
      {
        j++;
        if(j<len)win[index(str.charAt(j))]++;
      }
      else
      {
        //System.out.println(i+" "+j);
        ans=Math.min(ans,j-i+1);
        win[index(str.charAt(i))]--;
        i++;
      }
    }

    System.out.println(ans);
  }
}
