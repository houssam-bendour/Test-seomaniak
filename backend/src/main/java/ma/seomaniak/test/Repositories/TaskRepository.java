package ma.seomaniak.test.Repositories;

import ma.seomaniak.test.Entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TaskRepository extends JpaRepository<Task, UUID> {
  Page<Task> findByStatus(String status, Pageable pageable);
  Page<Task> findByTitleContaining(String title, Pageable pageable);
}