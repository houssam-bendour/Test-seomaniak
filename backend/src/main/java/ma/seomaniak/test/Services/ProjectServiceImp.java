package ma.seomaniak.test.Services;

import lombok.AllArgsConstructor;
import ma.seomaniak.test.Entities.Project;
import ma.seomaniak.test.Entities.Task;
import ma.seomaniak.test.Repositories.ProjectRepository;
import ma.seomaniak.test.Repositories.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class ProjectServiceImp implements ProjectService{

    private  ProjectRepository projectRepository;
    private  TaskRepository taskRepository;
    @Override
    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    @Override
    public Project saveProject(Project project) {
        return projectRepository.save(project);
    }

    @Override
    public Project getProject(UUID id) {
        return projectRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteProject(UUID id) {
        projectRepository.deleteById(id);
    }

    @Override
    public Project updateProject(UUID id, Project projectDetails) {
        return projectRepository.findById(id).map(project -> {
            project.setName(projectDetails.getName());
            project.setDescription(projectDetails.getDescription());
            project.setStartDate(projectDetails.getStartDate());
            project.setEndDate(projectDetails.getEndDate());
            return projectRepository.save(project);
        }).orElseThrow(() -> new RuntimeException("Projet non trouvé avec l'ID : " + id));
    }

    @Override
    public List<Task> getTasksOfProject(UUID id) {
        Project project = getProject(id);
        if(project != null)
            return project.getTasks();
        return List.of();
    }

    @Override
    public Project addTaskToProject(UUID id, Task taskDetails) {
        Optional<Project> projectOptional = projectRepository.findById(id);
        if (projectOptional.isPresent()) {
            Project project = projectOptional.get();
            taskDetails.setProject(project);
            project.getTasks().add(taskDetails);
            taskRepository.save(taskDetails);
            return projectRepository.save(project);
        } else {
            throw new RuntimeException("Projet non trouvé avec l'ID : " + id);
        }
    }
}
