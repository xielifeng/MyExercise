package Test;

public class CallTest implements MyCall {

    private String data = "嘿嘿?";

    /**
     * 实现回调方法
     * @param data
     */
    @Override
    public void onFinish(String data) {
        this.data = data;
        System.out.print("Loading data succueefully\nData value is " + data);
    }

    public static void main(String[] args) {
        CallTest test = new CallTest();
        System.out.println("Data value is " + test.data);
        //开启线程加载数据
        new Thread(()->{
            LoaderData.loadata(test);
        }).start();
        System.out.println("Now is Loading data!!!");
    }
}
