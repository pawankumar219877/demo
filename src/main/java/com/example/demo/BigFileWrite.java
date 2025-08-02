package com.example.demo;

import net.minidev.json.JSONArray;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class BigFileWrite {

    public  static void main(String arg[]) throws IOException {
        char[] chars = new char[100*1024*1024];
        Arrays.fill(chars, 'A');
        String text = new String(chars);
        long start = System.nanoTime();

        List<HashMap<String,String>> dataList = new ArrayList<>();
        for(int i=0; i<10; i++){
            HashMap<String,String> hm =new HashMap<String,String>();
            hm.put("key","B");
            dataList.add(hm);
        }
        JSONArray jsArray = new JSONArray();
        String data = jsArray.toJSONString(dataList).substring(1);
        String writedata= data.substring(0,data.length()-1);

        fileWrite("[");

        fileWrite(writedata);

        //fileWrite("]");

        long time = System.nanoTime() - start;
        System.out.println("Wrote " + chars.length*1000L/time+" MB/s.");
    }


    public static void fileWrite(String data) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Dropbox\\Apps\\demo\\a.txt",true));
        bw.write(data);
        bw.close();
    }

}
