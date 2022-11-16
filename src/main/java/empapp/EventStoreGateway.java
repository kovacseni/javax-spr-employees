//package empapp;
//
//import empapp.dto.MessageJmsDto;
//import lombok.AllArgsConstructor;
//import org.springframework.jms.core.JmsTemplate;
//
//// JMS üzenetküldés
//@Gateway
//@AllArgsConstructor
//public class EventStoreGateway {
//
//    private JmsTemplate jmsTemplate;
//
//    public void sendMessage(String text) {
//        jmsTemplate.convertAndSend("eventsQueue",  new MessageJmsDto(text));
//    }
//}
