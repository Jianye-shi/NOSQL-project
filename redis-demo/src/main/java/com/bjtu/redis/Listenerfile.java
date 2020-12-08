package com.bjtu.redis;

import com.alibaba.fastjson.JSON;
import org.apache.commons.io.monitor.FileAlterationListener;
import org.apache.commons.io.monitor.FileAlterationObserver;
import redis.clients.jedis.Jedis;

import java.io.File;
import java.util.regex.Pattern;

public class Listenerfile implements FileAlterationListener {
    @Override
    public void onStart(FileAlterationObserver fileAlterationObserver) {

    }

    @Override
    public void onDirectoryCreate(File file) {

    }

    @Override
    public void onDirectoryChange(File file) {

    }

    @Override
    public void onDirectoryDelete(File file) {

    }

    @Override
    public void onFileCreate(File file) {

    }

    @Override
    public void onFileChange(File file){
        System.out.println("json文件已重新配置");
        //Main.jsonFileConfig();

    }

    @Override
    public void onFileDelete(File file) {

    }

    @Override
    public void onStop(FileAlterationObserver fileAlterationObserver) {

    }
}
