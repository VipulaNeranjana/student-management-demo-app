package lk.ijse.dep10.smsspringbootbackend.business;

import lk.ijse.dep10.smsspringbootbackend.dto.StudentDTO;

import java.util.List;

public interface StudentBO {

    List<StudentDTO> getAllStudents() throws Exception;
    void saveStudent(StudentDTO studentDTO) throws Exception;
    void updateStudent(StudentDTO studentDTO) throws Exception;

}
