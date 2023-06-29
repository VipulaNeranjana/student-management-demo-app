package lk.ijse.dep10.smsspringbootbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentDTO implements Serializable {
    @NotBlank(message = "id cant be empty")
    private int id;
    @NotBlank(message = "name cant be empty")
    private String name;
    @NotBlank(message = "message cant be empty")
    private String address;
}
