package com.ttigroup.controller;

import com.ttigroup.model.CompanyInfo;
import com.ttigroup.service.CompanyInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/about")
@CrossOrigin(origins = "*")
public class CompanyInfoController {

    @Autowired
    private CompanyInfoService companyInfoService;

    @GetMapping
    public ResponseEntity<CompanyInfo> getCompanyInfo() {
        return ResponseEntity.ok(companyInfoService.getCompanyInfo());
    }
}
