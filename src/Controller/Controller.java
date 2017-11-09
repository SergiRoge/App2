/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import org.json.JSONObject;

import Model.ApiCaller;
import Model.TableData;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Llango
 */
public class Controller 
{
	private JSONObject jObject;
        private TableData tableData;
        private javax.swing.JTable table;

    public TableModel testApi(String url, String method) throws InterruptedException     
    {
        ApiCaller apiCaller = new ApiCaller(url, method);
        apiCaller.run();
        apiCaller.wait();
     
        jObject = apiCaller.getData();     
        
        System.out.println(jObject.getString(url));
        
        table = new javax.swing.JTable();
        TableModel tm = table.getModel();


        
        //tableData.setValueAt("HOLA", 1, 1);
        

        
        return table.getModel();
        
    }
    
}
