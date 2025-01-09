package api.demo.dto.branch;

import lombok.Data;

@Data
public class FullBranchDto {

    Long branchId;

    String name;

    String address;

    String phone;
}
