package org.example;

import java.util.HashMap;
import java.util.Map;

public class Rq {
    private String actionCode;

    private Map<String,String> map;

    public Rq(String s) {
        String[] commands = s.split("\\?",2);
        map = new HashMap<>();

        if(commands.length ==1 ) return;
        //&기준으로 나누기
        String[] paramsBits = commands[1].split("&");
        for(String paramStr : paramsBits){
            String[] paramStrBits = paramStr.split("=",2);

            if(paramStrBits.length == 1) continue;

            String Key = paramStrBits[0];
            String value = paramStrBits[1];

            map.put(Key,value);
        }
    }

    public String getActionCode() {
        return actionCode;
    }

    public String getParam(String name){
        return map.get(name);
    }

    //현재 원하는 값이 존재하는지 체크
    //없을경우 default값을 리턴한다.
    public Long getLongParam(String name, long defaultValue){
        try{
            return Long.parseLong(getParam(name));

        }catch (NumberFormatException e){

        }

        return defaultValue;
    }
}
