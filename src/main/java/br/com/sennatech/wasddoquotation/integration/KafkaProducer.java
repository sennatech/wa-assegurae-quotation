package br.com.sennatech.wasddoquotation.integration;

import br.com.sennatech.wasddoquotation.domain.dto.QuotationKafkaMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class KafkaProducer {

    private final KafkaTemplate<Object, QuotationKafkaMessage> kafkaTemplate;

    @Value("${topic.name}")
    private String topicName;
    private QuotationKafkaMessage kafkaMessage;

    public void send(QuotationKafkaMessage message) {
        this.kafkaTemplate.send(topicName, message);
        log.info("Published the amount [{}], with quotation code: [{}] to the kafka queue: [{}]",
                message.getData().getAmount(),
                message.getData().getQuotationNumber(),
                topicName
        );
        System.out.println(kafkaMessage);
    }
}
