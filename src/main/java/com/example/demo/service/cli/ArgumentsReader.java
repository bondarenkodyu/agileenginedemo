package com.example.demo.service.cli;

import com.example.demo.model.Arguments;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.stereotype.Service;

import static com.example.demo.service.cli.CLIKey.ELEMENT_ID;
import static com.example.demo.service.cli.CLIKey.LINK;

@Service
public class ArgumentsReader {

    private static final Logger logger = LoggerFactory.getLogger(ArgumentsReader.class);


    @Value("${cli.argument.key.value.separator}")
    private String keyValueSeparator;

    @Autowired
    private ApplicationArguments applicationArguments;

    public Arguments getArguments() {
        Arguments arguments = new Arguments();
        for (String arg : applicationArguments.getSourceArgs()) {
            fillArguments(arguments, arg);
        }
        return arguments;
    }


    private String getValue(String arg) {
        return arg.substring(arg.indexOf(keyValueSeparator) + 1);
    }

    private String getName(String arg) {
        return arg.substring(0, arg.indexOf(keyValueSeparator));
    }


    private void fillArguments(Arguments arguments, String arg) {
        String value = getValue(arg);
        switch (getName(arg)) {
            case LINK :
                arguments.setLink(value);
                break;
            case ELEMENT_ID :
                arguments.setElementId(value);
                break;

            default: {
                logger.warn(arg + " was skipped");
            }

        }
    }

}
