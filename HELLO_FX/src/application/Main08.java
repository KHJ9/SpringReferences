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

public class Main08 extends Application {
	
	TextField tfMe;
	TextField tfCom;
	TextField tfResult;

	
	@Override
	public void start(Stage primaryStage) {
		try {
			Parent root = (Parent)FXMLLoader.load(getClass().getResource("main08.fxml"));
			Scene scene = new Scene(root,320,190);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
			tfMe = (TextField) scene.lookup("#tf_me");
			tfCom = (TextField) scene.lookup("#tf_com");
			tfResult = (TextField) scene.lookup("#tf_result");
			
			Button btn = (Button) scene.lookup("#btn");

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
	
	// 코드들을 함수별로 나누어서 작성하라
	public void myclick() {
		String mine = tfMe.getText();
		String com = "";
		String result = "";
		
		int rnd = (int)((Math.random() * 3) + 1);
		
		// 가독성을 고려한 코드
		
		if(rnd == 1) com = "가위";
		if(rnd == 2) com = "바위";
		if(rnd == 3) com = "보";
		
		if(com.equals(mine)) result = "비김";
		
		if(com.equals("가위")) {
			if(mine.equals("바위")) result = "이김";
			if(mine.equals("보")) result = "짐";
		}
		
		if(com.equals("바위")) {
			if(mine.equals("보")) result = "이김";
			if(mine.equals("가위")) result = "짐";
		}
		
		if(com.equals("보")) {
			if(mine.equals("가위")) result = "이김";
			if(mine.equals("바위")) result = "짐";
		}
		
		tfCom.setText(com);
		tfResult.setText(result);
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
