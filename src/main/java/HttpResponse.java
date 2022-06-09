import lombok.Data;
import lombok.ToString;

import java.nio.charset.StandardCharsets;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.StringJoiner;

@Data
public class HttpResponse {
    private String protocol = "HTTP/1.1";
    private int statusCode;
    private String statusText;

    private Map<String, String> headers = new LinkedHashMap<>();

    private String body;

    @Override
    public String toString() {
        StringJoiner result = new StringJoiner("\n");

        //make start line
        result.add(protocol + " " + statusCode + " " + statusText);

        for (Map.Entry<String, String> keyValue : headers.entrySet()) {
            result.add(keyValue.getKey() + ": " + keyValue.getValue());
        }

        //Craft Content-Length header
        result.add("Content-Length: " + body.getBytes(StandardCharsets.UTF_8).length);

        //Craft Content-Type header
        result.add("Content-Type: " + "text/html; charset=utf-8");

        //add body
        result.add("");
        result.add(body);

        return result.toString();
    }
}
