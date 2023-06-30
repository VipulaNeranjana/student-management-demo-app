package lk.ijse.dep10.smsspringbootbackend.business.impl;

import lk.ijse.dep10.smsspringbootbackend.business.StudentBO;
import lk.ijse.dep10.smsspringbootbackend.business.exception.DuplicateRecordException;
import lk.ijse.dep10.smsspringbootbackend.business.util.Transformer;
import lk.ijse.dep10.smsspringbootbackend.dao.custom.StudentDAO;
import lk.ijse.dep10.smsspringbootbackend.dto.StudentDTO;
import lk.ijse.dep10.smsspringbootbackend.entity.Student;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class StudentBOImpl implements StudentBO {
    private final StudentDAO studentDAO;
    private final Transformer transformer;

    public StudentBOImpl(StudentDAO studentDAO, Transformer transformer) {
        this.studentDAO = studentDAO;
        this.transformer = transformer;
    }

    @Override
    public List<StudentDTO> getAllStudents() throws Exception {
        return studentDAO.findAll().stream().map(transformer::fromStudentEntity).collect(Collectors.toList());
    }

    @Override
    public StudentDTO saveStudent(StudentDTO studentDTO) throws Exception {
        if(studentDAO.existsById(String.valueOf(studentDTO.getId()))){
            throw new DuplicateRecordException(studentDTO.getId()+ " already exist");
        }
        Student student = studentDAO.save(transformer.toStudentEntity(studentDTO));
        return transformer.fromStudentEntity(student);
    }

    @Override
    public void delete(String studentId) throws Exception {
        if(!studentDAO.existsById(studentId)){
            throw new DuplicateRecordException(studentId+ " not exist");
        }
        studentDAO.deleteById(studentId);
    }

}
