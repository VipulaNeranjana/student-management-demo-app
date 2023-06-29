package lk.ijse.dep10.smsspringbootbackend.business.impl;

import lk.ijse.dep10.smsspringbootbackend.business.StudentBO;
import lk.ijse.dep10.smsspringbootbackend.business.exception.DuplicateRecordException;
import lk.ijse.dep10.smsspringbootbackend.business.exception.RecordNotFoundException;
import lk.ijse.dep10.smsspringbootbackend.business.util.Transformer;
import lk.ijse.dep10.smsspringbootbackend.dao.custom.StudentDAO;
import lk.ijse.dep10.smsspringbootbackend.dto.StudentDTO;

import java.util.List;
import java.util.stream.Collectors;

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
    public void saveStudent(StudentDTO studentDTO) throws Exception {
        if(studentDAO.existsById(String.valueOf(studentDTO.getId()))){
            throw new DuplicateRecordException(studentDTO.getId()+ " already exist");
        }
        studentDAO.save(transformer.toStudentEntity(studentDTO));
    }

    @Override
    public void updateStudent(StudentDTO studentDTO) throws Exception {
        if(!studentDAO.existsById(String.valueOf(studentDTO.getId()))){
            throw new RecordNotFoundException(studentDTO.getId()+ " already exist");
        }
        studentDAO.update(transformer.toStudentEntity(studentDTO));
    }
}
