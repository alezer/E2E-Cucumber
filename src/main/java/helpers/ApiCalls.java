package helpers;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Objects;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;

public class ApiCalls {
	private final static String BASE_PATH = "https://wines-api.herokuapp.com";
	
	private StringEntity buildCallBody(String body) {
        try {
            StringEntity entity = new StringEntity(body);
            entity.setContentType(ContentType.APPLICATION_JSON.getMimeType());
            return entity;
        } catch (IOException e) {
            return null;
        }
    }
	
	private HttpRequestBase buildCall (HttpRequestBase httpCall) {
        httpCall.addHeader("Content-type", "application/json");
        return httpCall;
    }
	
	private URIBuilder getBuilder(String path) {
        try {
            return new URIBuilder(BASE_PATH + path);
        } catch (URISyntaxException e) {
            return null;
        }
    }
	
	public HttpResponse executeCall(String type, String path, String body) {
        HttpResponse httpResponse = null;
        try {
            HttpClient httpClient = HttpClientBuilder.create().build();
            switch (type) {
                case "POST":
                    HttpEntityEnclosingRequestBase postCall =
                        new HttpPost(Objects.requireNonNull(getBuilder(path)).build());
                    postCall.setEntity(buildCallBody(body));
                    httpResponse = httpClient.execute(buildCall(postCall));
                    break;
                case "GET":
                    HttpRequestBase getCall =
                        new HttpGet(Objects.requireNonNull(getBuilder(path)).build());
                    httpResponse = httpClient.execute(buildCall(getCall));
                    break;
            }
        } catch (IOException e) {
        	System.out.print("IOException - " + e);
        } catch (URISyntaxException e) {
        	System.out.print("URISyntaxException - " + e);
        }
        return httpResponse;
    }
}
