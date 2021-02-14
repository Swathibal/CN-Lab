import java.net.*;
import java.io.*;
import java.util.*;

public class Sender
{
public static void main(String args[])throws Exception
{
Socket sender = new Socket("localhost",6565);
System.out.println("Connected with the server");
Scanner sc = new Scanner(System.in);
System.out.println("Enter the no.of frames to be sent ");
int frames = sc.nextInt();
System.out.println(" ");
PrintStream op = new PrintStream(sender.getOutputStream());
for(int i = 0;i<=frames;i++)
{
if(i==frames)
{
op.println("exit");
break;
}
System.out.println("Enter the data to be sent in frame " + i + ":");
String data = sc.next();
System.out.println("Frame no : " +i+"is sent");
op.println(i);
BufferedReader br = new BufferedReader(new InputStreamReader(Sender.getInputStream());
String ack = br.readLine();
if(ack!=null)
{
System.out.println("Acknowledgement was received from Receiver..");
System.out.println(" ");
Thread.sleep(1000);
}
else
{
op.println(i);
}
}
System.out.println("All the frames are sent.....Exiting");
}
}
