package com.bjtu.redis;

import org.apache.commons.io.filefilter.FileFilterUtils;
import org.apache.commons.io.monitor.FileAlterationListener;
import org.apache.commons.io.monitor.FileAlterationMonitor;
import org.apache.commons.io.monitor.FileAlterationObserver;

import java.io.File;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

public class Fileup {
    FileAlterationMonitor monitor=null;
    public  void Fileuptest(){
        long interval= TimeUnit.SECONDS.toMillis(5);
        FileAlterationObserver observer=new FileAlterationObserver("resources");
        observer.addListener(new Listenerfile());
        monitor=new FileAlterationMonitor(interval,observer);
    }
    public void monitor_start() throws Exception{
        monitor.start();
    }
    public void monitor_stop() throws Exception{
        monitor.stop();
    }

}
