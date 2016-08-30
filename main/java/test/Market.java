import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;


/**
 * Created by jayant.mukherji on 27/08/16.
 */

public class Market {

  static HashMap<String, Set<String>> catalog = new HashMap();
  static HashMap<String, HashMap<String, Integer>> sales = new HashMap();

  static HashMap<String, Set<String>> userPurchases = new HashMap<>();


  public static void addProduct(String product, String category) {
    if (catalog.containsKey(category))
      catalog.get(category).add(product);
    else {
      Set<String> st = new HashSet<>();
      st.add(product);
      catalog.put(category, st);
    }
  }

  public static void updateUserPurchase(String user, String product) {
    if (!userPurchases.containsKey(user)) {
      Set<String> st = new HashSet<>();
      st.add(product);
      userPurchases.put(user, st);
    } else {
      userPurchases.get(user).add(product);
    }
  }

  public static void purchase(String user, String product) {
    if (!sales.containsKey(product)) {
      HashMap<String, Integer> mp = new HashMap<>();
      mp.put(user, 1);
      sales.put(product, mp);
    } else {
      if (sales.get(product).containsKey(user)) {
        int val = sales.get(product).get(user);
        sales.get(product).put(user, val + 1);
      } else sales.get(product).put(user, 1);
    }
    updateUserPurchase(user, product);
  }

  public static void returnProduct(String user, String product) {
    if (!sales.containsKey(product)) {
      return;
    } else {
      if (sales.get(product).containsKey(user)) {
        int val = sales.get(product).get(user);
        if (val > 1) {
          sales.get(product).put(user, val - 1);
        } else {
          sales.get(product).remove(user);
          userPurchases.get(user).remove(product);
        }

      }
    }
  }

  public static void blackList(String user) {
    for (String product : userPurchases.get(user)) {
      if (sales.get(product).containsKey(user))
        sales.get(product).remove(user);
    }
    userPurchases.remove(user);
  }

  public static void bestSelling() {
    for (String category : catalog.keySet()) {
      int mx = 0;
      String bestProduct = null;
      for (String product : catalog.get(category)) {
        System.out.println(product);
        System.out.println(sales.get(product));
        if (sales.get(product) != null && sales.get(product).size() > mx) {
          mx = sales.get(product).size();
          bestProduct = product;

        }
      }
      System.out.println(String.format("Category %s ,BestSelling %s", category, bestProduct));
    }
  }

  public static void main(String[] args) {

    addProduct("p1", "c1");
    addProduct("p2", "c1");
    addProduct("p3", "c1");

    purchase("u1", "p1");
    purchase("u2", "p1");
    purchase("u3", "p1");

    purchase("u2", "p3");
    purchase("u2", "p3");
    purchase("u2", "p3");
    purchase("u2", "p3");
    returnProduct("u2", "p3");

    blackList("u1");


    bestSelling();
  }
}
