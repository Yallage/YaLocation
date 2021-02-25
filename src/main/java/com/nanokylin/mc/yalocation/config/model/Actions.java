package com.nanokylin.mc.yalocation.config.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 容器 用于装载指令或内置操作
 */
public class Actions {
    private List<String> commands = new ArrayList<>();
    private String title = "";
    private String subtitle = "";
    private boolean seeTitle = false;
    private boolean seeSubtitle = false;

    public List<String> getCommands() {
        return commands;
    }

    public void setCommands(List<String> commands) {
        this.commands = commands;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public boolean isSeeTitle() {
        return seeTitle;
    }

    public void setSeeTitle(boolean seeTitle) {
        this.seeTitle = seeTitle;
    }

    public boolean isSeeSubtitle() {
        return seeSubtitle;
    }

    public void setSeeSubtitle(boolean seeSubtitle) {
        this.seeSubtitle = seeSubtitle;
    }
}
