package org.example.system.wiseSaying.table;

import org.example.Util;
import org.example.system.wiseSaying.entity.Wise;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

//여기가 저장관리하는것
public class WiseSayingTable {
    public WiseSayingTable() {
    }
    //테이블의 데이터가 저장될 폴더 경로
    private static String getTableDirPath() {
        return "proddata/wisesaying";
    }

    //특정 데이터의 파일 경로를 반환
    public static String getTableDataFilePath(long id){
        return getTableDirPath() + "/" + id + ".json";
    }

    public List<Wise> findAll() {
        List<Long> fileIds = getfileIds();

        return fileIds
                .stream()
                .map(id -> findById(id))
                .collect(Collectors.toList());
    }

    private List<Long> getfileIds() {
        String path =getTableDirPath();
        List<String> fileNames = Util.file.getFileNamesFromDir(path);

        return fileNames
                .stream()
                .filter(fileName -> !fileName.equals("last_id.txt"))
                .filter(fileName -> !fileName.equals("data.json"))
                .filter(fileName -> fileName.endsWith(".json"))
                .map(fileName -> fileName.replace(".json",""))
                .mapToLong(Long::parseLong)
                .boxed()
                .collect(Collectors.toList());
    }

    public Wise findById(long id) {
        String path = getTableDataFilePath(id);

        //파일이없을경우 null반환
        if(new File(path).exists() == false){
            return null;
        }

        Map<String, Object> map = Util.json.jsonToMapFromFile(path);
        //map이 null일경우 null 반환
        if(map == null)
            return null;
        return new Wise((Long)map.get("id"),(String)map.get("name"),(String)map.get("talked"));
    }
    //테이블에서 가장 마지막에 생성된 데이터 id를  저장한 파일의 경로
    private String getTableLastIdFilePath() {
        return getTableDirPath() + "/last_id.txt";
    }

    public long getLastidx() {
        return Util.file.readNoFromFile(getTableLastIdFilePath(),0);
    }

    public long save(Wise wise) {
        Util.file.mkdir(getTableDirPath()); // 폴더 생성
        //내용을 json 형식으로 변환하기
        String body = wise.toJson();
        //파일경로 생성
        String filePath = getTableDataFilePath(wise.getIdx_num());
        //파일 생성 or 갱신
        Util.file.saveToFile(filePath,body);

        saveLastId(wise.getIdx_num());

        return wise.getIdx_num();
    }
    private void saveLastId(long idxNum) {
        Util.file.saveNoToFile(getTableLastIdFilePath(),idxNum);
    }

    public void remove(Wise wise) {
        String path = getTableDataFilePath(wise.getIdx_num());
        Util.file.deleteFile(path);
    }

    public void modify(Wise wise, String name, String talked) {
        wise.setName(name);
        wise.setTalked(talked);
        String body = wise.toJson();

        String filepath = getTableDataFilePath(wise.getIdx_num());
        Util.file.saveToFile(filepath,body);
    }


}
