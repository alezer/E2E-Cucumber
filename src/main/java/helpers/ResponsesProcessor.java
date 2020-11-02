package helpers;

import java.util.ArrayList;
import java.util.Arrays;

public class ResponsesProcessor {
	public static ArrayList<String> parseResponseIntoArrayList(String response) {
		return new ArrayList<String>(Arrays.asList(response.replace("[", "").replace("]", "").replace("\"", "").split("\\s*,\\s*")));
	}
}
