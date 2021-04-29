package no.hvl.dat110.aciotdevice.client;

import java.io.IOException;

import com.google.gson.Gson;

import okhttp3.*;

public class RestClient {

	public RestClient() {
		// TODO Auto-generated constructor stub
	}

	private static String logpath = "/accessdevice/log";

	public void doPostAccessEntry(String message) {

		// TODO: implement a HTTP POST on the service to post the message
		Gson gson = new Gson();
		OkHttpClient client = new OkHttpClient();
		
		AccessMessage m = new AccessMessage(message);
		RequestBody body = RequestBody.create(null, gson.toJson(m));
		Request request = new Request.Builder().url("http://localhost:8080/accessdevice/log/").post(body).build();
		try {
			Response response = client.newCall(request).execute();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
	private static String codepath = "/accessdevice/code";
	
	public AccessCode doGetAccessCode() {

		AccessCode code = null;
		OkHttpClient client = new OkHttpClient();							
		Gson gson = new Gson();	
		// TODO: implement a HTTP GET on the service to get current access code
		Request request = new Request.Builder().url("http://localhost:8080/accessdevice/code").get().build();
		
		try {
			Response response = client.newCall(request).execute();
			code = gson.fromJson(response.body().string(), AccessCode.class);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return code;
	}
}
