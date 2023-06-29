package lk.ijse.dep10.smsspringbootbackend.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Student implements SuperEntity{
    private Integer id;
    private String name;
    private String address;
}
