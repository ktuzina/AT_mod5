package com.training.task.module5.utils;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
        Log.debug("File '" + this.filesList.get(0) + "' size is " + file.length());
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
                Log.debug("File with name '" + file.getName() + "' found");
            }
        }
    }

    public static void cleanDownloadDirectory() {
        File dir = new File(Constants.DOWNLOAD_PATH);
        try {
            FileUtils.cleanDirectory(dir);
            Log.info("Directory '" + Constants.DOWNLOAD_PATH + "' is cleaned");
        } catch (IOException e) {
            Log.error("Failed to clean directory '" + Constants.DOWNLOAD_PATH);
            e.printStackTrace();
        }
    }
}
