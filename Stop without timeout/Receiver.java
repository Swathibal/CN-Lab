import java.net.*;
import java.io.*;
public class Receiver
{
public static void main(String args[]) throws Exception
{
ServerSocket receiver =  new ServerSocket(6565);
Socket con = receiver.accept();
if(con!=null)
{
System.out.println("Connection was establsihed..");
System.out.println(" ");
}
String temp = "any_data",str = "exit";
BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream());
PrintStream op = new PrintStream(con.getOutputStream());
while(temp.compareTo(str!)=0)
{
Thread.sleep(1000);
temp = br.read line();
if(temp.compareTo(String)==0)
{
break;
}
System.out.println("Frame no : "+temp+"was received..");
System.out.println("Ack sent ...for frame no"+temp);
System.out.println(" ");
Thread.sleep(500);
op.println("Received");
}
receiver.close();
System.out.println("All frames are Received Succesfully...Exiting");
}
}
