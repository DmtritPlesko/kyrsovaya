package api.demo.controller;

import api.demo.dto.branch.FullBranchDto;
import api.demo.dto.branch.ShortBranchDto;
import api.demo.service.branch.BranchService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "api/crud/branch")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BranchController {

    final BranchService branchService;

    @GetMapping
    public List<ShortBranchDto> getAllBranch() {

        return List.of();
    }

    @PostMapping
    public ShortBranchDto addNewBranch(@Valid @RequestBody FullBranchDto branchDto) {

        return new ShortBranchDto();
    }

    @DeleteMapping(path = "/{id}")
    public void deleteBranch(@PathVariable("id") Long id) {
        branchService.deleteBranch(id);
    }
}
