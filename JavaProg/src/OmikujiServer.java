import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;

public class OmikujiServer {
    public static void main(String[] args) {
        try{
            InetSocketAddress address = new InetSocketAddress(8081);
            HttpServer httpServer = HttpServer.create(address,0);
            OmikujiHandler omikujiHandler = new OmikujiHandler();
            httpServer.createContext("/omikuji",omikujiHandler);
            httpServer.start();
            System.out.println("Sever is started!");
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
