
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Comparator;

public class countingsort4 {

  public static void main(String args[]) throws Exception
  {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter ps = new PrintWriter(System.out);

    int n,i,j,k;
    n=Integer.parseInt(br.readLine());
    Record recordList[] = new Record[n];
    String strArray[] = new String[n];

    Comparator<Record> recordComparator = new Comparator<Record>() {
      @Override
      public int compare(Record o1, Record o2) {
        return Integer.compare(o1.num,o2.num);
      }
    };




    for(i=0;i<n;i++)
    {
      String str=br.readLine();
      String arr[]=str.split(" ");

      int num=Integer.parseInt(arr[0]);
      if(i<n/2)strArray[i]="-";
      else strArray[i]=arr[1];

      recordList[i]=new Record(num,i);
    }

    Arrays.sort(recordList,recordComparator);

    for(i=0;i<n;i++)
    {
      if(i>0) ps.print(" ");
      ps.print(strArray[recordList[i].pos]);
    }
    ps.close();
  }

  static class Record
  {
    int num;
    int pos;
    public Record(int num,int pos)
    {
      this.num = num;
      this.pos=pos;
    }
  }
}
