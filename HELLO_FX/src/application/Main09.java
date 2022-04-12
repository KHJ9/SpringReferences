package application;
	
import java.util.Optional;

import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DialogEvent;
import javafx.scene.control.TextField;

public class Main09 extends Application {
	
	TextField tf;
	
	Button btn1;
	Button btn2;
	Button btn3;
	Button btn4;
	Button btn5;
	Button btn6;
	Button btn7;
	Button btn8;
	Button btn9;
	Button btn0;
	Button btnCall;
	
	@SuppressWarnings("exports")
	@Override
	public void start(Stage primaryStage) {
		try {
			Parent root = (Parent)FXMLLoader.load(getClass().getResource("main09.fxml"));
			Scene scene = new Scene(root,190,240);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
			tf = (TextField) scene.lookup("#tf");
			
			btn1 = (Button) scene.lookup("#btn1");
			btn2 = (Button) scene.lookup("#btn2");
			btn3 = (Button) scene.lookup("#btn3");
			btn4 = (Button) scene.lookup("#btn4");
			btn5 = (Button) scene.lookup("#btn5");
			btn6 = (Button) scene.lookup("#btn6");
			btn7 = (Button) scene.lookup("#btn7");
			btn8 = (Button) scene.lookup("#btn8");
			btn9 = (Button) scene.lookup("#btn9");
			btn0 = (Button) scene.lookup("#btn0");
			btnCall = (Button) scene.lookup("#btnCall");
			
			btn1.setOnMouseClicked(new EventHandler<Event>() {
				@Override
				public void handle(Event arg0) {
					// TODO Auto-generated method stub
					add(arg0);
				}
			});

			btn2.setOnMouseClicked(new EventHandler<Event>() {
				@Override
				public void handle(Event arg0) {
					// TODO Auto-generated method stub
					add(arg0);
				}
			});

			btn3.setOnMouseClicked(new EventHandler<Event>() {
				@Override
				public void handle(Event arg0) {
					// TODO Auto-generated method stub
					add(arg0);
				}
			});

			btn4.setOnMouseClicked(new EventHandler<Event>() {
				@Override
				public void handle(Event arg0) {
					// TODO Auto-generated method stub
					add(arg0);
				}
			});

			btn5.setOnMouseClicked(new EventHandler<Event>() {
				@Override
				public void handle(Event arg0) {
					// TODO Auto-generated method stub
					add(arg0);
				}
			});

			btn6.setOnMouseClicked(new EventHandler<Event>() {
				@Override
				public void handle(Event arg0) {
					// TODO Auto-generated method stub
					add(arg0);
				}
			});

			btn7.setOnMouseClicked(new EventHandler<Event>() {
				@Override
				public void handle(Event arg0) {
					// TODO Auto-generated method stub
					add(arg0);
				}
			});

			btn8.setOnMouseClicked(new EventHandler<Event>() {
				@Override
				public void handle(Event arg0) {
					// TODO Auto-generated method stub
					add(arg0);
				}
			});

			btn9.setOnMouseClicked(new EventHandler<Event>() {
				@Override
				public void handle(Event arg0) {
					// TODO Auto-generated method stub
					add(arg0);
				}
			});

			btn0.setOnMouseClicked(new EventHandler<Event>() {
				@Override
				public void handle(Event arg0) {
					// TODO Auto-generated method stub
					add(arg0);
				}
			});

			btnCall.setOnMouseClicked(new EventHandler<Event>() {
				@Override
				public void handle(Event arg0) {
					// TODO Auto-generated method stub
					call();
				}
			});
			
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	// 코드들을 함수별로 나누어서 작성하라
	@SuppressWarnings("exports")
	public void add(Event event) {
		tf.appendText(((Button)event.getSource()).getText());
	}
	
	public void call() {
		Alert alert = new Alert(
				AlertType.INFORMATION,
				"Calling \n "+tf.getText(),
				ButtonType.OK);
		
		alert.setResizable(false);
		alert.setHeaderText(null);
		alert.getDialogPane().setPrefWidth(100);
		
		alert.setOnCloseRequest(new EventHandler<DialogEvent>() {
			@Override
			public void handle(DialogEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		
		Optional<ButtonType> result = alert.showAndWait();
		
		System.out.println(result.get());
		
		if(result.get() == ButtonType.OK) alert.close();
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
