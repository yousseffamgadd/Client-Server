

	import java.io.*; 
import java.net.*; 

public	class TCPServer { 

	  public static void main(String args[]) throws Exception 
	    { 
	      String clientSentence; 
	      String capitalizedSentence; 

	      ServerSocket welcomeSocket = new ServerSocket(9876); 
	      Socket connectionSocket = welcomeSocket.accept(); 

          BufferedReader inFromClient = 
             new BufferedReader(new
             InputStreamReader(connectionSocket.getInputStream())); 
          DataOutputStream  outToClient = 
                  new DataOutputStream(connectionSocket.getOutputStream());
	      BufferedReader inFromUser = 
		          new BufferedReader(new InputStreamReader(System.in)); 

	      while(true) {
	                 clientSentence = inFromClient.readLine(); 
	                 System.out.println("FROM CLIENT:" + clientSentence);
	                 if(clientSentence.equals("CLOSE")){
	                	 outToClient.writeBytes("CLOSE" + '\n');
	                	 break;
	                 }
	                 else {
	                	 String message = inFromUser.readLine();
	                	 outToClient.writeBytes(message + '\n');
	                	 if(message.equals("CLOSE")){
	                		 break;
	                	 }
	                 }
	                // capitalizedSentence = clientSentence.toUpperCase() + '\n'; 
	                 //outToClient.writeBytes(capitalizedSentence); 
	              } 

}

}

