import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

public class OmikujiHandler implements HttpHandler{
//    private int count;
    private String unsei;

    @Override
    public void handle(HttpExchange exchange) throws IOException{
//        count = count + 1;
//        printRequest(exchange);
        int n = new Random().nextInt(3);
        switch (n){
            case 0:
                 unsei = "大吉";
                break;
            case 1:
                 unsei = "中吉";
                break;
            case 2:
                 unsei = "吉";
                break;
        }
        String uranai = "今日の運勢は" + unsei + "です。";
        Headers headers = exchange.getResponseHeaders();
        headers.add("Content-Type","text/plain;charset=UTF-8");
        exchange.sendResponseHeaders(200,uranai.getBytes().length);
        try(OutputStream os = exchange.getResponseBody()){
            os.write(uranai.getBytes());
        }

    }

    private void printRequest(HttpExchange exchange){
        System.out.printf("Request Message %d -----------",unsei);

        String method = exchange.getRequestMethod();
        System.out.println("Method:" + method);

        String uri = exchange.getRequestURI().toString();
        System.out.println("URI:" + uri);

        System.out.println("Headers:");
        Headers headers = exchange.getResponseHeaders();
        headers.entrySet().forEach(System.out::println);
    }
}
