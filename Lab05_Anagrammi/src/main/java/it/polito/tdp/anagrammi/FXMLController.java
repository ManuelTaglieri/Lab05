package it.polito.tdp.anagrammi;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.Set;

import it.polito.tdp.anagrammi.model.Anagrammi;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	
	private Anagrammi model;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtParola;

    @FXML
    private Button btnCalcola;

    @FXML
    private TextArea txtCorretti;

    @FXML
    private TextArea txtErrati;

    @FXML
    private Button btnReset;

    @FXML
    void doCalcola(ActionEvent event) {
    	
    	txtCorretti.clear();
    	txtErrati.clear();
    	
    	if (txtParola.getText()==null || txtParola.getText().equals("")) {
    		txtCorretti.setText("Inserire una parola");
    	}
    	
    	Set<String> anagrammi = this.model.calcolaAnagrammi(txtParola.getText());
    	
    	for (String s : anagrammi) {
    		if (this.model.isCorretto(s)) {
    			txtCorretti.appendText(s + "\n");
    		} else {
    			txtErrati.appendText(s + "\n");
    		}
    	}

    }

    @FXML
    void doReset(ActionEvent event) {
    	
    	txtParola.clear();
    	txtCorretti.clear();
    	txtErrati.clear();

    }

    @FXML
    void initialize() {
        assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnCalcola != null : "fx:id=\"btnCalcola\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtCorretti != null : "fx:id=\"txtCorretti\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtErrati != null : "fx:id=\"txtErrati\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Scene.fxml'.";

    }

	public void setModel(Anagrammi model) {
		
		this.model = model;
		
	}
}
