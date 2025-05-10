package jsbrfs.service.mappers;

import jsbrfs.entity.Application;
import jsbrfs.service.dtos.requests.applications.CreateApplicationRequest;
import jsbrfs.service.dtos.requests.applications.UpdateApplicationRequest;
import jsbrfs.service.dtos.responses.applications.CreateApplicationResponse;
import jsbrfs.service.dtos.responses.applications.GetByIdApplicationResponse;
import jsbrfs.service.dtos.responses.applications.GetListApplicationResponse;
import jsbrfs.service.dtos.responses.applications.UpdateApplicationResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ApplicationMapper {
    ApplicationMapper INSTANCE = Mappers.getMapper(ApplicationMapper.class);

    @Mapping(source = "applicantId", target = "applicant.id")
    @Mapping(source = "bootcampId", target = "bootcamp.id")
    Application applicationFromCreateRequest(CreateApplicationRequest request);

    @Mapping(source = "applicantId", target = "applicant.id")
    @Mapping(source = "bootcampId", target = "bootcamp.id")
    Application applicationFromUpdateRequest(UpdateApplicationRequest request);

    @Mapping(source = "applicant.id", target = "applicantId")
    @Mapping(source = "bootcamp.id", target = "bootcampId")
    CreateApplicationResponse createResponseFromApplication(Application application);

    @Mapping(source = "applicant.id", target = "applicantId")
    @Mapping(source = "bootcamp.id", target = "bootcampId")
    UpdateApplicationResponse updateResponseFromApplication(Application application);

    @Mapping(source = "applicant.id", target = "applicantId")
    @Mapping(source = "bootcamp.id", target = "bootcampId")
    GetByIdApplicationResponse getByIdResponseFromApplication(Application application);

    @Mapping(source = "applicant.id", target = "applicantId")
    @Mapping(source = "bootcamp.id", target = "bootcampId")
    GetListApplicationResponse getListResponseFromApplication(Application application);
}
