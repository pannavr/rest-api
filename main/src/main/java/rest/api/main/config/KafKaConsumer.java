package rest.api.main.config;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafKaConsumer {

    @KafkaListener (topics = "topic-user",
          groupId = "my-group-id")
    public void consume(String message){
        System.out.println(message);

    }
}
