package org.example;

import org.example.system.wiseSaying.entity.Wise;

import java.util.ArrayList;
import java.util.Scanner;

public class App {
    private final Scanner sc;
    static int idx =1;

    App(Scanner sc){
        this.sc = sc;
    }

    void Run(){
        System.out.println("== 명언 앱 ==");
        ArrayList<Wise> WiseList = new ArrayList<>();

        while(true){

            System.out.print("명령) ");
            String s = sc.nextLine().trim();
            String command[] = s.split("\\?");

            //등록 입력시 입력받고 등록
            if(command[0].equals("등록")){
                Wise add = new Wise();
                add.setIdx_num(idx);
                System.out.print("명언 : ");
                s = sc.nextLine();
                add.setTalked(s);

                System.out.print("작가 : ");
                s = sc.nextLine();
                add.setName(s);
                WiseList.add(add);
                System.out.println(idx++ + "번 명언이 등록되었습니다.");
            }
            else if(command[0].equals("목록")){
                System.out.println("번호 / 작가 / 명언");
                System.out.println("----------------------");
                for(int index= WiseList.size()-1;index >=0;index--){
                    System.out.println(WiseList.get(index).getIdx_num() + " / " + WiseList.get(index).getName() + " / " +WiseList.get(index).getTalked());
                }
            }
            else if(command[0].equals("삭제")){
                int number = Integer.parseInt(command[1].substring(3,command[1].length()));
                boolean check = false;
                for(int index = 0; index <WiseList.size();index++)
                {
                    if(WiseList.get(index).getIdx_num() == number)
                    {
                        System.out.println(number + "번 명언이 삭제되었습니다.");
                        WiseList.remove(index);
                        check = true;
                        break;
                    }
                }
                if(!check){
                    System.out.println(number + "번 명언은 존재하지 않습니다.");
                }
            }
            else if(command[0].equals("수정")){
                int number = Integer.parseInt(command[1].substring(3,command[1].length()));
                boolean check = false;
                for(int index = 0; index <WiseList.size();index++)
                {
                    if(WiseList.get(index).getIdx_num() == number)
                    {
                        System.out.println("명언(기존) : " + WiseList.get(index).getTalked());
                        System.out.print("명언 :");
                        WiseList.get(index).setTalked(sc.nextLine());
                        System.out.println("작가(기존) : " + WiseList.get(index).getName());
                        System.out.print("작가 : ");
                        WiseList.get(index).setName(sc.nextLine());
                        check = true;
                        break;
                    }
                }
                if(!check){
                    System.out.println(number + "번 명언은 존재하지 않습니다.");
                }
            }

            //종료입력시 종료
            else if(s.equals("종료")) {
                break;
            }
        }

    }
}
