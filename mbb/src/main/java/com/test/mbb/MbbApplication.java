package com.test.mbb;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class MbbApplication {

	public static void main(String[] args) {
		SpringApplication.run(MbbApplication.class, args);
	}
	
	@GetMapping(path = "api/worldtime")
	public String getWorldTime()
	{
		Util.writeLog("getWorldTime","", true);
		
		try 
		{
			URL urlForGetRequest = new URL("https://tools.aimylogic.com/api/now");
	        String readLine;
	        HttpURLConnection connection = (HttpURLConnection) urlForGetRequest.openConnection();
	        connection.setRequestMethod("GET");
	        //connection.setRequestProperty("Content-Type", "application/json");
	        int responseCode = connection.getResponseCode();
	        if (responseCode == HttpURLConnection.HTTP_OK)
	        {
	            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
	            StringBuilder response = new StringBuilder();
	            while ((readLine = in.readLine()) != null)
	            {
	                response.append(readLine);
	            }
	            in .close();
	            Util.writeLog("getWorldTime",response.toString(), false);
	            return response.toString();
	        }
	        else
	        {
	        	BufferedReader in = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
	            StringBuilder response = new StringBuilder();
	            while ((readLine = in .readLine()) != null)
	            {
	                response.append(readLine);
	            }
	            in .close();
	            Util.writeLog("getWorldTime",responseCode + "(" + connection.getResponseMessage() + ")" + "\n\n" + response.toString(), false);
	            return responseCode + "(" + connection.getResponseMessage() + ")" + "\n\n" + response.toString();
	        }
		} 
		catch (Exception e) 
		{
			// TODO: handle exception
			Util.writeLog("getWorldTime",e.getMessage(),false);
			throw new IllegalStateException(e.getMessage());
		}
	}
}
