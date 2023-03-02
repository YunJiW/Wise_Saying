package org.example;

import java.util.HashMap;
import java.util.Scanner;



public class Main {

    static int idx = 1;
    public static void main(String[] args) {
        System.out.println("== 명언 앱 ==");
        Scanner sc = new Scanner(System.in);
        HashMap<Integer,Wise> map = new HashMap<>();

        while(true){
            System.out.print("명령) ");
            String s = sc.nextLine().trim();
            String command[] = s.split("\\?");

            //등록 입력시 입력받고 등록
            if(command[0].equals("등록")){
                Wise add = new Wise();
                System.out.print("명언 : ");
                s = sc.nextLine();
                add.setTalked(s);

                System.out.print("작가 : ");
                s = sc.nextLine();
                add.setName(s);
                map.put(idx,add);
                System.out.println(idx++ + "번 명언이 등록되었습니다.");
            }
            else if(command[0].equals("목록")){
                System.out.println("번호 / 작가 / 명언");
                System.out.println("----------------------");
                for(int idx_num =idx; idx_num > 0; idx_num--){
                    if(map.containsKey(idx_num)) {
                        System.out.println(idx_num + " / " + map.get(idx_num).getName() + " / " + map.get(idx_num).getTalked());
                    }
                }
            }
            else if(command[0].equals("삭제")){
                String number = command[1].substring(3,command[1].length());
                if(!map.containsKey(Integer.parseInt(number))){
                    System.out.println(number + "번 명언은 존재하지않습니다.");
                    continue;
                }
                map.remove(Integer.parseInt(number));
                System.out.println(number + "번 명언이 삭제되었습니다.");
            }
            else if(command[0].equals("수정")){
                int number = Integer.parseInt(command[1].substring(3,command[1].length()));
                //수정할때 존재하지않을경우
                if(!map.containsKey(number)){
                    System.out.println(number + "번 명언은 존재하지않습니다.");
                    continue;
                }
                Wise change = new Wise();
                System.out.println("명언(기존) : " + map.get(number).getTalked());
                System.out.print("명언 :");
                change.setTalked(sc.nextLine());
                System.out.println("명언(기존) : " + map.get(number).getName());
                System.out.print("작가 :");
                change.setName(sc.nextLine());
                map.put(number,change);
                
            }

            //종료입력시 종료
            else if(s.equals("종료")) {
                break;
            }
        }
    }
}