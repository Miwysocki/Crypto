package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
       // Matrix.decrypt_2c("CRYHOARPGPYT","CONVENIENCE");
        Matrix.decrypt_2c("CRYHOARPSGPYOTA","CONVENIENCE");
       // Matrix.decrypt_2c("HEESPNIRRSSEESEIYASCBTEMGEPNANDICTRTAHSOIEERO","CONVENIENCE");
        //Matrix.encrypt_2c("HEREISASECRETMESSAGEENCIPHEREDBYTRANSPOSITION","CONVENIENCE");
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root,    600, 500));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);

    }
}
