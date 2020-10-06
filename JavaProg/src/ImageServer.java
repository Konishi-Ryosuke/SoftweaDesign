import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;

public class ImageServer {
    public static void main(String[] args) {
        try{
            InetSocketAddress address = new InetSocketAddress(8082);
            HttpServer httpServer = HttpServer.create(address,0);
            ImageHandler imageHandler = new ImageHandler();
            httpServer.createContext("/image",imageHandler);
            httpServer.start();
            System.out.println("Sever is started!");
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
