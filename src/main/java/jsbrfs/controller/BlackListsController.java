package jsbrfs.controller;

import jsbrfs.service.abstracts.BlackListService;
import jsbrfs.service.dtos.requests.blackLists.CreateBlackListRequest;
import jsbrfs.service.dtos.requests.blackLists.UpdateBlackListRequest;
import jsbrfs.service.dtos.responses.blackLists.CreateBlackListResponse;
import jsbrfs.service.dtos.responses.blackLists.GetByIdBlackListResponse;
import jsbrfs.service.dtos.responses.blackLists.GetListBlackListResponse;
import jsbrfs.service.dtos.responses.blackLists.UpdateBlackListResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/blacklists")
public class BlackListsController {
    private final BlackListService blackListService;

    public BlackListsController(BlackListService blackListService) {
        this.blackListService = blackListService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<GetListBlackListResponse> getAll(){
        return blackListService.getAll();
    }

    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public GetByIdBlackListResponse getById(@PathVariable Long id){
        return blackListService.getById(id);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public UpdateBlackListResponse update(@RequestBody UpdateBlackListRequest request){
        return blackListService.update(request);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreateBlackListResponse add(@RequestBody CreateBlackListRequest request){
        return blackListService.add(request);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable Long id){
        blackListService.delete(id);
    }
}
