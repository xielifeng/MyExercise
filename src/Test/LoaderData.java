package Test;

public class LoaderData {
    /**
     * 模拟当获取数据完成后，进行回调接着处理其他东西
     * @param call
     */
    public static void loadata(MyCall call){
        String data = "哈哈？";
        try {
            //暂停2s
            Thread.sleep(2*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        call.onFinish(data);
    }
}
