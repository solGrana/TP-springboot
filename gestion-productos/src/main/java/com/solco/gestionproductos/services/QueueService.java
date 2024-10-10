package com.solco.gestionproductos.services;

import com.solco.gestionproductos.models.ProductMessage;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

@Service
public class QueueService {

    private final Queue<ProductMessage> queue = new LinkedList<>(); //queue tipo productMessage, final porque no se puede modificar

    public List<ProductMessage> getMessages() {
        return List.copyOf(queue);
    }

    /*
    public List<ProductMessage> getMessages() {
    List<ProductMessage> messages = new ArrayList<>();
    for (ProductMessage message : queue) {
        messages.add(message);
    }
    return messages;
}
 */

    public ProductMessage pushMessage(ProductMessage message) {
        message.setState("AVAILABLE");
        queue.add(message);
        return message;
    }

    public ProductMessage popMessage() {
        ProductMessage message = queue.poll();
        if (message != null) {
            message.setState("ACQUIRED");
        }
        return message;
    }
}
