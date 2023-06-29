package lk.ijse.dep10.smsspringbootbackend.api;

import lk.ijse.dep10.smsspringbootbackend.business.StudentBO;
import lk.ijse.dep10.smsspringbootbackend.dto.StudentDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/students")
public class StudentController {
    private final StudentBO studentBO;


    public StudentController(StudentBO studentBO) {
        this.studentBO = studentBO;
    }

    @GetMapping
    public List<StudentDTO> getAllStudents() throws Exception{
        return studentBO.getAllStudents();
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public void saveStudent(@RequestBody @Valid StudentDTO studentDTO) throws Exception {
        studentBO.saveStudent(studentDTO);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{studentId}")
    public void deleteCustomer(@PathVariable("studentId") String studentId) throws Exception {
        studentBO.delete(studentId);
    }
}
