package com.example.demo.service.html;

import com.example.demo.model.Arguments;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ElementLookUpService {

    private static final String SELECTOR_ID = "#";
    private static final String PATH_SEPARATOR = " > ";


    @Autowired
    private ContentProvider contentProvider;

    @Autowired
    private Arguments arguments;


    public List<String> lookUpPaths() {
        Document content = contentProvider.collectContent();

        if (content == null)
            throw new RuntimeException("Empty content");

        List<String> paths = new ArrayList<>();

        Elements elements = content.select(SELECTOR_ID + arguments.getElementId());
        for (Element element : elements)
            paths.add(collectPath(element));

        return paths;
    }



    private String collectPath(Element element) {

        List<String> chunks = new ArrayList<>();
        StringBuilder path = new StringBuilder();

        Element parent = element;

        while (parent != null) {

            chunks.add(0,  parent.tag().toString());

            parent =  parent.parent();
        }

        for (int i = 0; i < chunks.size(); i++) {

            path.append(chunks.get(i));

            if (i != chunks.size() - 1) {
                path.append(PATH_SEPARATOR);
            }
        }

        return path.toString();
    }





}
