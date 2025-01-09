package api.demo.mapper;

import api.demo.dto.request.FullRequestDto;
import api.demo.dto.request.ShortRequestDto;
import api.demo.model.Request;
import org.springframework.stereotype.Component;

@Component
public class RequestMapper {

    public ShortRequestDto toShortRequestDto(Request request) {
        ShortRequestDto requestDto = new ShortRequestDto();

        requestDto.setTicketId(request.getTicketId());
        requestDto.setDescription(requestDto.getDescription());

        return requestDto;
    }

    public Request toRequest(FullRequestDto requestDto) {
        Request request = new Request();

        request.setTicketId(requestDto.getTicketId());
        request.setStatus(requestDto.getStatus());
        request.setDescription(requestDto.getDescription());
        request.setCloseDate(requestDto.getCloseDate());
        request.setDateCreated(requestDto.getDateCreated());

        return request;
    }
}
