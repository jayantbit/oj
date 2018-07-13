import java.util.Scanner;

public class Row484A {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    in.nextLine();

    while (in.hasNext()) {

      String s = in.nextLine();

      int len = s.length(), i, j, k;
      boolean flag = true;
      if (len == 1) {
        flag = s.equals("1");
      } else if (len == 2) {
        flag = s.equals("10") || s.equals("01");
      } else {

        if(s.startsWith("00") || s.endsWith("00"))flag=false;
        else
        for (i = 2; i < len; i++) {
          char ch1 = s.charAt(i - 2);
          char ch2 = s.charAt(i - 1);
          char ch3 = s.charAt(i);


          if (ch2 == '1' && ch3 == '1') flag = false;
          if (ch1 == '1' && ch2 == '1') flag = false;
          else if (ch1 == '0' && ch2 == '0' && ch3 == '0') flag = false;

          if (!flag) break;
        }
      }

      System.out.println(flag ? "Yes" : "No");

    }
  }
}
