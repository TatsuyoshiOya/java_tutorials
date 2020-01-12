public class Tester {
  public static void main(String[] args) throws InterruptedException {
    // 問題dの回答はthrows *throwというものはないので選んだら✕
    createUserMobileDevice("Taro", "phone");
    createUserMobileDevice("Taro", "tablet");
    Notifier notifier = Notifier.getInstance();
    notifier.send("Taro", "You have a message.");

    Thread.sleep(500L);
    notifier.shutdown();
    /* α */
  }

  private static void createUserMobileDevice(String user, String name) {
    MobileDevice device = new MobileDevice(name, messageList -> System.out.println(name + ": " + messageList));
    // eの回答はname, messageListの内容と問題の実行結果を見れば簡単に分かる
    Notifier notifier = Notifier.getInstance();
    notifier.register(user, device);
    new Thread(() -> {
      notifier.loopForMessages(device);
      System.out.printf("Terminating %s's %s%n", user, name);
    }).start();
  }
}
