/**
 *Date: Mar 12, 2021
 *Title: Assignment3
 *@author Robert Gonzales
 *@version
 *
 *
 */
package application;


import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;



public class GUIController {

    @FXML
    private TextField decimalsField;

    @FXML
    private TextField iterationsField;
    
    @FXML
    private TextArea output;
    
    @FXML
    private ImageView imgpi;
   
    @FXML
    public void calculatePI(ActionEvent event) {
    	
    	int iterations = Integer.parseInt(iterationsField.getText()); //Sets the users iterationsField input to iterations
    	int round = Integer.parseInt(decimalsField.getText()); //Sets the users decimalsField input to round
    	
    	
    		MathContext b = new MathContext(round); //Initializes round
    	    BigDecimal result =  new BigDecimal(0); // The result (summation of Taylor series) 
    	    BigDecimal oddNum = new BigDecimal(1); // Odd numbers (1, 3, 5, 7 etc.) 
    	    BigDecimal pow5 = new BigDecimal(5); // Odd powers of 5 (5^1, 5^3, 5^5 etc.) 
    	    BigDecimal pow239 = new BigDecimal(239); // Odd powers of 239(239^1, 239^3, 239^5 etc.) 
    	    BigDecimal sign = new BigDecimal(1); // Either 1 or -1 indicating the sign of the next term
    	    for (int count = 0; count < iterations; count++) {
    	// Calculate and add the next term in the series.
    	// The sign of each new term alternates. 6
    	    	BigDecimal nextTerm = new BigDecimal(16.0).divide((pow5.multiply(oddNum)), 1000, RoundingMode.HALF_UP).subtract(new BigDecimal(4.0).divide((pow239.multiply(oddNum)), 1000, RoundingMode.HALF_UP) );

    	    	result = result.add(sign.multiply(nextTerm));
    			pow5 = pow5.multiply(new BigDecimal(5).multiply(new BigDecimal(5)));
    			pow239 = pow239.multiply(new BigDecimal(239).multiply(new BigDecimal(239)));
    			oddNum = oddNum.add(new BigDecimal(2));
    			sign = sign.multiply(new BigDecimal(-1));
    	    }
    	    output.setText(result.round(b).toString()); //Rounds the number to the users desired value
    	   
    }

}
