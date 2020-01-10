import java.awt.Color;
// 色を設定するのに必要なクラス
import java.awt.Graphics;
import java.awt.event.*;
// MouseListenerのライブラリを使うための一文
import javax.swing.*;
// *の意味はライブラリに含まれる全てのクラスをインポートするということ
// ライブラリの一部のクラスをインポートするには、*の代わりにクラス名を書き込む

public class SimplePainter {
  public static void main(String[] arg) {
    JFrame frame = new JFrame("SimplePainter");
    // JFrameはswingライブラリのクラスの一つ
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    // ウィンドウの閉じるボタンを押したときの挙動を設定
    frame.setSize(600, 400);
    frame.setLocationRelativeTo(null);
    // ウィンドウの表示位置を設定（なくても実行できる）

    Canvas canvas = new Canvas();
    frame.add(canvas);

    frame.setVisible(true);
    // ウィンドウを可視化するためのコード、これがないとウィンドウが画面に表示されなくなる
  }
}

class Canvas extends JPanel implements MouseListener, MouseMotionListener {
  private int x = -100;
  private int y = -100;

  public Canvas() {
    addMouseListener(this);
    addMouseMotionListener(this);
    setSize(600, 400);
  }

  //@Overrideは extendsして作ったサブクラスで、元のスーパークラスにあったメソッドを書き換える（override）こと。ここでは、paintComponent()というメソッドの内容を書き換えている
  @Override
  public void paintComponent(Graphics g) {
    g.setColor(Color.BLUE);
    g.fillOval(x-5, y-5, 10, 10);
  }

  @Override
  // mouseClicked = コンポーネント上でマウスがクリックされた（押して離れた）とき
  public void mouseClicked(MouseEvent e) {
  }

  @Override
  public void mousePressed(MouseEvent e) {
    x = e.getX();
    y = e.getY();
    // マウスの座標を取得
    repaint();
  }

  @Override
  public void mouseReleased(MouseEvent e) {
  }

  @Override
  public void mouseEntered(MouseEvent e) {
  }

  @Override
  // マウスがコンポーネント上に入った時
  public void mouseExited(MouseEvent e) {
  }

  @Override
  // マウスがコンポーネント上から出たとき
  public void mouseDragged(MouseEvent e) {
    x = e.getX();
    y = e.getY();
    repaint();
  }

  @Override
  public void mouseMoved(MouseEvent e) {
  }
}
