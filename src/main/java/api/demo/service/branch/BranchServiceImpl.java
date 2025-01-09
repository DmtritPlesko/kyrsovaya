package api.demo.service.branch;

import api.demo.dto.branch.FullBranchDto;
import api.demo.dto.branch.ShortBranchDto;
import api.demo.mapper.BranchMapper;
import api.demo.repository.BranchRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BranchServiceImpl implements BranchService{

    final BranchRepository repository;
    final BranchMapper branchMapper;

    @Override
    public List<ShortBranchDto> getAllBranches() {
        return repository.findAll().stream()
                .map(branchMapper::toShortBranchDto)
                .toList();
    }

    @Override
    public ShortBranchDto addNewBranch(FullBranchDto branchDto) {
        return branchMapper.toShortBranchDto(repository.save(branchMapper.toBranch(branchDto)));
    }

    @Override
    public void deleteBranch(Long id) {
        if(repository.findById(id).isPresent()) {
            repository.deleteById(id);
        } else {
            throw new IllegalArgumentException("Запись Branch с id = "+ id+ " не существует");
        }
    }
}
