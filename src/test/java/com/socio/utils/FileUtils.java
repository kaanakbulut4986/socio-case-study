package com.socio.utils;

import java.nio.file.FileSystems;

public class FileUtils {
    private static final String imagesFolderLocation = FileSystems.getDefault().getPath(System.getProperty("user.dir"), "/src/test/resources/images").toString();

    public static String getPostImageFileName(){
        return FileSystems.getDefault().getPath(imagesFolderLocation, "/post_image.png").toString();
    }



}
