package api.demo.service.request;

import api.demo.dto.request.FullRequestDto;
import api.demo.dto.request.ShortRequestDto;
import api.demo.mapper.RequestMapper;
import api.demo.repository.RequestRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RequestServiceImpl implements RequestService {

    final RequestRepository repository;
    final RequestMapper requestMapper;

    @Override
    public List<ShortRequestDto> getAllRequests() {
        return repository.findAll().stream()
                .map(requestMapper::toShortRequestDto)
                .toList();
    }

    @Override
    public ShortRequestDto getReqById(Long id) {
        return requestMapper.toShortRequestDto(repository.findById(id).get());
    }

    @Override
    public FullRequestDto getByIdDto(Long id) {
        return requestMapper.toFullRequestDto(repository.findById(id).get());
    }

    @Override
    public ShortRequestDto addNewRequest(FullRequestDto requestDto) {
        return requestMapper.toShortRequestDto(repository.save(requestMapper.toRequest(requestDto)));
    }

    @Override
    public void deleteRequest(Long id) {
        if (repository.findById(id).isPresent()) {
            repository.deleteById(id);
        } else {
            throw new IllegalArgumentException("Запись Request c id = " + id + " не существует");
        }
    }
}
