/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Converters;

import org.json.JSONObject;

/**
 *
 * @author Llango
 */
public final class String2JSON 
{
    private String2JSON()
    {
    }
    
    
    public static JSONObject convert(String strJSON)
    {
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
                
                
                
        
    }
    
}
