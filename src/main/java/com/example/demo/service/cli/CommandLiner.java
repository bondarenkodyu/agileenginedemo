package com.example.demo.service.cli;


import com.example.demo.model.Arguments;
import com.example.demo.service.html.ElementLookUpService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class CommandLiner implements CommandLineRunner {

    private static final String SEPARATOR = System.lineSeparator();
    private static final Logger logger = LoggerFactory.getLogger(CommandLiner.class);


    @Autowired
    private Arguments arguments;


    @Autowired
    private ElementLookUpService lookUpService;

    @Override
    public void run(String... args) {
        logger.info(banner());
        printResult();
    }


    private void printResult() {

        StringBuilder result = new StringBuilder();

        result.append(SEPARATOR)
              .append(SEPARATOR)
              .append("**************** Result ********************")
              .append(SEPARATOR);

        lookUpService.lookUpPaths().forEach(path -> result.append(path).append(SEPARATOR));

        result.append("************************************************")
              .append(SEPARATOR);

        logger.info(result.toString());
    }

    private String banner() {
        return String.join(SEPARATOR,
                SEPARATOR,
                "************************************************",
                SEPARATOR,
                arguments.toString(),
                SEPARATOR,
                "************************************************"
        );
    }

}
