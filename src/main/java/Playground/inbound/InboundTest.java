package Playground.inbound;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.Message;

@Component
public class InboundTest {
    @JmsListener(destination = "TEST_QUEUE")
    protected void onNewMessage(Message message) {
        throw new RuntimeException("TEST");
    }
}
