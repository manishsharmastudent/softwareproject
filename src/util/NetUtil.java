package util;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

public class NetUtil {


	public static String curlURL(String url) throws IOException {
		ProcessBuilder pb = new ProcessBuilder("curl",url);



		Process p = pb.start();
		InputStream is = p.getInputStream();
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(is, "UTF-8"))) {
			StringBuilder sb = new StringBuilder();
			for (String line; (line = reader.readLine()) != null;) {
				sb.append(line);
			}
			return sb.toString();
		}
	}
}
