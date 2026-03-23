package com.ttigroup.service;

import com.ttigroup.model.ContactMessage;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Service
public class ContactService {

    private final Map<String, ContactMessage> messages = new HashMap<>();

    public Map<String, Object> submitContact(ContactMessage contact) {
        contact.setSubmittedAt(LocalDateTime.now());
        String id = String.valueOf(System.currentTimeMillis());
        messages.put(id, contact);

        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", "Thank you for contacting us. We will get back to you shortly.");
        response.put("referenceId", id);

        return response;
    }
}
