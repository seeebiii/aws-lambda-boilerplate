package de.sebastianhesse.examples;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestStreamHandler;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;

/**
 * An example class for demonstrating how to use the event classes from aws-lambda-java-events dependency.
 */
public class JavaApiGatewayEventExample implements RequestStreamHandler {

    public static final ObjectMapper OBJECT_MAPPER = new ObjectMapper()
            .configure(JsonParser.Feature.IGNORE_UNDEFINED, true)
            .configure(JsonGenerator.Feature.IGNORE_UNKNOWN, true)
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

    public void handleRequest(InputStream inputStream, OutputStream outputStream, Context context) throws IOException {
        // read input stream as string
        String requestAsString = IOUtils.toString(inputStream, Charset.defaultCharset());
        System.out.println("Request: " + requestAsString);

        // read request using the provided Java classes
        APIGatewayProxyRequestEvent request = OBJECT_MAPPER.readValue(requestAsString, APIGatewayProxyRequestEvent.class);
        String requestObjectAsString = OBJECT_MAPPER.writeValueAsString(request);
        System.out.println("Request object: " + requestObjectAsString);

        // return response using the request object as string
        APIGatewayProxyResponseEvent response = new APIGatewayProxyResponseEvent()
                .withStatusCode(200)
                .withBody(requestAsString);
        OBJECT_MAPPER.writeValue(outputStream, response);
    }
}
