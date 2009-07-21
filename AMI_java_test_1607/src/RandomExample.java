import java.util.Random;

/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: Jul 21, 2009
 * Time: 2:53:44 PM
 * To change this template use File | Settings | File Templates.
 */
public class RandomExample {

    public static void main(String args[]){
        Random ab = new Random();
        int r = ab.nextInt(10);
        System.out.println(r);
    }
}
