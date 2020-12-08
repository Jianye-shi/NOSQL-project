package com.bjtu.redis;

import java.text.ParseException;
import java.util.ArrayList;

public class Runnable {
    ArrayList<ReadCounter> counterList ;
    ReadCounter counter ;
    public void doAction(ReadAction action)throws ParseException{
        ArrayList<String> retrieveCouternameList=action.getRetrieveCountername();
        String retrieveCountername=null;
        for (int i=0;i<retrieveCouternameList.size();i++){
            retrieveCountername=retrieveCouternameList.get(i);

        }
        ArrayList<String> saveCounternameList=action.getSaveCountername();
        String saveCountername=null;
        for(int i=0;i<saveCounternameList.size();i++){
            saveCountername=saveCounternameList.get(i);
        }
        counterList=null;
        counterList=ReadCounter.readCounter_2();

        doCounter(saveCountername);
        doCounter(retrieveCountername);
        System.out.println();

    }
    public void doCounter(String countername)throws ParseException{

        for(int i=0;i<counterList.size();i++){
            if(counterList.get(i).getCounterName().equals(countername)){
                counter=counterList.get(i);
            }
        }
        System.out.println("counter: "+counter.getCounterName());
        int number=0;
        String string1,string2;
        MyRedis jedis=new MyRedis();
        switch (counter.getCounterIndex()){
            case "1":
                System.out.println("keyFields = "+counter.getKeyFields());
                System.out.println("valueFields = "+counter.getValueFields());
                if(jedis.get(counter.getKeyFields())!=null){
                    number=Integer.parseInt(jedis.get(counter.getKeyFields()));
                }
                number=number+Integer.parseInt(jedis.get(counter.getKeyFields()));
                jedis.set(counter.getKeyFields(),String.valueOf(number));
                break;
            case "2":
                System.out.println("keyFields = "+counter.getKeyFields());
                System.out.println("valueFields = "+counter.getValueFields());
                if(jedis.get(counter.getKeyFields())!=null){
                    number=Integer.parseInt(jedis.get(counter.getKeyFields()));
                }
                number=number-Integer.parseInt(jedis.get(counter.getKeyFields()));
                jedis.set(counter.getKeyFields(),String.valueOf(number));
                break;
            case"3":
                System.out.println("keyFields = "+counter.getKeyFields());
                if(jedis.get(counter.getKeyFields())!=null){
                    number=Integer.parseInt(jedis.get(counter.getKeyFields()));
                    System.out.println("number = "+number);

                }
                else {
                    System.out.println("number = null");
                }
                break;
            case "4":
                System.out.println("keyFields = "+counter.getKeyFields());
                System.out.println("valueFields = "+counter.getValueFields());
                System.out.println("Field = "+counter.getFields());
                string1=counter.getFields();
                string2=string1.substring(0,14)+"00:00";
                number=0;
                if(jedis.hget(counter.getKeyFields(),string1)!=null){
                    number=Integer.parseInt(jedis.hget(counter.getKeyFields(),string2));

                }
                number=number+Integer.parseInt(counter.getValueFields());
                jedis.hset(counter.getKeyFields(),string2,String.valueOf(number));
                break;
            case "5":
                System.out.println("keyFields = "+counter.getKeyFields());
                System.out.println("valueFields = "+counter.getValueFields());
                System.out.println("Field = "+counter.getFields());
                string1=counter.getFields();
                string2=string1.substring(0,14)+"00:00";
                number=0;
                if(jedis.hget(counter.getKeyFields(),string1)!=null){
                    number=Integer.parseInt(jedis.hget(counter.getKeyFields(),string2));

                }
                number=number-Integer.parseInt(counter.getValueFields());
                jedis.hset(counter.getKeyFields(),string2,String.valueOf(number));
                break;
            case "6":
                System.out.println("keyFields = "+counter.getKeyFields());
                System.out.println("Field = "+counter.getFields());
                string1=counter.getFields();
                string2=string1.substring(0,14)+"00:00";
                number=0;
                if(jedis.hget(counter.getKeyFields(),string2)!=null){
                    number=Integer.parseInt(jedis.hget(counter.getKeyFields(),string2));
                    System.out.println("number : null");
                }
                else {
                    System.out.println("number : null");

                }
                break;

        }
    }
}
