package api.demo.controller;

import api.demo.dto.branch.FullBranchDto;
import api.demo.dto.branch.ShortBranchDto;
import api.demo.service.branch.BranchService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping(path = "/branch")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BranchController {

    final BranchService branchService;
    Long ID;

    @GetMapping
    public String getAllBranch(Model model) {
        List<ShortBranchDto> branchDtos = branchService.getAllBranches();
        log.info(branchDtos.toString());
        model.addAttribute("branches", branchDtos);
        return "branches";
    }

    @GetMapping(path = "/{id}")
    public String getById(@PathVariable Long id,Model model) {
        log.info(branchService.getById(id).toString());
        model.addAttribute("branch", branchService.getById(id));
        return "branch";
    }
    

    @PostMapping(path = "/add-branch")
    public String addNewBranch(@Valid @ModelAttribute("fullBranchDto") FullBranchDto fullBranchDto) {
        branchService.addNewBranch(fullBranchDto);
        return "redirect:/branch";
    }

    @GetMapping("/add-branch")
    public String showAddingForm(Model model) {
        model.addAttribute("fullBranchDto",new FullBranchDto());
        return "add-branch";
    }

    @PostMapping(path = "/delete/{id}")
    public String deleteBranch() {
        branchService.deleteBranch(ID);
        return "redirect:/branch";
    }
    @GetMapping(path = "/delete/{id}")
    public String showDeleteForm(@PathVariable Long id,Model model) {
        ID=id;
        model.addAttribute("fullBranchDto",branchService.getByIdDto(id));

        return "delete-branch";
    }
}
