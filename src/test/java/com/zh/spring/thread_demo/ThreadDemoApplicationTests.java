package com.zh.spring.thread_demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

@SpringBootTest
class ThreadDemoApplicationTests {

    @Test
    void contextLoads() {
        InputStream in = null;
        try{
            in = new BufferedInputStream(new FileInputStream("C:\\Users\\zh970\\Desktop\\test.txt"));
            byte [] buf = new byte[1024];
            int bytesRead = in.read(buf);
            while(bytesRead != -1)
            {
                for(int i=0;i<bytesRead;i++)
                    System.out.print((char)buf[i]);
                bytesRead = in.read(buf);
            }
        }catch (IOException e)
        {
            e.printStackTrace();
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        }


        @Test
    void test1(){
            RandomAccessFile aFile = null;
            try{
                aFile = new RandomAccessFile("C:\\Users\\zh970\\Desktop\\test.txt","rw");
                FileChannel fileChannel = aFile.getChannel();
                ByteBuffer buf = ByteBuffer.allocate(1024);
                int bytesRead = fileChannel.read(buf);
                System.out.println(bytesRead);
                while(bytesRead != -1)
                {
                    buf.flip();
                    while(buf.hasRemaining())
                    {
                        System.out.print((char)buf.get());
                    }
                    buf.compact();
                    bytesRead = fileChannel.read(buf);
                }
            }catch (IOException e){
                e.printStackTrace();
            }finally{
                try{
                    if(aFile != null){
                        aFile.close();
                    }
                }catch (IOException e){
                    e.printStackTrace();
                }
            }

        }
}
