package org.pvgus.http;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import org.pvgus.enums.HttpMethods;

public class Server {

    public static void start() throws Exception {
        HttpServer server = HttpServer.create(new InetSocketAddress(8000), 0);
        server.createContext("/test", new TestHandler());
        server.setExecutor(null); // creates a default executor
        server.start();
    }

    static class TestHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            OutputStream os = exchange.getResponseBody();
            if (exchange.getRequestMethod().equals(HttpMethods.GET.name())) {
                String response = "{ \"response\" : \"this is GET\" }";
                exchange.sendResponseHeaders(200, response.length());
                os.write(response.getBytes());
            } else {
                String response = "{ \"response\" : \"this is POST\" }";
                exchange.sendResponseHeaders(200, response.length());
                os.write(response.getBytes());
            }
            os.close();
        }
    }

}