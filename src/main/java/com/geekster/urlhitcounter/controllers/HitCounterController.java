package com.geekster.urlhitcounter.controllers;

import com.geekster.urlhitcounter.entity.Visitor;
import com.geekster.urlhitcounter.service.UrlHitService;
import com.geekster.urlhitcounter.service.VisitorErrorResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class HitCounterController {
    private UrlHitService urlHitService;

    @Autowired
    public HitCounterController(UrlHitService urlHitService) {
        this.urlHitService = urlHitService;
    }

    @PostMapping("/visitor")
    public String addVisitor(@RequestBody Visitor visitor) {
        urlHitService.addVisitor(visitor);

        return "user was added";
    }

    @GetMapping("/count")
    public String getTotalHitCount() {
        return urlHitService.getTotalHitCount();
    }

    @GetMapping("/username/{userName}/count")
    public String getHitCountByName(@PathVariable String userName) {
        return urlHitService.getHitCountByName(userName);
    }

    @GetMapping("/visitors")
    public Map<String, Integer> getAllVisitors() {
        return urlHitService.getAllVisitors();
    }

    @GetMapping("/visitors/count")
    public String getVisitorCount() {
        return urlHitService.getVisitorCount();
    }

    @PutMapping("/count-update/username/{userName}")
    public String incrementHitCountByName(@PathVariable String userName) {
        return urlHitService.incrementHitCountByName(userName);
    }

    @ExceptionHandler
    public ResponseEntity<VisitorErrorResponse> handleException(RuntimeException e) {
        e.printStackTrace();

        VisitorErrorResponse error = new VisitorErrorResponse();

        error.setTimeStamp(LocalDateTime.now());
        error.setMessage(e.getMessage());
        error.setStatus(HttpStatus.BAD_REQUEST.value());

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);

    }
}
