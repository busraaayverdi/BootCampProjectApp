package jsbrfs.service.mappers;

import jsbrfs.entity.BlackList;
import jsbrfs.service.dtos.requests.blackLists.CreateBlackListRequest;
import jsbrfs.service.dtos.requests.blackLists.UpdateBlackListRequest;
import jsbrfs.service.dtos.responses.blackLists.CreateBlackListResponse;
import jsbrfs.service.dtos.responses.blackLists.GetByIdBlackListResponse;
import jsbrfs.service.dtos.responses.blackLists.GetListBlackListResponse;
import jsbrfs.service.dtos.responses.blackLists.UpdateBlackListResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BlackListMapper {
    BlackListMapper INSTANCE = Mappers.getMapper(BlackListMapper.class);

    @Mapping(source = "applicantId", target = "applicant.id")
    BlackList blackListFromCreateRequest(CreateBlackListRequest request);

    @Mapping(source = "applicantId", target = "applicant.id")
    BlackList blackListFromUpdateRequest(UpdateBlackListRequest request);

    @Mapping(source = "applicant.id", target = "applicantId")
    CreateBlackListResponse createResponseFromBlackList(BlackList blackList);

    @Mapping(source = "applicant.id", target = "applicantId")
    UpdateBlackListResponse updateResponseFromBlackList(BlackList blackList);

    @Mapping(source = "applicant.id", target = "applicantId")
    GetByIdBlackListResponse getByIdResponseFromBlackList(BlackList blackList);

    @Mapping(source = "applicant.id", target = "applicantId")
    GetListBlackListResponse getListResponseFromBlackList(BlackList blackList);
}
