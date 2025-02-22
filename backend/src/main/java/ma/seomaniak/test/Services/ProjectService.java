package ma.seomaniak.test.Services;

import ma.seomaniak.test.Entities.Project;
import ma.seomaniak.test.Entities.Task;

import java.util.List;
import java.util.UUID;

public interface ProjectService {

    public List<Project> getAllProjects();

    public Project saveProject(Project project);

    public Project getProject(UUID id);

    public void deleteProject(UUID id);

    public Project updateProject(UUID id , Project projectDetails);

    List<Task> getTasksOfProject(UUID id);

    Project addTaskToProject(UUID id, Task taskDetails);
}
