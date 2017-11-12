/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import org.json.JSONObject;

import Model.ApiCaller;
import Model.Converters.JsonArray2TableModel;
import Model.Converters.String2JSON;
import Model.Converters.String2JSONArray;
import Model.TableData;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import org.json.JSONArray;
import org.json.JSONException;

/**
 *
 * @author Llango
 */
public class Controller 
{
	private JSONObject jObject;
        private JSONArray jsonArray;
        private TableModel tableModel;
        private javax.swing.JTable table;

    public TableModel getTableModel(String url, String method, TableModel tableModel) throws InterruptedException, JSONException     
    {
        ApiCaller apiCaller = new ApiCaller(url, method);
        synchronized( apiCaller )
        {            
            apiCaller.run();              
        }
        
        String jsonData = apiCaller.getData();
        
        jsonArray = String2JSONArray.convert(jsonData);
        tableModel = JsonArray2TableModel.convert(jsonArray, tableModel);
        
        return tableModel;

    }
}
