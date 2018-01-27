package server;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class StartServer extends Thread{
	
	private Server Main;
	
	public static final int SERVER_PORT=6020;
    final String SERVER_NAME = "localhost";
	
	public StartServer(String caption,Server main) {
		super(caption);
		this.Main=main;
	}
	
	public void run()
	{
		try
		{

			    DatagramSocket udpSocket = new DatagramSocket(SERVER_PORT,
			        InetAddress.getByName(SERVER_NAME));

			    Main.Println("Created UDP  server socket at "
			        + udpSocket.getLocalSocketAddress() + "...");
			    while (true) {
			    	Main.Println("Waiting for a  UDP  packet...");
			      DatagramPacket packet = new DatagramPacket(new byte[1024], 1024);
			      udpSocket.receive(packet);
			      displayPacketDetails(packet);
			      udpSocket.send(packet);
			    }
		}
		catch(Exception ex)
		{
			Main.Println("error "+ex.getMessage());
			
		}
	}
	 private void displayPacketDetails(DatagramPacket packet) {
		    byte[] msgBuffer = packet.getData();
		    int length = packet.getLength();
		    int offset = packet.getOffset();

		    int remotePort = packet.getPort();
		    InetAddress remoteAddr = packet.getAddress();
		    String msg = new String(msgBuffer, offset, length);

		    Main.Println("Received a  packet:[IP Address=" + remoteAddr
		        + ", port=" + remotePort + ", message=" + msg + "]");
	}
}
