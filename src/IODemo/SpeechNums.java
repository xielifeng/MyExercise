package IODemo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class SpeechNums {
    public static void main(String[] args) {
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(".\\File\\speech.txt");
            int n;
            int byteNums = 0;
            while ((n=fileInputStream.read()) != -1){
                byteNums++;
            }
            System.out.print("统计结果:speech.txt文件中共有"+byteNums+"字节。");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileInputStream!=null){
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
