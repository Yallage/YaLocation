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
    private boolean haveCommands = false;
    private boolean canSeeTitle = false;
    private boolean canSeeSubtitle = false;

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

    public boolean isHaveCommands() {
        return haveCommands;
    }

    public void setHaveCommands(boolean haveCommands) {
        this.haveCommands = haveCommands;
    }

    public boolean isCanSeeTitle() {
        return canSeeTitle;
    }

    public void setCanSeeTitle(boolean canSeeTitle) {
        this.canSeeTitle = canSeeTitle;
    }

    public boolean isCanSeeSubtitle() {
        return canSeeSubtitle;
    }

    public void setCanSeeSubtitle(boolean canSeeSubtitle) {
        this.canSeeSubtitle = canSeeSubtitle;
    }
}
