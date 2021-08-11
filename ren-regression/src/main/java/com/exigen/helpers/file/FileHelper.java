/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.helpers.file;

//import com.exigen.ipb.eisa.utils.ssh.SshClient;

import com.exigen.istf.config.PropertyProvider;
import com.exigen.istf.config.TestProperties;
import com.exigen.istf.exceptions.IstfException;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;

import static com.exigen.ren.main.modules.mywork.IMyWork.LOGGER;
import static java.util.stream.Collectors.toList;


public class FileHelper {
  //  private static SshClient sftp = SshClient.get();

    public static File createFile(String fileName, List<String> list)
    {
        File downloadDir = new File(PropertyProvider.getProperty(TestProperties.BROWSER_DOWNLOAD_FILES_LOCATION));

        if (!downloadDir.exists()) {
            if (!downloadDir.mkdirs()) {
                throw new IstfException("Folder hasn't created!!!");
            }
        }

        File file = new File(downloadDir, fileName);
        try {
            FileWriter fw = new FileWriter(file);
            list.forEach(s -> {
                try {
                    fw.append(s).append("\n");
                } catch (IOException e) {
                    throw new IstfException("File is not created", e);
                }
            });
            fw.flush();
            fw.close();
        }
        catch (IOException e) {
            throw new IstfException("File is not created", e);
        }
        return file;
    }

    public static void addTextToFile(String fileName, String text){
        addTextToFile(new File(fileName), text);
    }

    public static void addTextToFile(File fileName, String text){
        try
        {
            FileWriter fw = new FileWriter(fileName,true); //the true will append the new data
            fw.write(text);//appends the string to the file
            fw.close();
        }
        catch (IOException e) {
            throw new IstfException("File is not created", e);
        }
    }

    public static synchronized String getFileContent(File customLogFile) {
        try (InputStream is = new FileInputStream(customLogFile)) {
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            return IOUtils.toString(br);
        } catch (IOException e) {
            throw new IstfException("Unable to get content from file: " + customLogFile.getPath(), e);
        }
    }

    public static List<String> readFile(String destinationDir, String fileName) {
        List<String> list = null;
        try {
            list = Arrays.stream(FileUtils.readFileToString(new File(destinationDir, fileName), StandardCharsets.UTF_8)
                    .split("\\n"))
                    .collect(toList());
        } catch (IOException e) {
            LOGGER.info(e.getMessage());
        }
        return list;
    }

}
