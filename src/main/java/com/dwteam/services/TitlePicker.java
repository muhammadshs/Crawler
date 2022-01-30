package com.dwteam.services;

import com.dwteam.model.NewsTitle;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TitlePicker implements Runnable{
    List<NewsTitle> list;
    String url;
    int i;
    public TitlePicker(String url) {
        list=new ArrayList<>();
        this.url=url;
    }

    @Override
    public void run() {
        Document document=null;
        try {
            document=  Jsoup.connect(url).get();
        } catch (IOException e) {
            e.printStackTrace();
        }


        Element element=document.getElementsByClass("category-list-right").get(0);
        Elements elements=element.getElementsByTag("h2");

        elements.forEach(element2 -> {
            NewsTitle newsTitle=new NewsTitle();;
            newsTitle.setId(i);
            newsTitle.setTitle(element2.text());
            Element el=element2.getElementsByTag("a").get(0);
            newsTitle.setLink(el.attr("href"));
            list.add(newsTitle);
            i++;
        });
    }

    public List<NewsTitle> getList() {
        return list;
    }

    public void setList(List<NewsTitle> list) {
        this.list = list;
    }
}
