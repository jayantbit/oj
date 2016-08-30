import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * Created by jayant.mukherji on 31/07/16.
 https://www.hackerrank.com/challenges/fibonacci-modified
 BigInt
 */

class Equality {
  int x;
  int y;
  boolean isequal() {
    return(x == y);
  }
}

class newthread implements Runnable {
  Thread t;
  newthread() {
    t = new Thread(this,"Hello");
    t.start();
  }
  public void run() {
    System.out.println(t.getName());
  }
}

public class FiboBigInt {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    new newthread();
    TreeMap<Integer,Integer> treeMap = new TreeMap<>();


    Equality obj = new Equality();
    obj.x = 10;
    obj.y = 10;
    System.out.println(obj.isequal());

    ArrayList al = new ArrayList();
    String s = "Hello World";
    int i = s.indexOf('o');
    int j = s.lastIndexOf('l');
    System.out.print(i + " " + j);
    System.out.println(al);
    int t1 = in.nextInt();
    int t2 = in.nextInt();
    int n = in.nextInt();
    BigInteger b1= new BigInteger(String.valueOf(t1));
    BigInteger b2= new BigInteger(String.valueOf(t2));
    BigInteger b3=null;

    for(i=3;i<=n;i++)
    {
      b3=b2;
      b3=b3.multiply(b3);
      b3=b3.add(b1);
      b1=b2;
      b2=b3;
    }
    System.out.println(b3.toString());
  }
}
