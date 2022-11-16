//package empapp;
//
//import empapp.dto.MessageJmsDto;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
//import org.springframework.jms.support.converter.MessageConverter;
//
//import java.util.Map;
//
//// JMS üzenetküldés
//@Configuration
//public class JmsConfig {
//
//    @Bean
//    public MessageConverter messageConverter() {
//        var converter = new MappingJackson2MessageConverter();
//        converter.setTypeIdPropertyName("_typeId");
//        converter.setTypeIdMappings(Map.of("CreateEventCommand", MessageJmsDto.class));
//        return converter;
//    }
//}
