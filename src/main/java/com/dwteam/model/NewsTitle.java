package com.dwteam.model;

public class NewsTitle {
    private int id;
    private String title;
    private String link;

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = "<html><h2>"+title+"</h2></html>";
    }


    public void setId() {
        this.id = id++;
    }

}
