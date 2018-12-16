import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ColorfulRabbits {


    public  int getMinimum(int arr[])
    {
      Arrays.sort(arr);

      int total=0,i,len=arr.length;




      for(i=0;i<len;)
       {


            total+=arr[i]+1;


            int k=arr[i]+1;
            int start=i;

            while(k>0 && i<len && arr[i]==arr[start])
            {
              k--;
              i++;
            }

      }




      return total;
    }



}
