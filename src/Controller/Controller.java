/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import org.json.JSONObject;

import Model.ApiCaller;

/**
 *
 * @author Llango
 */
public class Controller 
{
	private JSONObject jObject;

    public JSONObject testApi(String url, String method) throws InterruptedException     
    {
        ApiCaller apiCaller = new ApiCaller(url, method);
        apiCaller.run();
        apiCaller.wait();
        
        jObject = apiCaller.getData();
        
        return jObject;
        
    }
    
}
