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
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import jdk.nashorn.internal.parser.JSONParser;
import org.json.JSONArray;
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
	private String data;
        private JSONArray jArray;
           
    public ApiCaller(String strUrl, String strMethod) 
    {
            this.strUrl = strUrl;
            this.strMethod = strMethod;
            data = "";
            
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
  
		if (conn.getResponseCode() != 200) {
			throw new RuntimeException("Failed : HTTP error code : "
					+ conn.getResponseCode());
		}
                
                

		BufferedReader br = new BufferedReader(new InputStreamReader(
			(conn.getInputStream())));

		String output;
		
                
                
                
		while ((output = br.readLine()) != null) 
                {
			data += output;
		}
		
                /*
                jObject  = new JSONObject(data);
                
                String asks = jObject.names().getString(0);
                String bids = jObject.names().getString(1);
                
               
                
                JSONObject JSONAsks = new JSONObject();
                for(int i = 0; i < jObject.getJSONArray(asks).length(); i++)
                {
                    System.out.println(jObject.getJSONArray(asks).get(i).toString());
                    JSONAsks = new JSONObject(jObject.getJSONArray(asks).get(i).toString());                
                }
                JSONObject sortedJSONAsks = new JSONObject();
                sortedJSONAsks = JSONSorter.sort(JSONAsks, "price", false);
                
                */
                   

		conn.disconnect();

	  } catch (MalformedURLException e) {

		e.printStackTrace();

	  }catch (IOException e) {

		e.printStackTrace();

	  }

            
    }
    
    
    public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}  
}


