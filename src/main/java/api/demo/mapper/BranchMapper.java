package api.demo.mapper;

import api.demo.dto.branch.FullBranchDto;
import api.demo.dto.branch.ShortBranchDto;
import api.demo.model.Branch;
import org.springframework.stereotype.Component;

@Component
public class BranchMapper {

    public ShortBranchDto toShortBranchDto(Branch branch) {
        ShortBranchDto branchDto = new ShortBranchDto();

        branchDto.setBranchId(branch.getBranchId());
        branchDto.setName(branch.getName());
        branchDto.setAddress(branch.getAddress());

        return branchDto;
    }

    public Branch toBranch(FullBranchDto branchDto) {
        Branch branch = new Branch();

        branch.setAddress(branchDto.getAddress());
        branch.setName(branchDto.getName());
        branch.setPhone(branchDto.getPhone());

        return branch;
    }

    public FullBranchDto toFullBranchDto(Branch branch) {
        FullBranchDto branchDto = new FullBranchDto();

        branchDto.setAddress(branch.getAddress());
        branchDto.setPhone(branch.getPhone());
        branchDto.setName(branch.getName());

        return branchDto;
    }
}
