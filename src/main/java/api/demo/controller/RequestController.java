package api.demo.controller;

import api.demo.dto.request.FullRequestDto;
import api.demo.dto.request.ShortRequestDto;
import api.demo.service.request.RequestService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "api/crud/request")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RequestController {

    final RequestService requestService;

    @GetMapping
    public List<ShortRequestDto> getAllRequests() {

        return List.of();
    }

    @PostMapping
    public ShortRequestDto addNewRequest(@Valid @RequestBody FullRequestDto requestDto) {

        return new ShortRequestDto();
    }

    @DeleteMapping(path = "/{id}")
    public void deleteRequest(@PathVariable("id") Long id) {
        requestService.deleteRequest(id);
    }
}
