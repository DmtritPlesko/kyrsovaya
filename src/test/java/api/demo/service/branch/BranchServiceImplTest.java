package api.demo.service.branch;

import api.demo.dto.branch.FullBranchDto;
import api.demo.dto.branch.ShortBranchDto;
import api.demo.mapper.BranchMapper;
import api.demo.repository.BranchRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class BranchServiceImplTest {

    @Mock
    private BranchRepository repository;

    @Mock
    private BranchMapper branchMapper;

    @InjectMocks
    private BranchServiceImpl branchService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllBranches() {
        List<api.demo.model.Branch> branches = Arrays.asList(
                new api.demo.model.Branch(1L, "Branch 1"),
                new api.demo.model.Branch(2L, "Branch 2")
        );

        when(repository.findAll()).thenReturn(branches);

        List<ShortBranchDto> result = branchService.getAllBranches();

        assertEquals(2, result.size());
        verify(repository).findAll();
    }

    @Test
    void testAddNewBranch() {
        FullBranchDto branchDto = new FullBranchDto();
        branchDto.setName("New Branch");

        api.demo.model.Branch expectedBranch = new api.demo.model.Branch(1L, "New Branch");
        when(repository.save(any())).thenReturn(expectedBranch);

        when(branchMapper.toBranch(any(FullBranchDto.class))).thenReturn(expectedBranch);
        when(branchMapper.toShortBranchDto(expectedBranch)).thenReturn(new ShortBranchDto(1L, "New Branch"));

        ShortBranchDto result = branchService.addNewBranch(branchDto);

        assertNotNull(result);
        assertEquals("New Branch", result.getName());
        verify(repository).save(any());
    }

    @Test
    void testDeleteNonExistentBranch() {
        Long nonExistentId = 999L;

        assertThrows(IllegalArgumentException.class, () ->
                branchService.deleteBranch(nonExistentId)
        );
    }
}
