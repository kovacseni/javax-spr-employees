package empapp.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.envers.Audited;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static lombok.AccessLevel.PRIVATE;

@Entity
@Data
@NoArgsConstructor(access = PRIVATE)
// Spring Data JPA auditing
//@EntityListeners(AuditingEntityListener.class)

// Hibernate Envers
//@Audited
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    // Spring Data JPA auditing
//    @CreatedDate
//    private LocalDateTime createdAt;

    // Spring Data JPA auditing
//    @LastModifiedDate
//    private LocalDateTime lastModifiedAt;

    // Spring Data JPA auditing
//    @CreatedBy
//    private String createdBy;

    // Spring Data JPA auditing
//    @LastModifiedBy
//    private String lastModifiedBy;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    private List<Address> addresses = new ArrayList<>();

    public Employee(String name) {
        this.name = name;
    }

    public void addAddress(Address address) {
        addresses.add(address);
        address.setEmployee(this);
    }

    public void addAddresses(List<Address> addresses) {
        addresses.forEach(this::addAddress);
    }
}
