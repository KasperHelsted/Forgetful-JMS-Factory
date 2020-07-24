package Playground.connection;

import Playground.errorhandler.MQErrorHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.boot.autoconfigure.jms.DefaultJmsListenerContainerFactoryConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;

import javax.jms.ConnectionFactory;

@Configuration
@Slf4j
public class JMSConnection {
    @Bean
    public JmsListenerContainerFactory<?> jmsConnectionFactory(
            ConnectionFactory connectionFactory,
            DefaultJmsListenerContainerFactoryConfigurer configurer,
            MQErrorHandler errorHandler
    ) {
        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
        configurer.configure(factory, connectionFactory);

        factory.setConnectionFactory(connectionFactory);
        factory.setErrorHandler(errorHandler);
        factory.setConcurrency("1-1");

        return factory;
    }

    @Bean
    public ConnectionFactory activeMQFactory() {
        log.info("Connection type is set to ActiveMQ");
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory();

        connectionFactory.setBrokerURL("tcp://localhost:61616");
        connectionFactory.setPassword("admin");
        connectionFactory.setUserName("admin");

        return connectionFactory;
    }
}
