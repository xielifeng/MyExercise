package IODemo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileInputStreamDemo {
    public static void main(String[] args) {
        File file = new File(".\\File\\fileInputStreamTest.txt");
        System.out.println(file.exists());
        byte [] bytes = new byte[1024];
        int n;
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
//            while ((n=fileInputStream.read())!=-1){//使用read()方法读取数据
//                System.out.print((char)n);
//            }
//            while ((n=fileInputStream.read(bytes))!=-1){//使用read(byte[])方法读取数据
//                System.out.println(new String(bytes));
//            }
            while ((n=fileInputStream.read(bytes,0,5))!=-1){//使用read(byte[],off,len)方法读取数据,len为一次读入的数组的长度。
                System.out.println(new String(bytes));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
