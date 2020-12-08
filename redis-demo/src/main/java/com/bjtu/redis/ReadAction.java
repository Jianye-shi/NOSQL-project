package com.bjtu.redis;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;

public class ReadAction {
    private String name;
    private ArrayList<String> retrieveCountername;
    private ArrayList<String> saveCountername;
    ArrayList<ReadAction> actionList;
    ReadJson readJson;
    public ReadAction(String name,ArrayList<String>retrieveCountername,ArrayList<String>saveCountername){
        this.name=name;
        this.retrieveCountername=retrieveCountername;
        this.saveCountername=saveCountername;
    }
    public void ReadAction(){
        actionList=new ArrayList<ReadAction>();
        actionList.clear();
        String path="action.json";
        String s=readJson.read(path);
        JSONObject jobj= JSON.parseObject(s);
        JSONArray actions=jobj.getJSONArray("action");
        for(int i=0;i<actions.size();i++){
            ArrayList<String> retrieveCounterName=new ArrayList<String>();
            ArrayList<String> saveCounterName=new ArrayList<String>();

            JSONObject key=(JSONObject)actions.get(i);

            String actionName=(String)key.get("actionName");

            JSONArray retrieve=(JSONArray)key.get("retrieve");

            for(int j=0;j<retrieve.size();j++){
                JSONObject key2 = (JSONObject) retrieve.get(j);
                retrieveCounterName.add((String)key2.get("counterName"));
            }

            JSONArray save=(JSONArray)key.get("save");
            for(int j=0;j<save.size();j++) {
                JSONObject key2 = (JSONObject) save.get(j);
                saveCounterName.add((String) key2.get("counterName"));
            }

            ReadAction a=new ReadAction(actionName,retrieveCounterName,saveCounterName);
            actionList.add(a);
        }
    }
    public void setName(String name){
        this.name=name;
    }
    public void setRetrieveCountername(ArrayList<String> retrieveCountername){
        this.retrieveCountername=retrieveCountername;
    }
    public void setSaveCountername(ArrayList<String> saveCountername){
        this.saveCountername=saveCountername;
    }
    public String getName(){
        return name;
    }
    public ArrayList<String> getRetrieveCountername(){
        return retrieveCountername;
    }
    public ArrayList<String> getSaveCountername(){
        return saveCountername;
    }
}
