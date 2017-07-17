package com.spring;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
 
public class sendSMS {
	public static String sendSms() {
		try {
			// Construct data
			String apiKey = "apikey=" + "14557a6c64c4c643dcb5796e8b13a8e0e34bd63br01EFHIq4p1tpZwkNT4wXMsbP";
			String message = "&message=" + "This is your message";
			String sender = "&sender=" + "TXTLCL";
			String numbers = "&numbers=" + "919663097711";
			
			// Send data
			HttpURLConnection conn = (HttpURLConnection) new URL("https://api.textlocal.in/send/?").openConnection();
			String data = apiKey + numbers + message + sender;
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Length", Integer.toString(data.length()));
			conn.getOutputStream().write(data.getBytes("UTF-8"));
			final BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			final StringBuffer stringBuffer = new StringBuffer();
			String line;
			while ((line = rd.readLine()) != null) {
				stringBuffer.append(line);
			}
			rd.close();
			
			return stringBuffer.toString();
		} catch (Exception e) {
			System.out.println("Error SMS "+e);
			return "Error "+e;
		}
	}
	public static void main(String[] args) {
		System.out.println(sendSms());
	}
}
