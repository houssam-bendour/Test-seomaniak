package ma.seomaniak.test.Services;

import ma.seomaniak.test.Entities.Task;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TaskService {

  public Page<Task> searchTasksByStatus(String status, Pageable pageable);

    public Page<Task> searchTasksByTitle(String title, Pageable pageable);
}
