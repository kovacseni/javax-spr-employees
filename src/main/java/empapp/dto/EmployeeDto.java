package empapp.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class EmployeeDto implements Serializable {

    private Long id;

    private String name;

    // HTTP cache, ETag értéke
//    private int version;

    private List<AddressDto> addresses;
}
