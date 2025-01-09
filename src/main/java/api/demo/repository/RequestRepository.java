package api.demo.repository;

import api.demo.model.Request;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RequestRepository extends JpaRepository<Request,Long> {
}
