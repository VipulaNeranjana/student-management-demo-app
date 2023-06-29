package lk.ijse.dep10.smsspringbootbackend.business.util;

import lk.ijse.dep10.smsspringbootbackend.dto.StudentDTO;
import lk.ijse.dep10.smsspringbootbackend.entity.Student;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.awt.print.Book;
@Component
public class Transformer {
    private final ModelMapper modelMapper;

    public Transformer(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public Student toStudentEntity(StudentDTO studentDTO){
        return modelMapper.map(studentDTO, Student.class);
    }
    public StudentDTO fromStudentEntity(Student student){
        return modelMapper.map(student, StudentDTO.class);
    }
}
