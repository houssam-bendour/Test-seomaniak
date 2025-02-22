package ma.seomaniak.test.Controllers;

import lombok.AllArgsConstructor;
import ma.seomaniak.test.Entities.Project;
import ma.seomaniak.test.Entities.Task;
import ma.seomaniak.test.Services.ProjectService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("/project")
public class ProjectController {

    private  ProjectService projectService;

    @GetMapping
    public List<Project> getAllProjects() {
        return projectService.getAllProjects();
    }

    @PostMapping
    public Project createProject(@RequestBody Project project) {
        return projectService.saveProject(project);
    }

    @PutMapping("/{id}")
    public Project updateProject(@PathVariable UUID id, @RequestBody Project projectDetails) {
        return projectService.updateProject(id, projectDetails);
    }


    @DeleteMapping("/{id}")
    public void deleteProject(@PathVariable UUID id) {
        projectService.deleteProject(id);
    }
    @GetMapping("/{id}/tasks")
    public List<Task> getTasksOfProject(@PathVariable UUID id) {
        return projectService.getTasksOfProject(id);
    }

    @PostMapping("/{id}/tasks")
    public Project addTaskToProject(@PathVariable UUID id, @RequestBody Task taskDetails) {
        return projectService.addTaskToProject(id, taskDetails);
    }
}
