package net.d53dev.wanana.server;

import io.undertow.Undertow;
import io.undertow.server.HttpHandler;
import io.undertow.server.HttpServerExchange;
import io.undertow.util.Headers;

/**
 * Created by on 18/09/15.
 */
public class WananaServer {
    @SuppressWarnings("deprecation")
	public static void main(final String[] args) {
        Undertow server = Undertow.builder()
                .addListener(8080, "localhost")
                .setHandler(new HttpHandler() {
                    @Override
                    public void handleRequest(final HttpServerExchange exchange) throws Exception {
                        exchange.getResponseHeaders().put(Headers.CONTENT_TYPE, "application/json");
                        exchange.getResponseSender().send("{\"message:\": \"Hallo\"}");
                    }
                }).build();
        server.start();

        System.out.println("Started server at http://127.1:8080/  Hit ^C to stop");
    }
}
