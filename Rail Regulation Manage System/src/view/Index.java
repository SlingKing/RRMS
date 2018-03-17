/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

/**
 *
 * @author Administrator
/

/**
 * 用户登录的闪屏效果
 */
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.JWindow;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
public class Index extends JWindow implements Runnable {

	/**
	 * @param args
	 */
	paint p;
	public static void main(String[] args) {
		try {
			// 将当前窗体外观设置为所在操作系统的外观
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		Index index = new Index();
		Thread t = new Thread(index);
		t.start();
	}

	public Index() {
		// 创建P
		p = new paint();
		this.add(p);
  
		this.setSize(400, 250);
		// 确定Jwindow初始位置
//		int width = Toolkit.getDefaultToolkit().getScreenSize().width;
//		int height = Toolkit.getDefaultToolkit().getScreenSize().height;
//		this.setLocation(width / 2 - 200, height / 2 - 150);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	public void run() {
		while (true) {
			// 根据计算等待闪屏效果结束后，再跳转到登陆界面
			try {
				Thread.sleep(30 * 500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			//关闭闪屏
			this.dispose();
			// 跳转到登陆界面
			new UserLogin();
			break;
		}
	}
}

// 开发一个闪屏类
class paint extends JPanel implements Runnable{// 可以自动刷新Panel
	Thread t;
	int x = 10;
	int i = 0, j = 40, u = 10;
	String gg[] = { "系", "统", "正", "在", "加", "载", "请", "稍", "侯" };
	int k = 0, tt = 0;
	String shi[] = { "虹", "铭", "汽", "配", "行","优","质", "服", "务", "聚", "品", "质",
			"正", "品", "供", "质", "量", "保", "障", "汽", "车", "保", "障", "者", 
			"虹", "铭", "汽","配", "程", "序", "演", "示" };
	Font f = new Font("正楷", Font.PLAIN, 30);

	boolean ifok = true;
	int width = 180;
	int height = 0;
	int dian = 0;

	paint() {
		t = new Thread(this);
		t.start();
	}

	public void run() {
		while (true) {
			if (x <= 380);
			repaint();
			try {
				Thread.sleep(70);
				i++;// i=0
				j = j - 6;// j=40
				u = u + 10;// u=10
				if (tt == 3)
					width = width - 20; // tt=0,width=180
				if (i == 4) {
					tt++;
					if (ifok && x > 120 + k * 20)
						k++;// k=0
					if (k >= gg.length - 1)
						ifok = false;
					x = x + 10;
					i = 0;
					j = 40;
					u = 10;
					dian++;
					if (dian > 3)
						dian = 0;
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void paintComponent(Graphics g) {
		// super.paintComponent(g);
            Image image = null;
            try {
                image=ImageIO.read(new File("image/index1.jpg"));// 获得背景图片
            } catch (IOException ex) {
                Logger.getLogger(paint.class.getName()).log(Level.SEVERE, null, ex);
            }
		g.drawImage(image, 0, 0, this.getWidth(), 200, this);

		int r = (int) (Math.random() * 255);
		int b = (int) (Math.random() * 255);
		int y = (int) (Math.random() * 255);

		g.setColor(new Color(253, 250, 250));// White
		g.fillRect(x, 210, 380 - x, 30);
		g.setColor(new Color(253, 250, 250));// white
		if (i > 1)
			g.fillRect(x, 235 - (j + 20) / 2, 10, j + 10);// 领头的长方块儿
		if (j > 25)
			g.setColor(new Color(r, b, y));
		else
			g.setColor(new Color(123, 194, 252));// light blue
		g.fillRect(x, 235 - (j + 20) / 2, 10, j);// 后面跟着的短方块儿,10代表闪动条的宽度，j代表闪动条的高度
		g.setColor(new Color(123, 194, 252));// light blue
		g.drawRect(10, 210, 380, 30);

		if (x < 120) {
			for (int l = 0; l < gg.length; l++) {
				g.setColor(new Color(0, 0, 0));
				g.drawString(gg[l], 120 + l * 20, 230);
			}
			for (int l = 0; l < dian; l++) {
				g.setColor(new Color(0, 0, 0));
				g.drawString("*", 300 + l * 10, 235);
			}
			g.drawString("*", 300 + dian * 10, 235);
		} else {
			// 设置写字的颜色和位置
			g.setColor(new Color(23, 23, 230));
			g.drawString(gg[k], 120 + k * 20, 230);

			for (int l = k + 1; l < gg.length; l++) {
				g.setColor(new Color(0, 0, 0));
				g.drawString(gg[l], 120 + l * 20, 230);
			}
			if (x > 300 + dian * 10)
				g.setColor(new Color(23, 23, 230));
			for (int l = 0; l < dian; l++) {
				g.drawString("*", 300 + l * 10, 235);
			}
			g.drawString("*", 300 + dian * 10, 235);
		}
		// ------------逐字写诗
                Font f = new Font("正楷", Font.PLAIN, 23);
                g.setFont(f);
		if (tt < 4) {
			for (int rr = 0; rr <= tt; rr++) {
				g.setColor(new Color(250, 0, 0));
				g.drawString(shi[rr], 240, 80 + rr * 20);
			}
			g.drawString(shi[tt], 240, 80 + tt * 20);
		}
		if (tt >=4 && tt < 9) {
			g.setColor(new Color(230, 0, 0));
			for (int rr = 0; rr <4; rr++)
				g.drawString(shi[rr], 240, 80 + rr * 20);
			g.setColor(new Color(r, b, y));
			if (tt < 9)
				for (int rr = 4; rr <= tt; rr++)
					g.drawString(shi[rr], 210, rr * 20);
		}
		if (tt >= 9 && tt < 14) {
			g.setColor(new Color(230, 0, 0));
			for (int rr = 0; rr < 4; rr++)
				g.drawString(shi[rr], 240, 80 + rr * 20);
			for (int rr = 4; rr <= 8; rr++)
				g.drawString(shi[rr], 210, rr * 20);
			g.setColor(new Color(r, b, y));
			if (tt < 14)
				for (int rr = 9; rr <= tt; rr++)
					g.drawString(shi[rr], 180, rr * 20 - 100);
		}
		if (tt >= 14 && tt < 19) {
			g.setColor(new Color(230, 0, 0));
			for (int rr = 0; rr < 4; rr++)
				g.drawString(shi[rr], 240, 80 + rr * 20);
			for (int rr = 4; rr <= 8; rr++)
				g.drawString(shi[rr], 210, rr * 20);
			for (int rr = 9; rr <=13; rr++)
				g.drawString(shi[rr], 180, rr * 20 - 100);
			g.setColor(new Color(r, b, y));
			if (tt < 19)
				for (int rr = 14; rr <= tt; rr++)
					g.drawString(shi[rr], 150, rr * 20 - 200);
		}
		if (tt >= 19 && tt < 24) {
			g.setColor(new Color(230, 0, 0));
			for (int rr = 0; rr < 4; rr++)
				g.drawString(shi[rr], 240, 80 + rr * 20);
			for (int rr = 4; rr <= 8; rr++)
				g.drawString(shi[rr], 210, rr * 20);
			for (int rr = 9; rr <=13; rr++)
				g.drawString(shi[rr], 180, rr * 20 - 100);
			for (int rr = 14; rr <= 18; rr++)
				g.drawString(shi[rr], 150, rr * 20 - 200);
			g.setColor(new Color(r, b, y));
			if (tt < 24)
			        for (int rr = 19; rr <= tt; rr++)
				g.drawString(shi[rr], 120, rr * 20 - 300);
		}
		if (tt >= 24 && tt < 28) {
			g.setColor(new Color(230, 0, 0));
			for (int rr = 0; rr < 4; rr++)
				g.drawString(shi[rr], 240, 80 + rr * 20);
			for (int rr = 4; rr <= 8; rr++)
				g.drawString(shi[rr], 210, rr * 20);
			for (int rr = 9; rr <=13; rr++)
				g.drawString(shi[rr], 180, rr * 20 - 100);
			for (int rr = 14; rr <= 18; rr++)
				g.drawString(shi[rr], 150, rr * 20 - 200);
			for (int rr = 19; rr <= 23; rr++)
				g.drawString(shi[rr], 120, rr * 20 - 300);
			g.setColor(new Color(r, b, y));
			if (tt < 28)
				for (int rr = 24; rr <= tt; rr++)
					g.drawString(shi[rr], 90, rr * 20 - 400);
		}
		if (tt > 28) {
			g.setColor(new Color(250, 0, 0));
			for (int rr = 0; rr < 4; rr++)
				g.drawString(shi[rr], 240, 80 + rr * 20);
			for (int rr = 4; rr <= 8; rr++)
				g.drawString(shi[rr], 210, rr * 20);
			for (int rr = 9; rr < 14; rr++)
				g.drawString(shi[rr], 180, rr * 20 - 100);
			for (int rr = 14; rr < 19; rr++)
				g.drawString(shi[rr], 150, rr * 20 - 200);
			for (int rr = 19; rr < 24; rr++)
				g.drawString(shi[rr], 120, rr * 20 - 300);
			for (int rr = 24; rr < 28; rr++)
				g.drawString(shi[rr], 90, rr * 20 - 400);
                        for (int rr = 28; rr < 32; rr++)
				g.drawString(shi[rr], 60, rr * 20 - 480);
		}
	}
}