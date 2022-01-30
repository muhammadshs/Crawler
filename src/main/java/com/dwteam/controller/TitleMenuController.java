package com.dwteam.controller;

import com.dwteam.model.NewsTitle;
import com.dwteam.services.TitleMenuService;
import com.dwteam.ui.TitleMenuUI;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class TitleMenuController implements  ListSelectionListener {
    JTable jTable;
    TitleMenuUI titleMenuUI;
    DefaultTableModel defaultTableModel;
    List<NewsTitle> list;
    public TitleMenuController(TitleMenuUI titleMenuUI) {

        this.titleMenuUI=titleMenuUI;
        defaultTableModel=new DefaultTableModel();
        defaultTableModel.addColumn("Id");
        defaultTableModel.addColumn("Title");
        
        try {
            TitleMenuService titleMenuService=new TitleMenuService();
            list=titleMenuService.getList();
            Object[] o=new Object[2];
            for (NewsTitle newt:list) {
                o[0]=newt.getId();
                o[1]=newt.getTitle();
                defaultTableModel.addRow(o);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }



    @Override
    public void valueChanged(ListSelectionEvent e) {
        if(jTable.getSelectedRow()>-1){
            int id= (int) jTable.getValueAt(jTable.getSelectedRow(),0);

        }
    }

    public DefaultTableModel getDefaultTableModel() {
        return defaultTableModel;
    }

    public JTable getjTable() {
        return jTable;
    }

    public void setjTable(JTable jTable) {
        this.jTable = jTable;
    }
}
