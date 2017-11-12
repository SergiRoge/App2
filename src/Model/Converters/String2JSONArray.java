/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Converters;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author Llango
 */
public final class String2JSONArray 
{
    private String2JSONArray()
    {
        
    }
    
    
    public static JSONArray convert(String strJSON) throws JSONException
    {
        JSONObject jObject  = new JSONObject(strJSON);

        
           
        String asks = jObject.names().getString(0);
        String bids = jObject.names().getString(1);



        JSONObject JSONAsks = new JSONObject();
        for(int i = 0; i < jObject.getJSONArray(asks).length(); i++)
        {
            //System.out.println(jObject.getJSONArray(asks).get(i).toString());
            JSONAsks = new JSONObject(jObject.getJSONArray(asks).get(i).toString());                
        }
        //JSONObject sortedJSONAsks = new JSONObject();
        //sortedJSONAsks = JSONSorter.sort(JSONAsks, "price", false);

                
        return jObject.getJSONArray(asks);        
        
    }
}
