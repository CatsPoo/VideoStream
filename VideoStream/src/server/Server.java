package server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Server extends Application{

	public static Text text=new Text();
	
	public static void main(String[] args) {
		launch(args);		
	}
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		
		StackPane layout =new StackPane();
		layout.getChildren().add(text);
		
		Scene s=new Scene(layout,400,250);
		primaryStage.setScene(s);
		primaryStage.show();
		
		Thread t=new Thread();
		
		StartServer S=new StartServer("main", this);
		S.start();
		
	}
	
	public void Println(String line)
	{
		System.out.println(line);
		text.setText(text.getText()+"\n"+line);
	}
	
	

}
