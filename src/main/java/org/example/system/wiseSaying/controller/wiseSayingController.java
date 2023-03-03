package org.example.system.wiseSaying.controller;

import org.example.Container;
import org.example.Rq;
import org.example.system.wiseSaying.entity.Wise;
import org.example.system.wiseSaying.service.WiseSayingService;


import java.util.List;


public class wiseSayingController {

    private final WiseSayingService wiseSayingService;
    public wiseSayingController() {
        wiseSayingService = new WiseSayingService();
    }
    public void write() {

        System.out.print("명언 : ");
        String talked = Container.getScanner().nextLine().trim();

        System.out.print("작가 : ");
        String name = Container.getScanner().nextLine().trim();

        long id = wiseSayingService.write(name,talked);

        System.out.println(id + "번 명언이 등록되었습니다.");
    }

    public void list() {
        List<Wise> WiseList = wiseSayingService.findAll();
        System.out.println("번호 / 작가 / 명언");
        System.out.println("----------------------");
        for (int index = WiseList.size() - 1; index >= 0; index--) {
            System.out.println(WiseList.get(index).getIdx_num() + " / " + WiseList.get(index).getName() + " / " + WiseList.get(index).getTalked());
        }

    }
    public void remove(Rq rq) {
        long id = rq.getLongParam("id",-1);
        if(id == -1){
            System.out.println("id(정수)를 입력해주세요");
            return;
        }
        Wise wise = wiseSayingService.findById(id);
        if(wise == null){
            System.out.println(id + "번 명언은 존재하지 않습니다.");
            return;
        }
        wiseSayingService.remove(wise);
        System.out.println(id + "번 명언이 삭제되었습니다.");
    }
    public void ReWrite(Rq rq) {
        long id = rq.getLongParam("id",-1);
        if(id == -1){
            System.out.println("id를 입력해라.");
            return;
        }
        Wise wise = wiseSayingService.findById(id);
        if(wise == null){
            System.out.println(id + "번 명언은 존재하지 않습니다.");
            return;
        }
        System.out.printf("명언(기존) : %s \n",wise.getTalked());
        System.out.print("명언 : ");
        String talked = Container.getScanner().nextLine();
        System.out.printf("작가(기존) : %s \n",wise.getName());
        System.out.print("작가 : ");
        String Name = Container.getScanner().nextLine();

        wiseSayingService.ReWrite(wise,Name,talked);
        System.out.println(id + "번 명언이 수정됨.");
    }
}
