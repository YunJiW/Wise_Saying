package org.example.system.wiseSaying.entity;

public class Wise {
    private long idx_num;
    private String name;
    private String talked;

    public Wise(){

    }
    public Wise(long idx_num,String name,String talked){
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


    public String toJson() {
        return """
                {
                    "id": %d,
                    "talked": "%s",
                    "name" : "%s"
                }
                """
                .stripIndent()
                .formatted(idx_num,talked,name)
                .trim();
    }
}
