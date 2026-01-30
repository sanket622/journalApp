package net.engineeringdigest.journalApp.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.engineeringdigest.journalApp.entity.JournalEntry;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class KafkaProducerService {

    private final KafkaTemplate<String, Object> kafkaTemplate;
    private static final String TOPIC = "journal-events";

    public void publishJournalEvent(String eventType, JournalEntry journalEntry) {
        try {
            JournalEvent event = new JournalEvent(eventType, journalEntry);
            kafkaTemplate.send(TOPIC, event);
            log.info("Published journal event: {} for entry: {}", eventType, journalEntry.getTitle());
        } catch (Exception e) {
            log.error("Failed to publish journal event", e);
        }
    }

    public record JournalEvent(String eventType, JournalEntry journalEntry) {}
}