package com.computech.pojo;

import java.util.List;

public class Menu {

    private String id;
    private String icon;
    private String title;
    private String index;

    public Menu(String id, String icon, String title, String index, List<Menu> subs) {
        this.id = id;
        this.icon = icon;
        this.title = title;
        this.index = index;
        this.subs = subs;
    }

    public List<Menu> getSubs() {
        return subs;
    }

    public void setSubs(List<Menu> subs) {
        this.subs = subs;
    }

    private List<Menu> subs;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }



    public Menu() {
        super();
    }
}
