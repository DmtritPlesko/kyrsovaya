package api.demo.service.request;
import api.demo.dto.request.FullRequestDto;
import api.demo.dto.request.ShortRequestDto;

import java.util.List;

public interface RequestService {

    List<ShortRequestDto> getAllRequests();

    ShortRequestDto getReqById(Long id);

    FullRequestDto getByIdDto(Long id);

    ShortRequestDto addNewRequest(FullRequestDto requestDto);

    void deleteRequest(Long id);
}
