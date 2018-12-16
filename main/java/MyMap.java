import java.util.HashMap;
import java.util.Optional;

class   MyMap<V> {

  HashMap<String, V> hashMap = new HashMap<>();
  int size=0;

  public void set(String s,V val) {
    hashMap.put(s,val);
    }

    public Optional<V> get(String k )
    {
      V v= hashMap.get(k);

      if(v==null)
      {
        System.out.println("Not present");
        return Optional.empty();
      }
      return Optional.of(v);

    }

    public void delete(String key)
    {
      hashMap.remove(key);
      size--;
    }

    public  int size()
    {
      return  hashMap.size();
    }

    public String  print()
    {
      return hashMap.toString();
    }
}

class VersionMap<V> {

}

class Main {

  public static void main(String[] arg) {
    MyMap<String> myMap = new MyMap<>();
     Optional<String> val=myMap.get("asad");
     if(val.isPresent())
     System.out.println(val.get());

  }
}