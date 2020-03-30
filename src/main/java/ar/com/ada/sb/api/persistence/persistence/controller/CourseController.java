package ar.com.ada.sb.api.persistence.persistence.controller;

import ar.com.ada.sb.api.persistence.persistence.model.dto.CourseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.math.BigDecimal;

@RestController
@RequestMapping("/courses")
public class CourseController {

    @PostMapping({"", "/"})
    public ResponseEntity newCourse(@RequestBody @Valid CourseDto courseDto){

        return ResponseEntity.ok().body(null);
    }
    }