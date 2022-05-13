package fi.utu.tech.telephonegame.network;



import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.concurrent.BlockingQueue;



import java.io.IOException;
import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.TransferQueue;

public class Server implements Runnable{

    public ServerSocket serverSocket;
    private List<CommHandler> clientList;
    private ObjectOutputStream objectOutputStream;
    private TransferQueue<Object> outQueue = new LinkedTransferQueue<Object>();


    public Server(ServerSocket serverSocket,List<CommHandler> clientList, TransferQueue<Object> outQueue) {
        this.serverSocket = serverSocket;
        this.clientList = clientList;
        this.outQueue = outQueue;
    }
    
    public void run() {

        while(true) {
            try {
                CommHandler handler = new CommHandler(serverSocket.accept(), outQueue);
                new Thread(handler).start();
                clientList.add(handler);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
