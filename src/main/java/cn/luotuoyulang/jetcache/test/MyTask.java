package cn.luotuoyulang.jetcache.test;

@SuppressWarnings("ALL")
public class MyTask {

    public void a () {
        System.out.println(" Thread " + Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(() -> new MyTask().a()).start();
        }
        new Thread(new Runnable() {
            @Override
            public void run() {
                new MyTask().a();
            }
        }).start();


    }
}
