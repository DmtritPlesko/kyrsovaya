package api.demo.mapper;

import api.demo.dto.branch.FullBranchDto;
import api.demo.dto.branch.ShortBranchDto;
import api.demo.model.Branch;
import org.springframework.stereotype.Component;

@Component
public class BranchMapper {

    public ShortBranchDto toShortBranchDto(Branch branch) {
        ShortBranchDto branchDto = new ShortBranchDto();

        branchDto.setBranchId(branchDto.getBranchId());
        branchDto.setName(branchDto.getName());
        branchDto.setAddress(branchDto.getAddress());

        return branchDto;
    }

    public Branch toBranch(FullBranchDto branchDto) {
        Branch branch = new Branch();

        branch.setBranchId(branchDto.getBranchId());
        branch.setAddress(branchDto.getAddress());
        branch.setName(branchDto.getName());
        branch.setPhone(branchDto.getPhone());

        return branch;
    }
}
