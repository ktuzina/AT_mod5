package com.training.task.module5.utils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.io.FileUtils;

public class FilesHandler {

    private List<String> filesList;
    private String fileExtention;

    public FilesHandler(String fileExtention) {
        this.fileExtention = fileExtention;
        this.filesList = new ArrayList<String>();
    }

    public boolean isFileNotEmpty() {
        getFilesByExtention();
        File file = new File(Constants.DOWNLOAD_PATH + "\\" + this.filesList.get(0));

        if (file.length() != 0) {
            return true;
        } else {
            return false;
        }
    }

    private void getFilesByExtention() {
        File dir = new File(Constants.DOWNLOAD_PATH);
        for (File file : dir.listFiles()) {
            if (file.getName().endsWith((fileExtention))) {
                this.filesList.add(file.getName());
            }
        }
    }

    public static void cleanDownloadDirectory() {
        File dir = new File(Constants.DOWNLOAD_PATH);
        try {
            FileUtils.cleanDirectory(dir);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
