package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class Controller {
    @FXML
    private TextField inputText;

    @FXML
    private TextField inputN;
    @FXML
    private TextField CaesarInputA;
    @FXML
    private TextField CaesarInputB;
    @FXML
    private TextField VinegereOutput;
    @FXML
    private TextField VinegereKeyInput;
    @FXML
    private TextField  Output_2a;
    @FXML
    private TextField  Output_2b;
    @FXML
    private TextField  key_2b;

    @FXML
    private TextField  CaesarOutput;


    @FXML
    private TextField RailFenceOutput;

    @FXML
    private void EncryptButtonClicked(ActionEvent event)
    {
        String input = inputText.getText();
        int n = Integer.parseInt(inputN.getText());
        int a  = Integer.parseInt(CaesarInputA.getText());
        int b  = Integer.parseInt(CaesarInputB.getText());

        RailFenceOutput.setText(RailFence.encrypt(input,n));
        Output_2a.setText(Matrix.encrypt_2a(input));
        Output_2b.setText(Matrix.encrypt_2b(input,key_2b.getText()));
        CaesarOutput.setText(Caesar.encrypt(input,a,b));
        VinegereOutput.setText(Vigenere.encryption(input,VinegereKeyInput.getText()));
    }

    @FXML
    private void DecryptButtonClicked(ActionEvent event)
    {
        String input = inputText.getText();
        int n =Integer.parseInt(inputN.getText());
        int a  = Integer.parseInt(CaesarInputA.getText());
        int b  = Integer.parseInt(CaesarInputB.getText());

        RailFenceOutput.setText(RailFence.decrypt(input,n));
        Output_2a.setText(Matrix.decrypt_2a(input));
        Output_2b.setText(Matrix.decrypt_2b(input,key_2b.getText()));
        CaesarOutput.setText(Caesar.decrypt(input,a,b));
        VinegereOutput.setText(Vigenere.decrypt(input,VinegereKeyInput.getText()));
    }
}
