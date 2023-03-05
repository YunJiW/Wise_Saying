package org.example.system.wiseSaying.repositoy;

import org.example.system.wiseSaying.entity.Wise;

import java.util.ArrayList;
import java.util.List;

public class WiseSayingRepository {
    private Long idx;
    private List<Wise> WiseList;

    public WiseSayingRepository() {
        idx = 0L;
        WiseList = new ArrayList<>();
    }

    public Wise findById(Long id) {
        for(Wise wise : WiseList){
            if(wise.getIdx_num() == id){
                return wise;
            }
        }
        //없으면 null 리턴
        return null;
    }

    public List<Wise> findAll() {
        return WiseList;
    }

    public Long write(String talked, String name) {
        long id = idx+1;
        Wise wise = new Wise(id,talked,name);
        WiseList.add(wise);
        idx = id;
        return id;
    }

    public void remove(Wise wise) {
        WiseList.remove(wise);
    }

    public void modify(Wise wise, String name, String talked) {
        wise.setName(name);
        wise.setTalked(talked);
    }
}
