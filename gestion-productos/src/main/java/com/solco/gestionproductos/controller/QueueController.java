package com.solco.gestionproductos.controllers;

import com.solco.gestionproductos.models.ProductMessage;
import com.solco.gestionproductos.services.QueueService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/queue")
public class QueueController {

    private final QueueService queueService;

    public QueueController(QueueService queueService) {
        this.queueService = queueService;
    }

    @GetMapping
    public List<ProductMessage> getMessages() {
        return queueService.getMessages();
    }

    @PostMapping("/push")
    public ResponseEntity<ProductMessage> pushMessage(@RequestBody ProductMessage message) {
        return ResponseEntity.ok(queueService.pushMessage(message));
    }

    @DeleteMapping("/pop")
    public ResponseEntity<ProductMessage> popMessage() {
        ProductMessage message = queueService.popMessage();
        if (message != null) {
            return ResponseEntity.ok(message);
        }
        return ResponseEntity.noContent().build();
    }
}
