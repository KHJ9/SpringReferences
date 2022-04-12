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

public class Main07 extends Application {
	
	TextField tf1;
	TextField tf2;
	Button btn;
	TextArea ta;
	
	@Override
	public void start(Stage primaryStage) {
		try {
			Parent root = (Parent)FXMLLoader.load(getClass().getResource("main07.fxml"));
			Scene scene = new Scene(root,230,435);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
			tf1 = (TextField) scene.lookup("#tf1");
			tf2 = (TextField) scene.lookup("#tf2");
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

		String textField1 = tf1.getText();
		String textField2 = tf2.getText();
		int start = Integer.parseInt(textField1);
		int end = Integer.parseInt(textField2);
		StringBuilder result = new StringBuilder();
		
		for(int i=start; i<=end; i++)
			drawStar(result, i);
		
		ta.setText(result.toString());
	}
	
	public void drawStar(StringBuilder builder, int cnt) {
		for(int j=1; j<=cnt; j++)
			builder.append("*");
		builder.append("\n");
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
