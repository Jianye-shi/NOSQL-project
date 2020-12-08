package com.bjtu.redis;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;

public class ReadCounter {
    private String counterName;
    private String counterIndex;
    private String type;
    private String keyFields;
    private String fields;
    private String valueFields;
    ReadJson readJson;
    public ReadCounter(String counterName,String counterIndex,String type,String keyFields,String fields,String valueFields){
        this.counterName = counterName;
        this.counterIndex = counterIndex;
        this.type = type;
        this.keyFields = keyFields;
        this.fields = fields;
        this.valueFields = valueFields;
    }
    public void ReadCounter(){
        ArrayList<ReadCounter> counterList;
        counterList=new ArrayList<ReadCounter>();
        counterList.clear();
        String path="counter.json";

        String s=readJson.read(path);
        JSONObject jobj= JSON.parseObject(s);
        JSONArray counters=jobj.getJSONArray("counter");
        for(int i=0;i<counters.size();i++){
            JSONObject key=(JSONObject)counters.get(i);
            String counterName=(String)key.get("counterName");
            String counterIndex=(String) key.get("counterIndex");
            String type=(String)key.get("type");
            String keyFields=(String)key.get("keyFields");
            String fields=(String)key.get("fields");
            String valueFields=(String)key.get("valueFields");
            ReadCounter c=new ReadCounter(counterName,counterIndex,type,keyFields,fields,valueFields);
            counterList.add(c);
        }
    }
    public static ArrayList<ReadCounter> readCounter_2(){
        ArrayList<ReadCounter> counterList_2=new ArrayList<ReadCounter>();
        counterList_2.clear();
        String path="counter.json";
        String s=ReadJson.read(path);
        JSONObject jobj= JSON.parseObject(s);
        JSONArray counters=jobj.getJSONArray("counter");
        for(int i=0;i<counters.size();i++){
            JSONObject key=(JSONObject)counters.get(i);
            String counterName=(String)key.get("counterName");
            String counterIndex=(String) key.get("counterIndex");
            String type=(String)key.get("type");
            String keyFields=(String)key.get("keyFields");
            String fields=(String)key.get("fields");
            String valueFields=(String)key.get("valueFields");
            ReadCounter c=new ReadCounter(counterName,counterIndex,type,keyFields,fields,valueFields);
            counterList_2.add(c);
        }
        return counterList_2;
    }

    public void setCounterName(String counterName) {
        this.counterName = counterName;
    }

    public void setCounterIndex(String counterIndex) {
        this.counterIndex = counterIndex;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setKeyFields(String keyFields) {
        this.keyFields = keyFields;
    }

    public void setFields(String fields) {
        this.fields = fields;
    }

    public void setValueFields(String valueFields) {
        this.valueFields = valueFields;
    }

    public String getCounterIndex() {
        return counterIndex;
    }

    public String getCounterName() {
        return counterName;
    }

    public String getType() {
        return type;
    }

    public String getKeyFields() {
        return keyFields;
    }

    public String getFields() {
        return fields;
    }

    public String getValueFields() {
        return valueFields;
    }
}
