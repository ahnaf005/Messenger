package messenger;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class ClientReceiverfx implements Runnable {

    private DatagramPacket pack;
    private DatagramSocket sock;
    private int port;
    private String clientname;
    private String realmsg;
    private String servername;
    public  String sendmsg;
    public static boolean valueset=false;

    ClientReceiverfx(String clientname, int port, String servername) {
        this.clientname = clientname;
        this.port = port;
        this.servername = servername;
        new Thread(this).start();
    }

    @Override
    public void run() {
        while (true) {
            try {
                receive();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
    public void receive() throws Exception {
        String[] msg = new String[4];
        byte data[] = new byte[10000];
        pack = new DatagramPacket(data, data.length);
        sock = new DatagramSocket(port);
        sock.receive(pack);
        realmsg = new String(pack.getData(), 0, pack.getLength());
        try {
            int i, f;
            i = realmsg.indexOf('\n');
            f = realmsg.lastIndexOf('\n');
            //System.out.println(i + " " + f);
            msg[0] = realmsg.substring(0, i);
            msg[3] = realmsg.substring(f + 1, realmsg.length());
            String inter = realmsg.substring(i + 1, f);
            msg[1] = inter.substring(0, inter.indexOf('\n'));
            msg[2] = inter.substring(inter.indexOf('\n') + 1, inter.length());
            String via = msg[0].substring(msg[0].indexOf(":") + 1, msg[0].length());
            String to = msg[1].substring(msg[1].indexOf(":") + 1, msg[1].length());
            String from = msg[2].substring(msg[2].indexOf(":") + 1, msg[2].length());
            String body = msg[3].substring(msg[3].indexOf(":") + 1, msg[3].length());
            via=via.trim();
            to=to.trim();
            from=from.trim();
            body=body.trim();
            if (to.equals(clientname) && via.equals(servername)) {
                sendmsg=from + " " + "says: " + body;
                valueset=true;
            }
        } catch (Exception e) {
            System.out.println();
        }
        sock.close();
    }
    public String getsendmsg()
    {
        return sendmsg;
    }
}

