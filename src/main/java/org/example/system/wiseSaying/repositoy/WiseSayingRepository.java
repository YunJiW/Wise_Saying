package org.example.system.wiseSaying.repositoy;

import org.example.system.wiseSaying.entity.Wise;
import org.example.system.wiseSaying.table.WiseSayingTable;

import java.util.ArrayList;
import java.util.List;

//얘는 저장된 곳에서 필요한 것을 가져오는 거
public class WiseSayingRepository {

    private WiseSayingTable wiseSayingTable;
    public WiseSayingRepository() {

        wiseSayingTable = new WiseSayingTable();
    }

    public Wise findById(Long id) {
        return wiseSayingTable.findById(id);
        //없으면 null 리턴
    }

    public List<Wise> findAll() {
        return wiseSayingTable.findAll();
    }

    public Long write(String talked, String name) {
        long id = wiseSayingTable.getLastidx() +1;
        Wise wise = new Wise(id,talked,name);
        return wiseSayingTable.save(wise);
    }

    public void remove(Wise wise) {
        wiseSayingTable.remove(wise);
    }

    public void modify(Wise wise, String name, String talked) {
        wiseSayingTable.modify(wise,name,talked);

    }
}
