package lk.ijse.dep10.smsspringbootbackend.dao.custom.daoImpl;

import lk.ijse.dep10.smsspringbootbackend.dao.custom.StudentDAO;
import lk.ijse.dep10.smsspringbootbackend.entity.Student;
import lk.ijse.dep10.smsspringbootbackend.entity.SuperEntity;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import static lk.ijse.dep10.smsspringbootbackend.dao.util.Mappers.STUDENT_ROW_MAPPER;

public class StudentDAOImpl implements StudentDAO {

    private final JdbcTemplate jdbcTemplate;

    public StudentDAOImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public long count() throws Exception {
        return jdbcTemplate.queryForObject("SELECT COUNT(*) FROM student", Long.class);
    }

    @Override
    public Student save(Student entity) throws Exception {
        jdbcTemplate.update("INSERT INTO student (id,name,address) VALUES (?,?,?)",entity.getId(),entity.getName(),entity.getAddress());
        return entity;
    }

    @Override
    public void update(Student entity) throws Exception {
        jdbcTemplate.update("UPDATE student SET name=? AND address=? WHERE id=?",entity.getName(),entity.getAddress(),entity.getId());
    }

    @Override
    public void deleteById(String pk) throws Exception {
        jdbcTemplate.update("DELETE FROM student WHERE id=?",pk);
    }

    @Override
    public Optional<Student> findById(String pk) throws Exception {
        try {
            return Optional.of(jdbcTemplate.queryForObject("SELECT * FROM student WHERE id=?",STUDENT_ROW_MAPPER,pk));
        }catch (DataAccessException e){
            return Optional.empty();
        }
    }

    @Override
    public List<Student> findAll() throws Exception {
        return jdbcTemplate.query("SELECT * FROM student",STUDENT_ROW_MAPPER);
    }

    @Override
    public boolean existsById(String pk) throws Exception {
        return findById(pk).isPresent();
    }


}
