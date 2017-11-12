/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Converters;

import org.json.JSONException;
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
    
    
    public static JSONObject convert(String strJSON) throws JSONException
    {
        JSONObject jObject  = new JSONObject(strJSON);                
        return jObject;        
        
    }
    
}
