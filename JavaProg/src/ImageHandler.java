import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

public class ImageHandler implements HttpHandler{
    private int count;

    @Override
    public void handle(HttpExchange exchange) throws IOException{
        count = count + 1;
        printRequest(exchange);
        int n = new Random().nextInt(3);
        switch (n){
            case 0:
                String response = "今日の運勢は大吉です";
                Headers headers = exchange.getResponseHeaders();
                headers.add("Content-Type","text/plain;charset=UTF-8");
                exchange.sendResponseHeaders(200,response.getBytes().length);
                try(OutputStream os = exchange.getResponseBody()){
                    os.write(response.getBytes());
                }
            case 1:
                String response1 = "今日の運勢は中吉です";
                Headers headers1 = exchange.getResponseHeaders();
                headers1.add("Content-Type","text/plain;charset=UTF-8");
                exchange.sendResponseHeaders(200,response1.getBytes().length);
                try(OutputStream os = exchange.getResponseBody()){
                    os.write(response1.getBytes());
                }
            case 2:
                String response2 = "今日の運勢は吉です";
                Headers headers2 = exchange.getResponseHeaders();
                headers2.add("Content-Type","text/plain;charset=UTF-8");
                exchange.sendResponseHeaders(200,response2.getBytes().length);
                try(OutputStream os = exchange.getResponseBody()){
                    os.write(response2.getBytes());
                }
        }

    }

    private void printRequest(HttpExchange exchange){
        System.out.printf("Request Message %d -----------",count);

        String method = exchange.getRequestMethod();
        System.out.println("Method:" + method);

        String uri = exchange.getRequestURI().toString();
        System.out.println("URI:" + uri);

        System.out.println("Headers:");
        Headers headers = exchange.getResponseHeaders();
        headers.entrySet().forEach(System.out::println);

    }
}
