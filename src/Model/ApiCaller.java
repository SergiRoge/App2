/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import jdk.nashorn.internal.parser.JSONParser;
import sun.net.www.http.HttpClient;
   


import org.json.JSONException; 
import org.json.JSONObject;

/**
 *
 * @author Llango
 */
public class ApiCaller implements Runnable
{
    private String strUrl;
    private String strMethod;




	private JSONObject jObject;
	private JSONObject data;
           
    public ApiCaller(String strUrl, String strMethod) 
    {
            this.strUrl = strUrl;
            this.strMethod = strMethod;
        //httpclient = HttpClient.createDefault();      
            
    }

    @Override
    public void run() 
    { 

	  try {

		URL url = new URL(strUrl);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod(strMethod);

                /*
                Accept: application/json
                Content-Type: application/x-www-form-urlencoded
                */
                
                conn.setRequestProperty("Accept", "application/json");
                conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                conn.setRequestProperty("limit_bids", "1");
                conn.setRequestProperty("limit_asks", "1");
  
		if (conn.getResponseCode() != 200) {
			throw new RuntimeException("Failed : HTTP error code : "
					+ conn.getResponseCode());
		}
                
                

		BufferedReader br = new BufferedReader(new InputStreamReader(
			(conn.getInputStream())));

		String output;
		String strResponse = "";
		while ((output = br.readLine()) != null) {
			strResponse += output;
		}
			JSONObject jObject  = new JSONObject();
			data = jObject.getJSONObject(strResponse);


		conn.disconnect();

	  } catch (MalformedURLException e) {

		e.printStackTrace();

	  } catch (IOException e) {

		e.printStackTrace();

	  } catch (JSONException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}            
    }
    
    
    public JSONObject getData() {
		return data;
	}

	public void setData(JSONObject data) {
		this.data = data;
	}  
}


