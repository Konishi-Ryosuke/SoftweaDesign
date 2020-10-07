import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

public class ImageHandler implements HttpHandler{
    private String unsei;


    @Override
    public void handle(HttpExchange exchange) throws IOException{
        int n = new Random().nextInt(3);
        switch (n){
            case 0:
                unsei = "<img src='https://bit.ly/3l1w58F' />";
                break;
            case 1:
                unsei = "<img src='https://bit.ly/349WrOY' />";
                break;
            case 2:
                unsei = "<img src='https://bit.ly/3jh7v31' />";
                break;
        }
        Headers headers = exchange.getResponseHeaders();
        headers.add("Content-Type","text/html;charset=UTF-8");
        exchange.sendResponseHeaders(200,unsei.getBytes().length);
        try(OutputStream os = exchange.getResponseBody()){
            os.write(unsei.getBytes());
        }

    }

//    private void printRequest(HttpExchange exchange){
//        System.out.printf("Request Message %d -----------",unsei);
//
//        String method = exchange.getRequestMethod();
//        System.out.println("Method:" + method);
//
//        String uri = exchange.getRequestURI().toString();
//        System.out.println("URI:" + uri);
//
//        System.out.println("Headers:");
//        Headers headers = exchange.getResponseHeaders();
//        headers.entrySet().forEach(System.out::println);
//    }
}
