package messenger;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;
import java.util.StringTokenizer;
public class ClientSenderfx implements Runnable{
    private String clientname,servername;
    private DatagramSocket sock;
    private DatagramPacket pack;
    private InetAddress ip;
    private String realmsg;
    private String chattername;
    ClientSenderfx(String clientname,String servername,InetAddress ip,String realmsg,String chattername)
    {
        this.clientname=clientname;
        this.servername=servername;
        this.ip=ip;
        this.realmsg=realmsg;
        this.chattername=chattername;
        new Thread(this).start();
    }
    @Override
    public void run()
    {
        int c=0;
        while(c<1)
        {
            try{
                send();
            }catch(Exception e)
            {
                System.out.println(e);
            }
            c++;
        }
    }
    public void send() throws Exception
    {
        String []msg=new String[4];
        msg[0]="Via:"+" "+servername+'\n';
        try{
        msg[1]="To:"+" "+chattername+'\n';
        }catch(Exception e)
        {
            msg[1]="To:"+" "+"NULL"+'\n';
        }
        msg[2]="From:"+" "+clientname+'\n';
        try{
        msg[3]="Body:"+" "+realmsg;
        }catch(Exception e)
        {
            msg[3]="Body:"+" "+"NULL";
        }
        String sentmsg=msg[0]+msg[1]+msg[2]+msg[3];
        //System.out.println(sentmsg);
        byte data[] = sentmsg.getBytes();
        pack = new DatagramPacket(data, data.length);
        pack.setAddress(ip);
        pack.setPort(45555);
        sock = new DatagramSocket();
        sock.send(pack);
        sock.close();
        
    }
    
}

