import java.util.ArrayList;
import java.util.List;

public class RangeSumOfDigits {


  List<Integer> digits=new ArrayList<>();

  int ans=0;
  void fn(int pos,boolean fixed,int sum)
  {
    if(pos==digits.size())
    {
      ans+=sum;
      return;
    }

    if(!fixed)
      {

        int rem=digits.size()-pos;
        ans+=45*rem*Math.pow(10,rem-1)+ sum*Math.pow(10,rem);
      }
      else
      {
        for(int i=0;i<digits.get(pos);i++)
        {
          fn(pos+1,false,sum+i);
        }
        fn(pos+1,true,sum+digits.get(pos));
      }

  }


  int sod(int n)
  {
    if(n==0)return 0;
    return n%10 + sod(n/10);
  }

  void fn()
  {
    //1024
    digits.add(5);
    digits.add(0);
    digits.add(2);
    digits.add(4);
    digits.add(5);
    digits.add(4);

    //5099

    fn(0,true,0);

    int ans2=0;
    for(int i=1;i<=502454;i++)
      ans2+=sod(i);


   System.out.println(ans2);
   System.out.println(ans);
   //System.out.println(ans);
  }

  public static void main(String[] args) {

    RangeSumOfDigits ob =new RangeSumOfDigits();
    ob.fn();
  }
}

