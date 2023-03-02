package org.example.system.wiseSaying.controller;

import org.example.Container;
import org.example.Rq;
import org.example.system.wiseSaying.entity.Wise;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileWriter;
import java.io.Reader;
import java.util.ArrayList;


public class wiseSayingController {
    private int idx;
    private ArrayList<Wise> WiseList;

    private Reader reader;
    private FileWriter file;


    public wiseSayingController() {
        idx = 1;
        WiseList = new ArrayList<>();

    }
    private Wise findById(int id) {
        for(Wise wise : WiseList){
            if(wise.getIdx_num() == id){
                return wise;
            }
        }
        //없으면 null 리턴
        return null;
    }

    public void write() {
        Wise add;
        add = new Wise();
        add.setIdx_num(idx);
        System.out.print("명언 : ");
        add.setTalked(Container.getScanner().nextLine());

        System.out.print("작가 : ");
        add.setName(Container.getScanner().nextLine());
        WiseList.add(add);
        System.out.println(idx++ + "번 명언이 등록되었습니다.");
    }

    public void list() {
        System.out.println("번호 / 작가 / 명언");
        System.out.println("----------------------");
        for (int index = WiseList.size() - 1; index >= 0; index--) {
            System.out.println(WiseList.get(index).getIdx_num() + " / " + WiseList.get(index).getName() + " / " + WiseList.get(index).getTalked());
        }
    }

    public void remove(Rq rq) {
        int id = rq.getIntParam("id",-1);
        if(id == -1){
            System.out.println("id(정수)를 입력해주세요");
            return;
        }
        Wise wise = findById(id);
        if(wise == null){
            System.out.println(id + "번 명언은 존재하지 않습니다.");
            return;
        }

        WiseList.remove(wise);
        System.out.println(id + "번 명언이 삭제되었습니다.");
    }
    public void ReWrite(Rq rq) {
        int id = rq.getIntParam("id",-1);
        if(id == -1){
            System.out.println("id를 입력해라.");
            return;
        }
        Wise wise = findById(id);
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

        wise.setName(Name);
        wise.setTalked(talked);
        System.out.println(id + "번 명언이 수정됨.");


    }
}
