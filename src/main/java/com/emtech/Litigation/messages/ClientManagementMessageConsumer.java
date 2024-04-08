package com.emtech.Litigation.messages;
import com.emtech.Litigation.services.LitigationCaseInitiator;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class ClientManagementMessageConsumer {
    private final LitigationCaseInitiator litigationCaseInitiator;

    public ClientManagementMessageConsumer(LitigationCaseInitiator litigationCaseInitiator) {
        this.litigationCaseInitiator = litigationCaseInitiator;
    }

    @RabbitListener(queues = "newCaseQueue")
    public void consumeMessage(ClientManagementDTO clientManagementDTO) {
        litigationCaseInitiator.processClientData(clientManagementDTO);
    }
}
