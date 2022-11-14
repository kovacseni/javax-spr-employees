//package empapp.entity;
//
//import org.hibernate.envers.RevisionListener;
//
//import java.util.UUID;
//
//// Hibernate Envers saját mezők a Revision táblába
//public class StubUsernameListener implements RevisionListener {
//
//    @Override
//    public void newRevision(Object o) {
//        if (o instanceof EmployeeRevisionEntity revision) {
//            revision.setUsername("admin"); // Spring Security-ből kérjük le a bejelentkezett felhasználót, aki módosít
//            revision.setUuid(UUID.randomUUID().toString());
//        }
//    }
//}
