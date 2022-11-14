//package empapp.entity;
//
//import lombok.Data;
//import org.hibernate.envers.RevisionEntity;
//import org.hibernate.envers.RevisionNumber;
//import org.hibernate.envers.RevisionTimestamp;
//
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.Id;
//import javax.persistence.Table;
//import java.util.Date;
//
//// Hibernate Envers saját mezők a Revision táblába
//@Data
//@Entity
//@RevisionEntity(StubUsernameListener.class)
//@Table(name = "employee_revision_table")
//public class EmployeeRevisionEntity {
//
//    @Id
//    @GeneratedValue
//    @RevisionNumber
//    private int id;
//
//    @RevisionTimestamp
//    private Date revisionDate;
//
//    private String username;
//
//    private String uuid;
//}
