package org.example.system.wiseSaying.entity;

public class Wise {
    private int idx_num;
    private String name;
    private String talked;

    public String getName() {
        return name;
    }

    public String getTalked() {
        return talked;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTalked(String talked) {
        this.talked = talked;
    }

    public int getIdx_num() {
        return idx_num;
    }

    public void setIdx_num(int idx_num) {
        this.idx_num = idx_num;
    }
}
