package org.example;

import org.example.system.wiseSaying.controller.SystemController;
import org.example.system.wiseSaying.controller.wiseSayingController;
import org.example.system.wiseSaying.entity.Wise;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class App {
    void Run() throws IOException, ParseException {
        System.out.println("== 명언 앱 ==");
        //등록할거를 받아서 넣어주기위한 add 객체

        SystemController systemController = new SystemController();
        //파일을 읽어서 값을 넣어준다.

        wiseSayingController wiseSayingController = new wiseSayingController();

        while(true){
            System.out.print("명령) ");
            String s = Container.getScanner().nextLine().trim();
            Rq rq= new Rq(s);
            //종료입력시 종료
            if(s.equals("종료")) {
                systemController.exit();
                break;
            }
            //등록 입력시 입력받고 등록
            if(s.startsWith("등록")){
                wiseSayingController.write();
            }
            else if(s.startsWith("목록")){
                wiseSayingController.list();
            }
            else if(s.startsWith("삭제")){
                
                //재사용 가능
                wiseSayingController.remove(rq);
            }
            else if(s.startsWith("수정")){

                wiseSayingController.ReWrite(rq);
            }


        }

    }
}
