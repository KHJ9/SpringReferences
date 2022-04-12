package application;
	
import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Main04 extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			Parent root = (Parent)FXMLLoader.load(getClass().getResource("main04.fxml"));
			Scene scene = new Scene(root,320,190);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
			TextField tfMe = (TextField) scene.lookup("#tf_me");
			TextField tfCom = (TextField) scene.lookup("#tf_com");
			TextField tfResult = (TextField) scene.lookup("#tf_result");
			
			Button btn = (Button) scene.lookup("#btn");

			btn.setOnMouseClicked(new EventHandler<Event>() {
				@Override
				public void handle(Event arg0) {
					// TODO Auto-generated method stub
					String mine = tfMe.getText();
					String com = "";
					String result = "";
					
					double rnd = Math.random();
					
					if(rnd>0.5) {
						com = "홀";
					} else {
						com = "짝";
					}
					
					if(com.equals(mine)) {
						result = "이김";
					} else {
						result = "짐";
					}
					
					tfCom.setText(com);
					tfResult.setText(result);
				}
			});
			
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
