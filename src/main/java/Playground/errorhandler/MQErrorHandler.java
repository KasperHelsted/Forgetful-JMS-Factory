package Playground.errorhandler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.ErrorHandler;

@Slf4j
@Component
public class MQErrorHandler implements ErrorHandler {
    @Override
    public void handleError(Throwable ex) {
        System.out.println("This is the errorhandler");
    }
}
