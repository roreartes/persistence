package ar.com.ada.sb.api.persistence.persistence.model.mapper;

import ar.com.ada.sb.api.persistence.persistence.model.dto.CourseDto;
import ar.com.ada.sb.api.persistence.persistence.model.entity.Course;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {})
public interface CourseMapper extends DataMapper<Course, CourseDto> {

    Course toEntity(CourseDto dto);
    CourseDto toDto(Course entity);
}
