package com.examly.springapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import com.examly.springapp.model.Project;
import com.examly.springapp.service.ProjectService;

@RestController
@RequestMapping("/api/projects")
public class ProjectController {

    @Autowired
    private ProjectService service;

    @PostMapping
    public ResponseEntity<Project> add(@RequestBody Project p) {
        return new ResponseEntity<>(service.addProject(p), HttpStatus.CREATED);
    }

    @GetMapping
    public List<Project> getAll() {
        return service.getAllProjects();
    }

    @GetMapping("/{id}")
    public Project getById(@PathVariable int id) {
        return service.getProjectById(id);
    }

    @PutMapping("/{id}")
    public Project update(@PathVariable int id, @RequestBody Project p) {
        return service.updateProject(id, p);
    }

    @GetMapping("/status/{status}")
    public ResponseEntity<?> getByStatus(@PathVariable String status) {
        List<Project> list = service.getProjectsByStatus(status);
        if (list.isEmpty())
            return new ResponseEntity<>("No projects found with status: " + status, HttpStatus.NO_CONTENT);
        return ResponseEntity.ok(list);
    }
}
