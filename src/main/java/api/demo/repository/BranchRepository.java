package api.demo.repository;

import api.demo.model.Branch;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BranchRepository extends JpaRepository<Branch,Long> {
}
