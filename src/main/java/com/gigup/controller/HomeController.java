package com.gigup.controller;

import com.gigup.model.Project;
import com.gigup.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDateTime;
import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private ProjectService projectService;

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("currentTime", LocalDateTime.now());
        
        // Get latest open projects
        List<Project> latestProjects = projectService.findByStatus("OPEN");
        model.addAttribute("latestProjects", latestProjects);
        
        return "index";
    }
    
    @GetMapping("/dashboard")
    public String dashboard() {
        return "dashboard";
    }
}

