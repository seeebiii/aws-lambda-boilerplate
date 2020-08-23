package de.sebastianhesse.examples;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestStreamHandler;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;


/**
 * Example handler class which just sends a 200 response back.
 */
public class JavaHelloWorldHandlerOne implements RequestStreamHandler {


    public void handleRequest(InputStream inputStream, OutputStream outputStream, Context context) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(outputStream, new Response(200, "Hello World One!"));
    }
}
