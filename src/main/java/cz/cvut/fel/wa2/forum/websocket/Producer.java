package cz.cvut.fel.wa2.forum.websocket;

import org.apache.commons.lang.SerializationUtils;

import java.io.IOException;
import java.io.Serializable;

public class Producer extends Endpoint {

    public Producer(String endPointName) throws IOException{
        super(endPointName);
    }

    public void sendMessage(Serializable object) throws IOException {
        System.out.println("rabbitmq: send message " + object.toString());
//        channel.basicPublish("logs", queueName, null, SerializationUtils.serialize(object));
        channel.basicPublish("logs", "", null, SerializationUtils.serialize(object));
    }
}
