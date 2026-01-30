package net.engineeringdigest.journalApp.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaConsumerService {

    @KafkaListener(topics = "journal-events", groupId = "journal-group")
    public void handleJournalEvent(KafkaProducerService.JournalEvent event) {
        log.info("Received journal event: {} for entry: {}", 
                event.eventType(), event.journalEntry().getTitle());
        
        // Add your event processing logic here
        switch (event.eventType()) {
            case "CREATED" -> log.info("Processing journal creation event");
            case "UPDATED" -> log.info("Processing journal update event");
            case "DELETED" -> log.info("Processing journal deletion event");
            default -> log.warn("Unknown event type: {}", event.eventType());
        }
    }
}