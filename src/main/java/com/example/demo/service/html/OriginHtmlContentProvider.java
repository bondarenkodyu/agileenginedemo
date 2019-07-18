package com.example.demo.service.html;

import com.example.demo.model.Arguments;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class OriginHtmlContentProvider implements ContentProvider {

    private static final Logger logger = LoggerFactory.getLogger(OriginHtmlContentProvider.class);

    @Autowired
    private Arguments arguments;


    @Override
    public Document collectContent() {
        try {
            return Jsoup.connect(arguments.getLink()).get();
        } catch (Exception e) {
            logger.error("Unable to collect html content", e);
            return null;
        }
    }



}
