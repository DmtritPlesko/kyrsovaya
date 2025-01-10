package api.demo.service.branch;

import api.demo.dto.branch.FullBranchDto;
import api.demo.dto.branch.ShortBranchDto;
import java.util.List;

public interface BranchService {

    List<ShortBranchDto> getAllBranches();

    ShortBranchDto getById(Long id);

    FullBranchDto getByIdDto(Long id);

    ShortBranchDto addNewBranch(FullBranchDto branchDto);

    void deleteBranch(Long id);
}
