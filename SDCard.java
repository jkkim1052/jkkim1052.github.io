package com.gunu.blackbox;

import android.os.Environment;
import android.util.Log;

import java.io.File;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Locale;

public class SDCard {
    public static String getExternalSDCardPath() {
        String sdcardpath = "";

        //Datas
        if (new File("/data/sdext4/").exists() && new File("/data/sdext4/").canRead()){
            sdcardpath = "/data/sdext4/";
        }
        if (new File("/data/sdext3/").exists() && new File("/data/sdext3/").canRead()){
            sdcardpath = "/data/sdext3/";
        }
        if (new File("/data/sdext2/").exists() && new File("/data/sdext2/").canRead()){
            sdcardpath = "/data/sdext2/";
        }
        if (new File("/data/sdext1/").exists() && new File("/data/sdext1/").canRead()){
            sdcardpath = "/data/sdext1/";
        }
        if (new File("/data/sdext/").exists() && new File("/data/sdext/").canRead()){
            sdcardpath = "/data/sdext/";
        }

        //MNTS

        if (new File("mnt/sdcard/external_sd/").exists() && new File("mnt/sdcard/external_sd/").canRead()){
            sdcardpath = "mnt/sdcard/external_sd/";
        }
        if (new File("mnt/extsdcard/").exists() && new File("mnt/extsdcard/").canRead()){
            sdcardpath = "mnt/extsdcard/";
        }
        if (new File("mnt/external_sd/").exists() && new File("mnt/external_sd/").canRead()){
            sdcardpath = "mnt/external_sd/";
        }
        if (new File("mnt/emmc/").exists() && new File("mnt/emmc/").canRead()){
            sdcardpath = "mnt/emmc/";
        }
        if (new File("mnt/sdcard0/").exists() && new File("mnt/sdcard0/").canRead()){
            sdcardpath = "mnt/sdcard0/";
        }
        if (new File("mnt/sdcard1/").exists() && new File("mnt/sdcard1/").canRead()){
            sdcardpath = "mnt/sdcard1/";
        }
        if (new File("mnt/sdcard/").exists() && new File("mnt/sdcard/").canRead()){
            sdcardpath = "mnt/sdcard/";
        }

        //Storages
        if (new File("/storage/removable/sdcard1/").exists() && new File("/storage/removable/sdcard1/").canRead()){
            sdcardpath = "/storage/removable/sdcard1/";
        }
        if (new File("/storage/external_SD/").exists() && new File("/storage/external_SD/").canRead()){
            sdcardpath = "/storage/external_SD/";
        }
        if (new File("/storage/ext_sd/").exists() && new File("/storage/ext_sd/").canRead()){
            sdcardpath = "/storage/ext_sd/";
        }
        if (new File("/storage/sdcard1/").exists() && new File("/storage/sdcard1/").canRead()){
            sdcardpath = "/storage/sdcard1/";
        }
        if (new File("/storage/sdcard0/").exists() && new File("/storage/sdcard0/").canRead()){
            sdcardpath = "/storage/sdcard0/";
        }
        if (new File("/storage/sdcard/").exists() && new File("/storage/sdcard/").canRead()){
            sdcardpath = "/storage/sdcard/";
        }
        if (sdcardpath.contentEquals("")){
            sdcardpath = Environment.getExternalStorageDirectory().getAbsolutePath();
        }

        Log.v("SDFinder","Path: " + sdcardpath);
        return sdcardpath;
    }

}
