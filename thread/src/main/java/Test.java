import java.util.*;
import java.util.concurrent.*;

public class Test {
    public static void main(String[] args) throws InterruptedException {
        HashSet<String> set = new HashSet<>();
//        Hashtable<String, String> table = new Hashtable<String, String>();
//        table.put(null, null);
        HashMap<String, String> map = new HashMap<String, String>();
        map.put(null, null);
        new Storage().add();
        System.out.println(map.get(null));
    }



}

class Storage{
    int storage = 1;

    synchronized void add() throws InterruptedException {
        wait();
        this.storage ++;

    }




}
