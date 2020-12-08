package com.bjtu.redis;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    Fileup fileup;
    ReadCounter readCounter;
    ReadAction readAction;
    public  void main(String[] args)throws Exception{

        fileup.Fileuptest();
        fileup.monitor_start();
        readCounter.ReadCounter();
        readAction.ReadAction();
        Scanner scanner=new Scanner(System.in);
        String string=null;
        do{
            System.out.println("ActionList: ");
            for (int i=0;i<readAction.actionList.size();i++){
                System.out.println("Print the number you want to act");
                string=scanner.nextLine();
                if(Integer.parseInt(string)>=1||Integer.parseInt(string)<=4){
                    Runnable runnable=new Runnable();
                    runnable.doAction(readAction.actionList.get(Integer.parseInt(string)-1));
                }
                else if(Integer.parseInt(string)==0){
                    fileup.monitor_stop();
                }
                else {
                    System.out.println("error!");
                }
            }
        }while (!string.equals("0"));

    }

}
