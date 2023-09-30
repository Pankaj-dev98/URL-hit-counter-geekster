package com.geekster.urlhitcounter.service;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class VisitorErrorResponse {
    private LocalDateTime timeStamp;
    private String message;
    private int status;
}
