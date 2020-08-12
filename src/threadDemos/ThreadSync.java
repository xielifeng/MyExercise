package threadDemos;

public class ThreadSync {
    public class Bank{
        private int accout;
        private String name;
        Bank(String name,int accout){
            this.accout = accout;
            this.name = name;
        }
        public int getAccout() {
            return accout;
        }
        public void setAccout(int accout) {
            this.accout = accout;
        }
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
        synchronized public void outAccout(){//采用同步方法的方式同步线程
            int accout = this.getAccout();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.setAccout(accout-100);
            System.out.println(this.name + "账户余额为:"+this.accout+"元");
        }
        public void inAccout(){
            synchronized (this){//采用同步代码块的方式同步线程
                int accout = this.getAccout();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                this.setAccout(200+accout);
                System.out.println(this.name + "账户余额为:"+this.accout+"元");
            }

        }
        @Override
        public String toString() {
            return this.name + "账户余额为:"+this.accout+"元";
        }
    }

    class inAccoutClass extends Thread{
        private Bank bank;
        inAccoutClass(Bank bank){
            this.bank = bank;
        }
        @Override
        public void run() {
            bank.inAccout();
        }
    }
    class outAccoutClass extends Thread{
        private Bank bank;
        outAccoutClass(Bank bank){
            this.bank = bank;
        }
        @Override
        public void run() {
            bank.outAccout();
        }
    }

     public static void main(String[] args) {
        ThreadSync threadSync = new ThreadSync();
        Bank bank = threadSync.new Bank("账户1212",1000);//创建银行账户
        inAccoutClass in = threadSync.new inAccoutClass(bank);//存钱线程
        outAccoutClass out = threadSync.new outAccoutClass(bank);//取钱线程
        out.start();
        in.start();
    }
}
