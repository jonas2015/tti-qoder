package com.ttigroup.controller;

import com.ttigroup.model.JobOpening;
import com.ttigroup.service.CareerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/careers")
@CrossOrigin(origins = "*")
public class CareerController {

    @Autowired
    private CareerService careerService;

    @GetMapping
    public ResponseEntity<List<JobOpening>> getAllJobs() {
        return ResponseEntity.ok(careerService.getAllJobs());
    }
}
