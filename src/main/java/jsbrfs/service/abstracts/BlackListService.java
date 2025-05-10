package jsbrfs.service.abstracts;

import jsbrfs.service.dtos.requests.blackLists.CreateBlackListRequest;
import jsbrfs.service.dtos.requests.blackLists.UpdateBlackListRequest;
import jsbrfs.service.dtos.responses.blackLists.CreateBlackListResponse;
import jsbrfs.service.dtos.responses.blackLists.GetByIdBlackListResponse;
import jsbrfs.service.dtos.responses.blackLists.GetListBlackListResponse;
import jsbrfs.service.dtos.responses.blackLists.UpdateBlackListResponse;

import java.util.List;

public interface BlackListService {
    CreateBlackListResponse add(CreateBlackListRequest request);
    UpdateBlackListResponse update(UpdateBlackListRequest request);
    void delete(Long id);

    GetByIdBlackListResponse getById(Long id);
    List<GetListBlackListResponse> getAll();
}
