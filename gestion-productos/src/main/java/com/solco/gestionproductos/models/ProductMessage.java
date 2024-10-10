package com.solco.gestionproductos.models;

public class ProductMessage {
    private String messageId;
    private String content;
    private String userId;
    private String to;
    private String state; // Estados: AVAILABLE, ACQUIRED, SETTLED
    private int priority;
    private String contentType;
    private int expiryTime;

    // Constructor, getters, setters y toString
}
