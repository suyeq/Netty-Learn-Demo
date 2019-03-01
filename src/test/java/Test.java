import HeartBeatSourse.HeartBeatServer;
import HeartBeatSourse.HeartBeatsClient;
import UploadFile.FileUploadClient;
import UploadFile.FileUploadFile;
import UploadFile.FileUploadServer;

import java.io.File;


/**
 * Created with IntelliJ IDEA.
 * Author: Suyeq
 * Date: 2019-02-26
 * Time: 22:49
 */
public class Test {

    @org.junit.Test
    public void serverTest() throws Exception {
        //new HelloWorldServer(9999).start();
       // new HWServer(9999).start();
        //new HeartBeatServer(9999).start();
        //new HeartBeatServers(9999).start();
        //new HeartBeatServers(9999).start();
        //new HeartBeatServer(9999).start();
        new FileUploadServer().bind(9999);
    }

    @org.junit.Test
    public void clientTest() throws Exception {
        //new HelloWorldClient("127.0.0.1",9999).start();
        //new HWClient(9999,"127.0.0.1").start();
       // new HeartBeatsClient(9999,"127.0.0.1").start();
        //new HeartBeatsClients().connect(9999,"127.0.0.1");
        //new HeartBeatsClients().connect(9999,"127.0.0.1");
//        new HeartBeatsClient(9999,"127.0.0.1").start();
        FileUploadFile uploadFile = new FileUploadFile();
        File file = new File("F:/朝花夕誓  さよならの朝に約束の花をかざろう  (2018)/[Nekomoe kissaten][Sayoasa][BDRip HEVC-yuv420p10 1080p FLAC][CHS].mkv");
        String fileMd5 = file.getName();// 文件名
        uploadFile.setFile(file);
        uploadFile.setFile_md5(fileMd5);
        uploadFile.setStarPos(0);// 文件开始位置
        new FileUploadClient().connect(9999,"127.0.0.1",uploadFile);

    }


}
