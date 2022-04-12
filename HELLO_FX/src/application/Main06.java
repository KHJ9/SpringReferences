package application;
	
import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
public class Main06 extends Application {
	
	Label lbl1;
	Label lbl2;
	Label lbl3;
	Label lbl4;
	Label lbl5;
	Label lbl6;
	
	Button btn;
	
	@SuppressWarnings("exports")
	@Override
	public void start(Stage primaryStage) {
		try {
			Parent root = (Parent)FXMLLoader.load(getClass().getResource("main06.fxml"));
			Scene scene = new Scene(root,170,90);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
			lbl1 = (Label) scene.lookup("#lbl1");
			lbl2 = (Label) scene.lookup("#lbl2");
			lbl3 = (Label) scene.lookup("#lbl3");
			lbl4 = (Label) scene.lookup("#lbl4");
			lbl5 = (Label) scene.lookup("#lbl5");
			lbl6 = (Label) scene.lookup("#lbl6");
			
			btn = (Button) scene.lookup("#btn");
			
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
	
	@SuppressWarnings("unlikely-arg-type")
	public void myclick() {
		
		List<Integer> lotto = new ArrayList<Integer>(); 
		
		while(lotto.size() < 6) {
			double getNumber = (Math.random() * 45) + 1;
			if(!lotto.contains(getNumber))
				lotto.add((int)getNumber);
		}
		
		lbl1.setText(lotto.get(0).toString());
		lbl2.setText(lotto.get(1).toString());
		lbl3.setText(lotto.get(2).toString());
		lbl4.setText(lotto.get(3).toString());
		lbl5.setText(lotto.get(4).toString());
		lbl6.setText(lotto.get(5).toString());
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}










