package IODemo.FileDemo;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;

public class FileList {
    public static void main(String[] args) {
        File file = new File("E:\\公司培训\\Projects\\src\\IODemo");
        String[] list;
        list = file.list(new DirFilter(".*java"));
        Arrays.sort(list,String.CASE_INSENSITIVE_ORDER);
        for(String filename:list){
            System.out.println(filename);
        }
    }

    static class DirFilter implements FilenameFilter {
        private Pattern pattern;

        public DirFilter(String string) {
            this.pattern = Pattern.compile(string);
        }

        @Override
        public boolean accept(File dir, String name) {
            return pattern.matcher(name).matches();
        }
    }
}
