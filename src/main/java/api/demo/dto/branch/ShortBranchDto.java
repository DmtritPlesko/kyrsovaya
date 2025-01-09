package api.demo.dto.branch;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ShortBranchDto {

    Long branchId;

    String name;

    String address;

    public ShortBranchDto(Long id,String name) {
        this.branchId = id;
        this.name = name;
    }
}
