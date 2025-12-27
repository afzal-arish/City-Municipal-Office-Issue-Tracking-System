package com.examly.springapp.service;

import java.util.*;
import org.springframework.stereotype.Service;
import com.examly.springapp.model.Project;

@Service
public class ProjectService {

    private final List<Project> projects = new ArrayList<>();
    private int idCounter = 1;

    public Project addProject(Project project) {
        project.setProjectId(idCounter++);
        projects.add(project);
        return project;
    }

    public List<Project> getAllProjects() {
        return projects;
    }

    public Project getProjectById(int id) {
        return projects.stream().filter(p -> p.getProjectId() == id).findFirst().orElse(null);
    }

    public Project updateProject(int id, Project updated) {
        Project p = getProjectById(id);
        if (p != null) {
            p.setProjectName(updated.getProjectName());
            p.setDescription(updated.getDescription());
            p.setStatus(updated.getStatus());
        }
        return p;
    }

    public List<Project> getProjectsByStatus(String status) {
        List<Project> list = new ArrayList<>();
        for (Project p : projects) {
            if (p.getStatus().equalsIgnoreCase(status)) list.add(p);
        }
        return list;
    }
}
