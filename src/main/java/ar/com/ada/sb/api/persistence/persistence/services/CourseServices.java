package ar.com.ada.sb.api.persistence.persistence.services;

import ar.com.ada.sb.api.persistence.persistence.exception.ApiEntityError;
import ar.com.ada.sb.api.persistence.persistence.exception.BusinessLogicException;
import ar.com.ada.sb.api.persistence.persistence.model.dto.CourseDto;
import ar.com.ada.sb.api.persistence.persistence.model.entity.Course;
import ar.com.ada.sb.api.persistence.persistence.model.mapper.CourseMapper;
import ar.com.ada.sb.api.persistence.persistence.model.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.lang.annotation.Annotation;
import java.util.List;
import java.util.Optional;

@Service("courseServices ")
public class CourseServices implements Services<CourseDto>{

    @Autowired @Qualifier("courseRespository")
    private CourseRepository courseRepository;

    private final CourseMapper coursemapper;

    public CourseServices(CourseMapper coursemapper) {
        this.coursemapper = coursemapper;
    }

    @Override
    public CourseDto save(CourseDto dto) {
        //1- Consultar en la base de datos si existe un curso con el codigo que tiene el dto(findbycode())
        Optional<Course> byCode = courseRepository.findByCode(dto.getCode());

        //2- si existe, disparar una excepcion de tipo businesslogicexception que indique q no se puede guardar
        //un curso con ese codigo porque ya existe
        byCode.ifPresent(course -> {
            ApiEntityError apiEntityError = new ApiEntityError(
                    "Course", "Already exists", "The course code" + course.getCode()+  "is already assigned"
            );
            throw new BusinessLogicException("course already exist", HttpStatus.CONFLICT, apiEntityError);
        });

        //3-si no existe se convierte el dto en entity y se guarda en una variable de ese tipo
        Course courseToSave = coursemapper.toEntity(dto);

        //4-se le indica al repositorio que guarde esa variable de tipo entity en la base de datos(save())
        Course savedEntity = courseRepository.save(courseToSave);
        //5-se convierte la variable de tipo entity guardada en la db a dto
        CourseDto saveDto = coursemapper.toDto(savedEntity);
        //se retorna el dto convertido de entity


        return saveDto ;
    }

    @Override
    public List<CourseDto> findAll() {
        return null;
    }

    @Override
    public Boolean delete(Long id) {
        return null;
    }
}
