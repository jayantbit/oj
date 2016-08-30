import java.util.Scanner;
import java.util.TreeSet;

/**
 * Created by jayant.mukherji on 15/05/16.
 https://www.hackerrank.com/challenges/java-hashset
 */

class Treeset {

   
  static class Pair implements Comparable<Pair>
  {
    public String a;
    public String b;
    Pair(String a,String b)
    {
      this.a=a;
      this.b=b;
    }

    @Override
    public int hashCode()
    {
      return (a+" "+b).hashCode();
    }

    @Override
    public int compareTo(Pair o) {
      return hashCode()-o.hashCode();
    }
  }
  public static void main(String[] args) {



    TreeSet<Pair> treeSet = new TreeSet<>();
    Scanner in = new Scanner(System.in);
    int tc=in.nextInt();
    while(tc-->0)
    {
      String a,b;
      a=in.next();
      b=in.next();
      Pair p=new Pair(a,b);

      treeSet.add(p);
      System.out.println(treeSet.size());
    }
  }
}
