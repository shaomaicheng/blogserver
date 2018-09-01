package shaomai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import shaomai.Log;

@RestController
public class MainController {

    private long count = 0;

    @Autowired
    private Log logger;

    @RequestMapping("/")
    public String home() {
        logger.info("MainController count: " + ++count);
        return "hello,webblog";
    }
}
