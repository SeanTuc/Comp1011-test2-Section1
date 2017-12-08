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


    public void loadPhoneInfo() throws SQLException
    {
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
    }    
    
}
