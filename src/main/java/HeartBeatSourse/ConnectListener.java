package HeartBeatSourse;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.EventLoop;

import java.util.concurrent.TimeUnit;

/**
 * Created with IntelliJ IDEA.
 * Author: Suyeq
 * Date: 2019-02-28
 * Time: 20:13
 */
public class ConnectListener implements ChannelFutureListener {
    private HeartBeatsClient heartBeatsClient;

    public ConnectListener(HeartBeatsClient heartBeatsClient){
        this.heartBeatsClient=heartBeatsClient;
    }

    public void operationComplete(ChannelFuture channelFuture) throws Exception {
        if (!channelFuture.isSuccess()){
            System.out.println("将进行重连");
            final EventLoop loop = channelFuture.channel().eventLoop();
            loop.schedule(new Runnable() {
                public void run() {
                    try {
                        heartBeatsClient.reConnectServer(new Bootstrap(),loop);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            },1, TimeUnit.SECONDS);
        }else {
            System.out.println("连接成功");
        }
    }
}
