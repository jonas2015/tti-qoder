package com.ttigroup.service;

import com.ttigroup.model.JobOpening;
import org.springframework.stereotype.Service;
import java.util.Arrays;
import java.util.List;

@Service
public class CareerService {

    public List<JobOpening> getAllJobs() {
        return Arrays.asList(
            new JobOpening(1L, "Senior Software Engineer", "Engineering", "Charlotte, NC", "Design and develop scalable microservices for our e-commerce platform. Work with modern technologies including Spring Boot, Kubernetes, and AWS.", "Full-time"),
            new JobOpening(2L, "Product Manager", "Product", "New York, NY", "Lead product strategy for our power tools division. Define roadmap, conduct user research, and collaborate with engineering teams.", "Full-time"),
            new JobOpening(3L, "Data Analyst", "Analytics", "Chicago, IL", "Analyze business performance data and create dashboards. Work with SQL, Python, and BI tools to drive insights.", "Full-time"),
            new JobOpening(4L, "Marketing Manager", "Marketing", "Los Angeles, CA", "Develop and execute marketing campaigns for brand launches. Manage digital marketing budget and analyze campaign performance.", "Full-time"),
            new JobOpening(5L, "Supply Chain Analyst", "Operations", "Dallas, TX", "Optimize supply chain processes and manage vendor relationships. Improve efficiency and reduce costs across distribution networks.", "Full-time"),
            new JobOpening(6L, "UX Designer", "Design", "San Francisco, CA", "Create intuitive user experiences for web and mobile applications. Conduct user research and create wireframes and prototypes.", "Full-time"),
            new JobOpening(7L, "Financial Analyst", "Finance", "Charlotte, NC", "Support financial planning and analysis. Create forecasts, analyze variance, and provide strategic recommendations.", "Full-time"),
            new JobOpening(8L, "HR Coordinator", "Human Resources", "Charlotte, NC", "Support employee lifecycle processes including onboarding, benefits administration, and HR systems management.", "Full-time")
        );
    }
}
