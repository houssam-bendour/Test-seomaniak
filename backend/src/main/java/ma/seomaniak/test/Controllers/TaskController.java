package ma.seomaniak.test.Controllers;

import lombok.AllArgsConstructor;
import ma.seomaniak.test.Entities.Task;
import ma.seomaniak.test.Services.TaskService;

import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


@RestController
@AllArgsConstructor
@RequestMapping("/tasks")
public class TaskController {

    private TaskService taskService;

@GetMapping("/search")
public Page<Task> searchTasks(@RequestParam(required = false) String status,
                                  @RequestParam(required = false) String title,
                                  @RequestParam(defaultValue = "0") int page,
                                  @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);

        if (status != null) {
            return taskService.searchTasksByStatus(status, pageable);
        } else if (title != null) {
            return taskService.searchTasksByTitle(title, pageable);
        }
        return Page.empty(); 
    }

}