package org.example.system.wiseSaying.service;

import org.example.Container;
import org.example.Rq;
import org.example.system.wiseSaying.entity.Wise;
import org.example.system.wiseSaying.repositoy.WiseSayingRepository;

import java.util.ArrayList;
import java.util.List;

public class WiseSayingService {

    private WiseSayingRepository wiseSayingRepository;

    public WiseSayingService() {

        wiseSayingRepository = new WiseSayingRepository();
    }



    public long write(String talked, String name) {
        return wiseSayingRepository.write(talked,name);

    }
    public void remove(Wise wise) {
        wiseSayingRepository.remove(wise);

    }

    public void ReWrite(Wise wise,String name,String talked) {
        wiseSayingRepository.modify(wise,name,talked);

    }


    public Wise findById(long id) {
        return wiseSayingRepository.findById(id);
    }

    public List<Wise> findAll(){
        return wiseSayingRepository.findAll();
    }
}
