package io.pragra.framework.util;

import io.pragra.framework.conf.Config;

import javax.imageio.IIOException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils {

    public static void createDirectories(Path path) {
        try {
            if (!Files.exists(path)) {
                Files.createDirectories(path);
            }
        }catch (IOException exception) {
            System.out.println("Couldn't create dir");
        }
    }

    public static String getTimeStamp() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("MMddYYYYHHmmSS");
        return dateFormat.format(new Date());
    }

    public static String getReportFile(){
        String fileName = null;
        try {
            createDirectories(Paths.get(Config.getProperty("report.dir")));

            fileName = Config.getProperty("report.dir")+"/"+Config.getProperty("report.filename")+"_"+getTimeStamp()+".html";
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fileName;
    }
}
