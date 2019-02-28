import HeartBeatSourse.HeartBeatsClient;

/**
 * Created with IntelliJ IDEA.
 * Author: Suyeq
 * Date: 2019-02-28
 * Time: 20:44
 */
public class Test {
    public static void main(String args[]) throws InterruptedException {
        new HeartBeatsClient(9999,"127.0.0.1").start();
    }
}
