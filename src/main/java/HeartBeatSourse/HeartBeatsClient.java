package HeartBeatSourse;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.handler.timeout.IdleStateHandler;

import java.util.concurrent.TimeUnit;

/**
 * Created with IntelliJ IDEA.
 * Author: Suyeq
 * Date: 2019-02-27
 * Time: 22:08
 */
public class HeartBeatsClient  {

    private  int port;
    private  String address;
    private EventLoopGroup eventExecutors=new NioEventLoopGroup();

    public HeartBeatsClient(int port, String address) {
        this.port = port;
        this.address = address;
    }

    public HeartBeatsClient reConnectServer(Bootstrap bootstrap,EventLoopGroup eventExecutors) throws InterruptedException {
        System.out.println("lalalall2");
        final HeartBeatsClient heartBeatsClient=this;
        synchronized (this){
            bootstrap.group(eventExecutors).channel(NioSocketChannel.class)
                    .handler(new ChannelInitializer<SocketChannel>() {
                        protected void initChannel(SocketChannel socketChannel) throws Exception {
                            ChannelPipeline channelPipeline=socketChannel.pipeline();
                            channelPipeline.addLast(new IdleStateHandler(0, 3, 0, TimeUnit.SECONDS));
                            channelPipeline.addLast(new StringDecoder());
                            channelPipeline.addLast(new StringEncoder());
                            channelPipeline.addLast(new HeartBeatClientHandler(heartBeatsClient));
                        }
                    });
        }
        bootstrap.remoteAddress(address, port);
        ChannelFuture channelFuture=bootstrap.connect().sync();
        channelFuture.addListener(new ConnectListener(this));
       channelFuture.channel().closeFuture().sync();
        return this;
    }

    public void start() throws InterruptedException {
        reConnectServer(new Bootstrap(),eventExecutors);
    }
}
