package basic.java.juc.i_productorAndConsumerLock;

/**
 * 1. 两个同步方法，两个线程，标准打印 one two
 * 2. 新增Thread.sleep()给getOne(), 打印？one two
 * 3. 新增方法getThree()，打印？ three one two
 * 4. 两个普通同步方法，两个对象，标准打印？ two one
 * 5. 修改getOne()为静态同步方法，一个普通同步方法，标准打印？ two one
 * 6. 两个静态同步方法，打印？ one two
 * 7. 一个静态同步方法，一个非静态同步方法，两个number对象，打印？ two one
 * 8. 两个静态同步方法，两个number对象，打印？ one two
 * 判断打印的one or two.
 *
 * 线程8锁的关键：
 * 1. 非静态方法的锁默认为this， 静态方法的锁为对应的Class实例
 * 2. 某一个时刻内，只能由一个线程持有锁，无论几个方法。
 *
 * @author Shawn
 * @date 2020/8/10
 */
public class TestThread8Monitor {
  public static void main(String[] args) {
    Number number = new Number();
    Number number2 = new Number();
    new Thread(new Runnable() {
      @Override
      public void run() {
        number.getOne();
      }
    }).start();
    new Thread(new Runnable() {
      @Override
      public void run() {
//        number.getTwo();
        number2.getTwo();
      }
    }).start();
//    new Thread(new Runnable() {
//      @Override
//      public void run() {
//        number.getThree();
//      }
//    }).start();
  }
}

class Number {
  public static synchronized void getOne() {
    try {
      Thread.sleep(3000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    System.out.println("one");
  }
  public static synchronized void getTwo() {
    System.out.println("two");
  }
  public synchronized void getThree() {
    System.out.println("three");
  }
}
