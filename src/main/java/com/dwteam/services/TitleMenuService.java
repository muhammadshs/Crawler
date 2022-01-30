package com.dwteam.services;

import com.dwteam.model.NewsTitle;
import org.jsoup.nodes.Document;

import java.util.List;

public class TitleMenuService {

    List<NewsTitle> list;

    public TitleMenuService() throws InterruptedException {
        TitlePicker titlePicker=new TitlePicker("https://tejaratnews.com/category/%d8%a8%d8%a7%d8%b2%d8%a7%d8%b1/%d8%a8%d9%88%d8%b1%d8%b3?all=true");
        TitlePicker titlePicker2=new TitlePicker("https://tejaratnews.com/category/%d8%a8%d8%a7%d8%b2%d8%a7%d8%b1/%d8%b7%d9%84%d8%a7-%d9%88-%d8%a7%d8%b1%d8%b2");
        Thread thread=new Thread(titlePicker,"bours");
        Thread thread1=new Thread(titlePicker2,"arz") ;
        thread.start();;
        thread1.start();


            thread.join();
            thread1.join();

        this.list=titlePicker.getList();
        for (NewsTitle title:titlePicker2.getList() ){
            list.add(title);
        }

    }

    public List<NewsTitle> getList() {
        return list;
    }

    public void setList(List<NewsTitle> list) {
        this.list = list;
    }
}
