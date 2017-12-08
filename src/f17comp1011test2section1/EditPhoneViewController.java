/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package f17comp1011test2section1;

import java.io.File;
import java.net.URL;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author jwright
 */
public class EditPhoneViewController implements Initializable {

    @FXML    private TextField manufacutureTextField;
    @FXML    private TextField modelTextField;
    @FXML    private TextField memoryTextField;
    @FXML    private TextField colourTextField;
    @FXML    private TextField screenSizeTextField;
    @FXML    private Spinner<Integer> phoneIDSpinner;
        String dbConnection = "jdbc:mysql://us-cdbr-azure-southcentral-f.cloudapp.net:3306/?user=b443d4f6b8b1a7";
        String username = "b443d4f6b8b1a7";
        String password = "7e42bc2c";

    public void loadPhoneInfo() throws SQLException
    {
        ArrayList<ArrayList> resultsArray;
        resultsArray = new ArrayList<>();
        
        ArrayList<String> resultArray;
        resultArray = new ArrayList<>();
        
        ArrayList<String> array;
        array = new ArrayList<>();
        
        array.add("phoneID");
        array.add("manufacturer");
        array.add("model");
        array.add("memory");
        array.add("colour");
        array.add("screenSize");
        array.add("cameraRes");
        String test = "4";//phoneIDSpinner.getValue().toString());
        
        String SQL = "SELECT * From Sean_Tucker.phones Where phoneID = "+ phoneIDSpinner.getValue().toString();
        selectFromDB(dbConnection,username,password,SQL,array,test /*phoneIDSpinner.getValue().toString()*/);
      
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        manufacutureTextField.setDisable(true);
        modelTextField.setDisable(true);
        memoryTextField.setDisable(true);
        colourTextField.setDisable(true);
        screenSizeTextField.setDisable(true);
               
        SpinnerValueFactory<Integer> phoneIDValueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1,100);
        phoneIDSpinner.setValueFactory(phoneIDValueFactory);
        phoneIDSpinner.setEditable(true);
        String newTest = "select count(model) from Sean_Tucker.Phone";
        
        
        
    }   
    
    public void selectFromDB(String dbConnectionString, String user, String pass, String sqlScript, ArrayList<String> array, String whereClause) throws SQLException
    {
        ArrayList<String> results;
        ArrayList<ArrayList> allResults;
        
        allResults = new ArrayList<>();
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        
        try{
            //1. connect to the database
            conn = DriverManager.getConnection(dbConnectionString, user, pass);
            //2.  create a statement object
            statement = conn.prepareStatement(sqlScript);
            //statement.setString(1,whereClause);
            
            //3.  create the SQL query
            resultSet = statement.executeQuery(sqlScript);
            //resultSet = statement.executeQuery("SELECT * FROM Sean_Tucker.testing");

            
            
            while (resultSet.next())
            {
                    manufacutureTextField.setText(resultSet.getString("manufacturer"));
                    modelTextField.setText(resultSet.getString("model"));
                    memoryTextField.setText(resultSet.getString("memory"));
                    colourTextField.setText(resultSet.getString("colour"));
                    screenSizeTextField.setText(resultSet.getString("screenSize"));                

                
            }
            
        } catch (Exception e)
        {
            System.err.println(e);
        }
        finally
        {
            if (conn != null)
                conn.close();
            if(statement != null)
                statement.close();
            if(resultSet != null)
                resultSet.close();
        }

    } // end of select all statement
    
}
