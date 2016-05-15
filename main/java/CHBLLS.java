import java.util.Random;
import java.util.Scanner;

/**
 * Created by jayant.mukherji on 07/05/16.
 */
public class CHBLLS {

  static int arr[]={1,2,3,4,5};

  public static void swap(int i,int j)
  {
    int temp=arr[i];
    arr[i]=arr[j];
    arr[j]=temp;
  }

  static int turns=0;
  public static int getRand()
  {
    Random randomGenerator = new Random();
    int p=turns+randomGenerator.nextInt(5-turns);
    swap(turns,p);
    return arr[turns++];
  }

  public static void main(String[] args) {
    Scanner in  = new Scanner(System.in);


    System.out.println(1);
    int c1=getRand();
    int c2=getRand();
    int c3=getRand();
    int c4=getRand();

    System.out.println(String.format("3 %d %d %d",c1,c2,c2));
    System.out.println(String.format("3 %d %d %d",c3,c3,c4));


    int w=in.nextInt();
    int ans;
    if(w==1) ans=c1;
    else if(w==-1) ans=c4;
    else if(w==2) ans=c2;
    else if(w==-2)ans=c3;
    else ans=getRand();

    System.out.println("2\n"+ans);
   }

}
