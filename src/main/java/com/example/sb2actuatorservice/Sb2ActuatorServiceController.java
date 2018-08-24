package com.example.sb2actuatorservice;

import java.util.concurrent.atomic.AtomicLong;

import io.sentry.Sentry;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.example.sb2actuatorservice.Greeting;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Controller
@RequestMapping("/hello-world")
public class Sb2ActuatorServiceController {

    private static final Logger logger = LogManager.getLogger("com.example.sb2actuatorservice.Sb2ActuatorServiceController");

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping(method=RequestMethod.GET)
    public @ResponseBody Greeting sayHello(@RequestParam(value="name", required=false, defaultValue="Stranger") String name) {
        Sentry.init();

        logger.debug("Debug message");
        logger.info("Info message");
        logger.warn("Warn message"); // warning message that will be sent to Sentry

        handledException();

        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }

    private void handledException() {
        try {
            throw new Exception("This is a test exception.");
        } catch (Exception e) {
            // caught exception that will be sent to Sentry
            logger.error("Caught exception!:", e.getCause());
        }
    }
}
