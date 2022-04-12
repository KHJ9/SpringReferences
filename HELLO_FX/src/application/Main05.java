package application;
	
import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class Main05 extends Application {
	
	TextField tf;
	Button btn;
	TextArea ta;
	
	@Override
	public void start(Stage primaryStage) {
		try {
			Parent root = (Parent)FXMLLoader.load(getClass().getResource("main05.fxml"));
			Scene scene = new Scene(root,230,435);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
			tf = (TextField) scene.lookup("#tf");
			btn = (Button) scene.lookup("#btn");
			ta = (TextArea) scene.lookup("#ta");
			
			btn.setOnMouseClicked(new EventHandler<Event>() {
				@Override
				public void handle(Event arg0) {
					// TODO Auto-generated method stub
					myclick();
				}
			});
			
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void myclick() {

		String textField = tf.getText();
		int dan = Integer.parseInt(textField);
		StringBuilder result = new StringBuilder();
		
		for(int i=1; i<=9; i++) {
			result.append(dan + "  x " + i + " = " + dan*i + "\n");
		}
		
		ta.setText(result.toString());
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
