package fi.utu.tech.telephonegame.network;

import java.io.IOException;
import java.io.ObjectOutputStream;

public class Send implements Runnable{

    ObjectOutputStream out;
    Envelope envelope;

    public Send(ObjectOutputStream objOutStream, Envelope envelope) {
        this.out = objOutStream;
        this.envelope = envelope;
    }

    @Override
    public void run() {
        try {
            if(envelope != null)
                out.writeObject(envelope);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
