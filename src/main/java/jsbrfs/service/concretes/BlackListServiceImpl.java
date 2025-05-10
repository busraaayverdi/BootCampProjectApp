package jsbrfs.service.concretes;

import jsbrfs.entity.BlackList;
import jsbrfs.repository.BlackListRepository;
import jsbrfs.service.abstracts.BlackListService;
import jsbrfs.service.dtos.requests.blackLists.CreateBlackListRequest;
import jsbrfs.service.dtos.requests.blackLists.UpdateBlackListRequest;
import jsbrfs.service.dtos.responses.blackLists.CreateBlackListResponse;
import jsbrfs.service.dtos.responses.blackLists.GetByIdBlackListResponse;
import jsbrfs.service.dtos.responses.blackLists.GetListBlackListResponse;
import jsbrfs.service.dtos.responses.blackLists.UpdateBlackListResponse;
import jsbrfs.service.mappers.BlackListMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BlackListServiceImpl implements BlackListService {
    private final BlackListRepository repository;

    public BlackListServiceImpl(BlackListRepository repository) {
        this.repository = repository;
    }


    @Override
    public CreateBlackListResponse add(CreateBlackListRequest request) {
        BlackList blackList = BlackListMapper.INSTANCE.blackListFromCreateRequest(request);
        blackList = repository.save(blackList);
        return BlackListMapper.INSTANCE.createResponseFromBlackList(blackList);
    }

    @Override
    public UpdateBlackListResponse update(UpdateBlackListRequest request) {
        BlackList existing = repository.findById(request.id())
                .orElseThrow(() -> new RuntimeException("BlackList not found by id: " + request.id()));

        BlackList updated = BlackListMapper.INSTANCE.blackListFromUpdateRequest(request);
        updated.setId(existing.getId());
        BlackList saved = repository.save(updated);

        return BlackListMapper.INSTANCE.updateResponseFromBlackList(saved);
    }

    @Override
    public void delete(Long id) {
        BlackList blackList = repository.findById(id).orElseThrow(() -> new RuntimeException("BlackList not found by id:"+ id));

        repository.delete(blackList);
    }

    @Override
    public GetByIdBlackListResponse getById(Long id) {
        BlackList blackList = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("BlackList not found by id: " + id));
        return BlackListMapper.INSTANCE.getByIdResponseFromBlackList(blackList);
    }

    @Override
    public List<GetListBlackListResponse> getAll() {
        return repository.findAll().stream()
                .map(BlackListMapper.INSTANCE::getListResponseFromBlackList)
                .collect(Collectors.toList());
    }
}
