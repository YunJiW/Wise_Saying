package org.example.system.wiseSaying.entity;

public class Wise {
    private Long idx_num;
    private String name;
    private String talked;

    public Wise(){

    }
    public Wise(Long idx_num,String name,String talked){
        this.idx_num = idx_num;
        this.name = name;
        this.talked = talked;
    }

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

    public Long getIdx_num() {
        return idx_num;
    }

    public void setIdx_num(Long idx_num) {
        this.idx_num = idx_num;
    }
}
