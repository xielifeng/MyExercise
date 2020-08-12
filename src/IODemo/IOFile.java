package IODemo;

import java.io.File;
import java.io.IOException;

public class IOFile {
    public static void main(String[] args) {
        File parentFile = new File("File");
        if (!parentFile.exists())
            parentFile.mkdirs();
        File file = new File(parentFile,"Monday.docx");
        if (!file.exists()){//如果文件不存在则创建文件
            try {
                file.createNewFile();
                System.out.println("创建文件成功");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println("文件名称:" + file.getName());
        System.out.println("文件上一级目录：" + file.getParent());
        System.out.println("文件/目录："+ (file.isDirectory()?"目录":"文件"));
        String readOrWrite;
        if(file.canRead()){
            if (file.canWrite()){
                readOrWrite = "这个文件可以读还可以写";
            }else {
                readOrWrite = "这个文件只可读";
            }
        }else if(file.canWrite()){
            readOrWrite = "这个文件只可写";
        }else {
            readOrWrite = "这个文件既不可读也不可写";
        }
        System.out.println("读写性：" + readOrWrite);

    }


}
