import HeartBeatSourse.HeartBeatServer;
import HeartBeatSourse.HeartBeatsClient;


/**
 * Created with IntelliJ IDEA.
 * Author: Suyeq
 * Date: 2019-02-26
 * Time: 22:49
 */
public class Test {

    @org.junit.Test
    public void serverTest(){
        //new HelloWorldServer(9999).start();
       // new HWServer(9999).start();
        //new HeartBeatServer(9999).start();
        //new HeartBeatServers(9999).start();
        //new HeartBeatServers(9999).start();
        new HeartBeatServer(9999).start();
    }

    @org.junit.Test
    public void clientTest() throws Exception {
        //new HelloWorldClient("127.0.0.1",9999).start();
        //new HWClient(9999,"127.0.0.1").start();
       // new HeartBeatsClient(9999,"127.0.0.1").start();
        //new HeartBeatsClients().connect(9999,"127.0.0.1");
        //new HeartBeatsClients().connect(9999,"127.0.0.1");
        new HeartBeatsClient(9999,"127.0.0.1").start();
    }


}
