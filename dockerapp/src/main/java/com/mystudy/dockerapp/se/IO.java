package com.mystudy.dockerapp.se;

import com.google.common.io.ByteStreams;

import java.io.*;

/**
 * @author ：songdalin
 * @date ：2021-08-31 下午 08:56
 * @description：
 * @modified By：
 * @version: 1.0
 */
public class IO {

    public static void main(String[] args) throws IOException {
        File file = new File("D:\\My_Company\\package\\log");
        FileInputStream fileInputStream = new FileInputStream(file);
        BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);

        byte[] bytes = new byte[1024];
        try {
            if (bufferedInputStream != null) {
                for (;;) {
                    int count = bufferedInputStream.read(bytes);

                    if (count == -1) {
                        break;
                    }
                    System.out.println(new String(bytes, 0, count));

                    //outputStream.write(bytes);
                    //outputStream.flush();
                }

            }
        }finally {
            bufferedInputStream.close();
            fileInputStream.close();
            file = null;
        }




    }
}
