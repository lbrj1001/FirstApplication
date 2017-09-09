package test.lifeng.liang;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.URLEncoder;
import java.net.UnknownHostException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import android.util.Log;

public class HttpProtocolWithURL {
	static String requestUrl="http://111.1.41.104:8080";
	/**
	 * 接口http调用
	 *
	 * @param requestUrl
	 * @param entity
	 * @return
	 */
	public static String doHttpPost(Map<String, Object> entity) {
		String result = "";
		try {
//			Log.e("url", url);
			URL url = new URL(requestUrl);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setDoOutput(true);
			connection.setConnectTimeout(1000 * 90);
			connection.setReadTimeout(1000 * 90);
			PrintWriter writer = new PrintWriter(connection.getOutputStream());
			writer.print(converseMaptoString(entity));
			writer.close();
			connection.connect();
			int code = connection.getResponseCode();
			if (code == 200) {
				String[] types = connection.getContentType().split(";");
				Scanner scanner = new Scanner(connection.getInputStream(), "utf-8");
				while (scanner.hasNext()) {
					result = result + scanner.next();
				}
				scanner.close();
			} else {
				System.out.println("返回码:" + code);
			}
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	private static String converseMaptoString(Map<String, Object> entity) {
		StringBuilder builder = new StringBuilder();
		if (entity != null) {
			Set<String> keySet = entity.keySet();
			for (Object key : keySet) {
				// 设置需要传递的参数
				builder.append(key.toString()).append("=").append((String) entity.get(key)).append("&");
			}
		}
		String content = builder.toString();
		if (content.endsWith("&")) {
			content = content.substring(0, content.length() - 1);
			Log.e("url", content);
		}
		return content;
	}

	public static String TcpSend(String sendMessage) {
		String returnMessage="";
		try {
			Socket socket = new Socket("111.1.41.104", 8080);
				OutputStream put = socket.getOutputStream();
				PrintWriter writer = new PrintWriter(put);
				writer.write("Hello\n");
				writer.flush();
				InputStream input = socket.getInputStream();
				Scanner scanner = new Scanner(input);
				while (scanner.hasNextLine()) {
					returnMessage += scanner.nextLine()+"\n";
				}
				writer.close();
				scanner.close();
				socket.close();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return returnMessage;
	}
}
