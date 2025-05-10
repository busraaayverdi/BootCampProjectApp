package jsbrfs.service.mappers;

import jsbrfs.entity.Bootcamp;
import jsbrfs.service.dtos.requests.bootcamps.CreateBootcampRequest;
import jsbrfs.service.dtos.requests.bootcamps.UpdateBootcampRequest;
import jsbrfs.service.dtos.responses.bootcamps.CreateBootcampResponse;
import jsbrfs.service.dtos.responses.bootcamps.GetByIdBootcampResponse;
import jsbrfs.service.dtos.responses.bootcamps.GetListBootcampResponse;
import jsbrfs.service.dtos.responses.bootcamps.UpdateBootcampResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BootcampMapper {
    BootcampMapper INSTANCE = Mappers.getMapper(BootcampMapper.class);

    @Mapping(source = "instructorId", target = "instructor.id")
    Bootcamp bootcampFromCreateRequest(CreateBootcampRequest request);

    @Mapping(source = "instructorId", target = "instructor.id")
    Bootcamp bootcampFromUpdateRequest(UpdateBootcampRequest request);

    @Mapping(source = "instructor.id", target = "instructorId")
    CreateBootcampResponse createResponseFromBootcamp(Bootcamp bootcamp);

    @Mapping(source = "instructor.id", target = "instructorId")
    UpdateBootcampResponse updateResponseFromBootcamp(Bootcamp bootcamp);

    @Mapping(source = "instructor.id", target = "instructorId")
    GetByIdBootcampResponse getByIdResponseFromBootcamp(Bootcamp bootcamp);

    @Mapping(source = "instructor.id", target = "instructorId")
    GetListBootcampResponse getListResponseFromBootcamp(Bootcamp bootcamp);
}
