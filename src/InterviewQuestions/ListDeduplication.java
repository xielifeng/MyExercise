package InterviewQuestions;

import java.util.*;
import java.util.stream.Collectors;

/**
 * list去除重复的元素
 * 1. 两层循环去重
 * 2. Srream去重
 * 3. set去重
 * 4. map去重
 * 5. list.contains去重
 */
public class ListDeduplication {

    /**
     * 1. 两层循环去重,当新的list中没有相同的元素的时候，添加到新的list中
     * @param lists 需要去重的list
     * @param myLists 用于去重后返回的list
     * @param <T>
     */
    public <T> void forDeduplication(List<T> lists,List<T> myLists){
        for (T list : lists){
            boolean flag = true;
            for (T mylist: myLists){
                if (list.equals(mylist)){
                    flag = false;
                    break;
                }
            }
            if (flag){
                myLists.add(list);
            }
        }
    }

    /**
     * 2. Srream去重,利用函数distinct()
     * @param lists
     * @param myLists
     * @param <T>
     */
    public <T> void streamDeduplication(List<T> lists,List<T> myLists){
        myLists.addAll(lists.stream().distinct().collect(Collectors.toList()));
    }

    /**
     * 3.set去重,利用set存储方式元素不能有重发的特性
     * @param lists
     * @param myLists
     * @param <T>
     */
    public <T> void setDeduplication(List<T> lists,List<T> myLists){
        LinkedHashSet set = new LinkedHashSet(lists);
        myLists.addAll(set);
    }

    /**
     * 4. map去重，利用map的key值不可重复的特性
     * @param lists
     * @param myLists
     * @param <T>
     */
    public <T> void mapDeduplication(List<T> lists,List<T> myLists){
        LinkedHashMap<T,Object> map = new LinkedHashMap<>();
        lists.stream().map(data ->map.put(data,new Object())).collect(Collectors.toList());
        myLists.addAll(map.keySet());
    }

    /**
     * 5. list.contains去重
     * @param lists
     * @param myLists
     * @param <T>
     */
    public <T> void containsDeduplication(List<T> lists,List<T> myLists){
        for (T list: lists){
            if (!myLists.contains(list)){
                myLists.add(list);
            }
        }
    }
    /**
     * pencil 类，有铅笔名name和颜色color两个属性
     * 重写hashcode和equles方法用于contain，List.indexof等方法
     */
    class Pencil{
        private String name;
        private String color;

        public Pencil(String name, String color) {
            this.name = name;
            this.color = color;
        }

        @Override
        public int hashCode() {
            return name.hashCode()+color.hashCode();
        }

        @Override
        public boolean equals(Object obj) {
            //如果都为空返回true
            if(obj == null && this == null){
                return true;
            }
            //如果输入不为空，名字和颜色都相同则返回true
            if(obj != null){
                if(obj instanceof Pencil){
                    Pencil pencil = (Pencil)obj;
                    if (this.name.equals(pencil.name) && this.color.equals(pencil.color)){
                        return true;
                    }
                }
            }
            return false;
        }
    }

    public static void main(String[] args) {
        ListDeduplication listDeduplication = new ListDeduplication();
        List<String> list = Arrays.asList("I love you but you do not love me".split(" "));
        List<String> mylists = new ArrayList<>();
        
        listDeduplication.forDeduplication(list,mylists);
        mylists.forEach((data)-> System.out.print(data + " "));
        System.out.println();

        mylists.clear();
        listDeduplication.streamDeduplication(list,mylists);
        mylists.forEach((data)-> System.out.print(data + " "));
        System.out.println();

        mylists.clear();
        listDeduplication.setDeduplication(list,mylists);
        mylists.forEach((data)-> System.out.print(data + " "));
        System.out.println();

        mylists.clear();
        listDeduplication.mapDeduplication(list,mylists);
        mylists.forEach((data)-> System.out.print(data + " "));
        System.out.println();

        mylists.clear();
        listDeduplication.containsDeduplication(list,mylists);
        mylists.forEach((data)-> System.out.print(data + " "));
        System.out.println();
    }
}
