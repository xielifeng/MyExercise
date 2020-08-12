package Generic;

public class LinkedList<T> {
    private Node<T> head = null;
    private Node<T> p = null;
    private String LinkListName;
    private int length = 0;
    public  LinkedList(String LinkListName){
        this.LinkListName = LinkListName;
    }
    private class Node<T>{
        private T data; //存放数据
        private Node<T> next; //指向下一个结点的指针
        public Node(T data, Node<T> next) {
            this.data = data;
            this.next = next;
        }
    }

    public T add(T data){
        if(head == null){
            //第一次添加节点则将head指向该节点
            head = new Node<>(data,null);
            p = head;
        }else {
            //如果不是第一次添加数据，则创建一个节点，将head指向的结点的下一个结点指向当前创建的结点，
            // 将head指向当前的结点即head一直指向最新的结点。
            Node<T> node = new Node<>(data,null);
            p.next = node;
            p = node;
        }
        this.length += 1;
        return data;
    }

    /**
     * 删除第一个匹配的节点
     * @param data
     * @return
     */
    private T delete(T data){
        //如果头结点需要删除则直接头指针下移
        if (head.data.equals(data)){
            head = head.next;
            return data;
        }
        Node<T> currNode = head;
        //当下一个结点需要删除，则将上一个结点指向下一个结点
        //如果需要删除的是末节点，则p指针前移一个
        while (currNode.next != null){
            Node<T> nextNode = currNode.next;
            if(nextNode.data.equals(data)){
                currNode.next = nextNode.next;
                if (nextNode == p){
                    p = currNode;
                }
                return data;
            }
            currNode = nextNode;
        }
        return null;
    }

    /**
     * 删除所有匹配的节点
     * @param data
     * @return
     */
    private T deleteAll(T data){
        int currLength = length;
        //如果头结点需要删除则直接头指针下移
        if (head.data.equals(data)){
            head = head.next;
            currLength--;
        }
        Node<T> currNode = head;
        //当下一个结点需要删除，则将上一个结点指向下一个结点
        //如果需要删除的是末节点，则p指针前移一个
        while (currNode.next != null){
            Node<T> nextNode = currNode.next;
            if(nextNode.data.equals(data)){
                currNode.next = nextNode.next;
                if (nextNode == p){
                    p = currNode;
                }
                currLength--;
            }
            currNode = nextNode;
        }
        return this.length != currLength?data:null;
    }

    /**
     * 更新第一个匹配的节点数据
     * @param old_data 需要更新的节点数据
     * @param new_data 需要更新成的节点数据
     */
    private void update(T old_data, T new_data){
        Node<T> currNode = this.head;
        while (currNode != null){
            if(currNode.data.equals(old_data)){
                currNode.data = new_data;
                return;
            }
            currNode = currNode.next;
        }
    }
    /**
     * 更新所有匹配的节点数据
     * @param old_data 需要更新的节点数据
     * @param new_data 需要更新成的节点数据
     */
    private void updateAll(T old_data, T new_data){
        Node<T> currNode = this.head;
        while (currNode != null){
            if(currNode.data.equals(old_data)){
                currNode.data = new_data;
            }
            currNode = currNode.next;
        }
    }
    /**
     * 格式化输出对象
     * @return
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node<T> currNode = head;
        while (currNode != p){
            sb.append(currNode.data);
            sb.append("->");
            currNode = currNode.next;
        }
        sb.append(currNode.data);
        return this.LinkListName + "中数据为：" + sb.toString();
    }

    public static void main(String[] args) {
        LinkedList<String> linkedList = new LinkedList<>("LinkList1");
        for (String item:"split java book split java".split(" ")){
            linkedList.add(item);
        }
        System.out.println(linkedList);
        //删除结点
        linkedList.delete("split");
        System.out.println(linkedList);

        linkedList.deleteAll("java");
        System.out.println(linkedList);

        linkedList.update("book","mybook");
        System.out.println(linkedList);

        linkedList.updateAll("mybook","bookbook!");
        System.out.println(linkedList);
    }
}
