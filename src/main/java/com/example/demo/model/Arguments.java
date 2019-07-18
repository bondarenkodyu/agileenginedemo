package com.example.demo.model;


public class Arguments {

    private String link;
    private String elementId;

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getElementId() {
        return elementId;
    }

    public void setElementId(String elementId) {
        this.elementId = elementId;
    }

    @Override
    public String toString() {
        return "Arguments{" +
                "link='" + link + '\'' +
                ", elementId='" + elementId + '\'' +
                '}';
    }
}
