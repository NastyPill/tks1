package com.poly.server.entities;

import lombok.Data;

import java.util.Date;

@Data
public class Message {

    private String username;

    private String message;

    private String fileName;

    private byte[] content;

    private Date date;
}
