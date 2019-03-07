package it.polito.tdp.parole;

/**
 * Sample Skeleton for 'Parole.fxml' Controller Class
 */


import it.polito.tdp.parole.model.Parole;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class ParoleController {
	
	Parole elenco ;

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="txtParola"
    private TextField txtParola; // Value injected by FXMLLoader

    @FXML // fx:id="txtResult"
    private TextArea txtResult; // Value injected by FXMLLoader
    
    @FXML
    private Button btnReset;
    
    @FXML
    private Button cancellabtn;

    @FXML // fx:id="btnInserisci"
    private Button btnInserisci; // Value injected by FXMLLoader
    
    @FXML
    private TextField durataOP;

    @FXML
    void doInsert(ActionEvent event) {
    	long tempo1 = System.nanoTime();
    	txtResult.clear();
    	if (this.txtParola.getText().trim().equals("")!=true && this.stringContainsNumber(txtParola.getText())==false) {
    		String inserita = this.txtParola.getText().trim();
    		elenco.addParola(inserita);
    	}
    	txtParola.clear();
    	for (String s : elenco.getElenco())
    		txtResult.appendText(s+"\n");
    	durataOP.setText(Long.toString(System.nanoTime()-tempo1));
    }
    
    @FXML
    void doReset(ActionEvent event) {
    	long tempo1 = System.nanoTime();
    	txtResult.clear();
    	txtParola.clear();
    	elenco.reset();
    	durataOP.setText(Long.toString(System.nanoTime()-tempo1));
    }
    
    @FXML
    void doCancella(ActionEvent event) {
    	long tempo1 = System.nanoTime();
    	String dacancellare = txtResult.getSelectedText();
    	elenco.removeParola(dacancellare);
    	txtResult.clear();
    	for (String s : elenco.getElenco())
    		txtResult.appendText(s+"\n");
    	durataOP.setText(Long.toString(System.nanoTime()-tempo1));
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Parole.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Parole.fxml'.";
        assert btnInserisci != null : "fx:id=\"btnInserisci\" was not injected: check your FXML file 'Parole.fxml'.";

        elenco = new Parole() ;
        
    }
    
    public boolean stringContainsNumber (String s) {
    	return Pattern.compile("[0-9]").matcher(s).find();
    }
    
    
}
