import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 https://www.hackerearth.com/june-clash-16/approximate/i-went-to-the-woods-juneclash/
 */

class Data
{
  int u,v,t,pos;
  Data(int u,int v,int t,int pos)
  {
    this.u=u;
    this.v=v;
    this.t=t;
    this.pos=pos;
  }
};

class WentToWoods {



  public static void main(String[] args) {

    Scanner in = new Scanner(System.in);
    List<Data> list=new ArrayList<>();
    int n,m,i,j,k;
    n=in.nextInt();
    m=in.nextInt();

    for(i=1;i<=m;i++)
    {
      int u,v,t;
      u=in.nextInt();
      v=in.nextInt();
      t=in.nextInt();
      list.add(new Data(u,v,t,i));
    }

    Collections.sort(list, new Comparator<Data>() {
      @Override
      public int compare(Data o1, Data o2) {
        return o1.t-o2.t;
      }
    });

    for(i=0;i<m;i++)
      System.out.print(list.get(i).pos + " ");

  }
}

