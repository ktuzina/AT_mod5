package com.training.task.module5.utils;

import java.io.File;
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
}
