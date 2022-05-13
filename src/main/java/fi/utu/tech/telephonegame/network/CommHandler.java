package fi.utu.tech.telephonegame.network;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.concurrent.TransferQueue;



class CommHandler implements Runnable{

	  ObjectInputStream in;
	  ObjectOutputStream out;
	  Socket s;
	  TransferQueue<Object> outQueue;
	 
	  public CommHandler(Socket s, TransferQueue<Object> outQueue) throws IOException {
	    this.s = s;
	    this.outQueue = outQueue;

	  }

	public void send(Envelope envelope) {

	  	Send aa = new Send (out,envelope);
		new Thread(aa).start();
	}

	  public void run() {
		  try {
			out = new ObjectOutputStream(s.getOutputStream());
			in = new ObjectInputStream(s.getInputStream());
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		  while(true) {
			  try {
				  Object tmp = in.readObject();
				  if(tmp instanceof Envelope)
					  outQueue.add(((Envelope) tmp).getPayload());
			  } catch (IOException | ClassNotFoundException e) {
				  e.printStackTrace();
			  }
		  }

	  }

	  }
	
