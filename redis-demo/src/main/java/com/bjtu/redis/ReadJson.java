package com.bjtu.redis;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;
import com.alibaba.fastjson.JSON;
import redis.clients.jedis.Jedis;
public class ReadJson {
    public static String read(String Filename){
        String JString;
        try{
            Reader reader=new InputStreamReader(new FileInputStream(new File(Filename)));
            int i=0;
            StringBuffer stringBuffer=new StringBuffer();
            while((i=reader.read())!=-1){
                stringBuffer.append(i);
            }
            reader.close();
            JString=stringBuffer.toString();
            return JString;
        }catch (IOException e){
            e.printStackTrace();
            System.out.println("error in reading file!");
            return null;
        }
    }
    public boolean write(String filepath,String string){
        try{
            FileWriter fileWriter=new FileWriter(filepath);
            PrintWriter printWriter=new PrintWriter(fileWriter);
            printWriter.write(string);
            printWriter.println();
            printWriter.close();
            fileWriter.close();
            return true;
        }catch (IOException e){
            e.printStackTrace();
            return false;
        }
    }

}
