
	import java.io.*; 
	import java.net.*; 
public class TCPClient { 

	    public static void main(String args[]) throws Exception 
	    { 
	        String sentence = ""; 
	        String modifiedSentence = ""; 

	        BufferedReader inFromUser = 
	          new BufferedReader(new InputStreamReader(System.in)); 
	        
	        while(!sentence.equals("CONNECT")){
	        	 sentence = inFromUser.readLine();
	        }
	        Socket clientSocket = new Socket("192.168.1.6", 9876); 
	        DataOutputStream outToServer = 
	                new DataOutputStream(clientSocket.getOutputStream()); 
	        BufferedReader inFromServer = 
	                new BufferedReader(new
	                InputStreamReader(clientSocket.getInputStream())); 
	        		
	        	while(!sentence.equals("CLOSE")&& !modifiedSentence.equals("CLOSE")){
	        		
	              sentence = inFromUser.readLine(); 

	              outToServer.writeBytes(sentence + '\n'); 

	              modifiedSentence = inFromServer.readLine(); 

	              System.out.println("FROM SERVER: " + modifiedSentence); 

	        	}           
	              clientSocket.close(); 

	          } 
	      } 



