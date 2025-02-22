package ma.seomaniak.test.Services;

import lombok.AllArgsConstructor;
import ma.seomaniak.test.Entities.Task;
import ma.seomaniak.test.Repositories.TaskRepository;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


@Service
@AllArgsConstructor
public class TaskServiceImp implements TaskService {


    private  TaskRepository taskRepository;


    @Override
    public Page<Task> searchTasksByStatus(String status, Pageable pageable) {
        return taskRepository.findByStatus(status, pageable);
    }

    @Override
    public Page<Task> searchTasksByTitle(String title, Pageable pageable) {
        return taskRepository.findByTitleContaining(title, pageable);
    }
}
