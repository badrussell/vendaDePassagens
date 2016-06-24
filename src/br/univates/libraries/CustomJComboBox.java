/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.univates.libraries;

import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.*;

public class CustomJComboBox extends JComboBox {

    private static final long serialVersionUID = 1L;
    private ArrayList<String> arrList;
    private SearchBoxModel sbm;

    public CustomJComboBox(ArrayList<String> arrList) {
        super();
        if (arrList != null) {
            this.arrList = arrList;
        } else {
            this.arrList = initializeList();
        }
        sbm = new SearchBoxModel(this, this.arrList);
        setModel(sbm);
        addItemListener(sbm);
        setSelectedItem("");
    }

    public ArrayList<String> initializeList() {
        ArrayList<String> arr = new ArrayList<String>();
        arr.add("romania");
        arr.add("czech");
        arr.add("luxemberg");
        arr.add("brazil");
        arr.add("canada");
        arr.add("miami");
        arr.add("los angeles");
        arr.add("melbourne");
        arr.add("london");
        return arr;
    }
    
    public void refreshList(ArrayList<String> arr)
    {
        sbm.setDb(arr);
    }
    
    public String getSelectedItem()
    {
        return (String) sbm.getSelectedItem();
    }
    
}