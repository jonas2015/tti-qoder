package com.ttigroup.controller;

import com.ttigroup.model.ContactMessage;
import com.ttigroup.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping("/api/contact")
@CrossOrigin(origins = "*")
public class ContactController {

    @Autowired
    private ContactService contactService;

    @PostMapping
    public ResponseEntity<Map<String, Object>> submitContact(@RequestBody ContactMessage contact) {
        Map<String, Object> response = contactService.submitContact(contact);
        return ResponseEntity.ok(response);
    }
}
