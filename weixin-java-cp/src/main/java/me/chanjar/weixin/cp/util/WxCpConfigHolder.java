package me.chanjar.weixin.cp.util;

/**
 * 企业微信存储值存放类.
 *
 * @author <a href="https://github.com/binarywang">Binary Wang</a>
 * @date 2020-08-16
 */
public class WxCpConfigHolder {
  private final static ThreadLocal<String> THREAD_LOCAL = new ThreadLocal<String>() {
    @Override
    protected String initialValue() {
      return "default";
    }
  };

  public static String get() {
    return THREAD_LOCAL.get();
  }

  public static void set(String label) {
    THREAD_LOCAL.set(label);
  }

  /**
   * 此方法需要用户根据自己程序代码，在适当位置手动触发调用，本SDK里无法判断调用时机
   */
  public static void remove() {
    THREAD_LOCAL.remove();
  }
}
