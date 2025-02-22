package ma.seomaniak.test.Repositories;

import ma.seomaniak.test.Entities.Project;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProjectRepository extends JpaRepository<Project, UUID> {

}
