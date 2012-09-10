package com.purang.bill.socket.xml;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Company :普兰科技
 * Create User:周明
 * Create Date:12-8-17
 * Create Time:下午5:31
 */
public class FileUtil {
    public final static String SPLIT = "~";

    public static List<String> readFromUrl(String url) {
        List<String> line = new ArrayList<String>();
        InputStream in = null;
        try {
            in = new URL(url).openStream();
            line = IOUtils.readLines(in);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            IOUtils.closeQuietly(in);
        }
        return line;
    }

    public static List<String> readFile(String path) {
        List<String> line = new ArrayList<String>();
        File file = new File(path);
        try {
            line = FileUtils.readLines(file, "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return line;
    }

    public static List<String> readLine(String line) {
        List<String> list = new ArrayList<String>();
        String[] strs = line.split(SPLIT);
        for (String s : strs) {
            String temp = s;
            if (s.startsWith("\"")) {
                temp = s.substring(1, s.length() - 1);
            }
            list.add(temp);
        }
        return list;
    }

    public static void main(String[] args) {
        List<String> list = FileUtil.readFile("C:\\test.txt");
        for (String s : list) {
            List<String> v = readLine(s);
            for (String t : v) {
                System.out.print(t + " | ");
            }
            System.out.println("");
        }
    }
}