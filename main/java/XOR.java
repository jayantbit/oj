import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

/**
 * Created by jayant.mukherji on 23/05/16.
 */
public class XOR {

  static int num;
  static int a, b, c, d, ans;
  static int v;
  static int dir[][]=new int[8][4];

  static long sum(int n)
  {
    if(n<=0)return 0;
    return n*(n+1)/2;
  }

  static HashSet<String> hashSet = new HashSet<>();



  static void fn(int x, int y, int z,int w,int pos) {

    if(pos>11)return;


    String key=x + " " + y + " " + z + " " + w;
    if(hashSet.contains(key))return;

    if(x*y!=0 && z * w != 0) {
     ans++;
      hashSet.add(key);
      //System.out.println(x + " " + y + " " + z + " " + w);
    }
    int i;

    for(i=0;i<8;i++)
     {
       int xx,yy,zz,ww;

       xx=2*x+dir[i][0];
       yy=2*y+dir[i][1];
       zz=2*z+dir[i][2];
       ww=2*w+dir[i][3];


       if(yy>=xx && zz>=yy && ww>=zz)
         if(xx<=a && yy<=b && zz<=c && ww<=d)
         fn(xx,yy,zz,ww,pos+1);
     }
      return;
    }




  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    a = in.nextInt();
    b = in.nextInt();
    c = in.nextInt();
    d = in.nextInt();

    int arr[]=new int[4];
    arr[0]=a;arr[1]=b;arr[2]=c;arr[3]=d;
    Arrays.sort(arr);
    a=arr[0];b=arr[1];c=arr[2];d=arr[3];

    int i,j;

    int k=0;
    for(i=0;i<4;i++)
      for(j=i+1;j<4;j++)
      {
        Arrays.fill(dir[k],0);
        dir[k][i]=1;dir[k][j]=1;
        k++;
      }
    Arrays.fill(dir[7],1);



    long total=0;

    for(i=1;i<=a;i++)
      for(j=i;j<=b;j++)
      {
        total+=sum(d-j+1)-sum(d-c);
      }

    //System.out.println(total);
    ans=0;
    fn(0, 0, 0, 0, 0);

    /*
    0 0 0 0

    01 01 10 10

    1 1 1 1
    1 1 2 2
    1 1 3 3
     */
    System.out.println(total-ans);

  }
}
