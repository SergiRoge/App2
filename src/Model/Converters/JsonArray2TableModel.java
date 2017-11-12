/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Converters;

import javax.swing.table.TableModel;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author Llango
 */
public final class JsonArray2TableModel 
{
    
    private JsonArray2TableModel()
    {
        
    }
    
    public static TableModel convert(JSONArray jsonArray, TableModel tableModel) throws JSONException
    {
        
        
        JSONObject jsonObject;
        
        
        
        //System.out.println("Cols :" + tableModel.getColumnCount());
        
        for(int i = 0; i < jsonArray.length(); i++)
        {
            jsonObject = jsonArray.getJSONObject(i);
            
            
            //System.out.println("i : " + i + " -> " + jsonObject.get("amount"));
            //first amount
            tableModel.setValueAt(jsonObject.get("amount"), i, 0);
            
            //then price
            tableModel.setValueAt(jsonObject.get("price"), i, 1);
            
            //then timestamp
            tableModel.setValueAt(jsonObject.get("timestamp"), i, 2);
            
            //then object
           // tableModel.setValueAt(jsonObject, i, 3);
            
        }
        
        //System.out.println(json.toString());
        
        
        return tableModel;
    }
    
}
