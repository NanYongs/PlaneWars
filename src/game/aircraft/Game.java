package game.aircraft;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

public class Game extends Frame {
	
	Image bg = GameTool.getImage("image/background.jpg");	//加载图片
	Image plane = GameTool.getImage("image/plane.png");
	GamePlane p = new GamePlane(plane,250,250);	//创建飞机对象，传入实参
	GameShell[] shell = new GameShell[50];	//创建炮弹对象,50个炮弹
	GameExplode ge;	//声明爆炸对象
	
	private Image offScreenImage = null;	//屏幕外的影像为空

		public static void main(String[] args) {
			Game game = new Game();
			game.initWindow();	//初始化窗口
		}
		
		public void initWindow() {
			//初始化窗口
			this.setTitle("飞机大战");	//设置标题
			this.setVisible(true);	//设置可见
			this.setSize(GameConstant.WINDOW_WIDTH, GameConstant.WINDOW_HEIGHT);	//设置宽高
			this.setLocation(700, 300);	//设置窗口位置
			
			this.addWindowListener(new WindowAdapter() {
				//监听事件
				@Override
				public void windowClosing(WindowEvent e) {
					System.exit(0);	//程序正常终止
				}
			});
			new paintThread().start();	//启动无限重画线程
			addKeyListener(new keyControl());	//增加键盘监听
			
			for(int i = 0; i <shell.length; i++) {
					//初始化50个炮弹
				shell[i] = new GameShell();
			}
		}
		
		@Override
		public void paint(Graphics g) {
			//自动执行无需调用，g为画笔
			g.drawImage(bg,0,0,null);	//画背景位置
			p.drawSelf(g);	//画飞机
			
				//画出50个炮弹
			for(int i = 0; i < shell.length; i++) {
				shell[i].drawShell(g);
				//炮弹与飞机碰撞
				boolean crash = shell[i].getRect().intersects(p.getRect());
				if(crash) {
					p.state = false;
					if (ge == null) {
						//只生成一个对象
					ge = new GameExplode(p.x, p.y);	//传入飞机坐标爆炸
					}
					ge.drawImage(g);	//画出爆炸
				}
			}
		}
		
		public void DoubleBuffer(Graphics g) {
			//双缓冲技术，减少图片闪烁
			if(offScreenImage == null) {
				//创建一幅用于双缓冲的、可在屏幕外绘制的图像
				offScreenImage = this.createImage(GameConstant.WINDOW_WIDTH
						,GameConstant.WINDOW_HEIGHT);
				//创建供绘制闭屏图像使用的图形上下文
				Graphics gOff = offScreenImage.getGraphics();
				paint(gOff);	
				g.drawImage(offScreenImage,0,0,null);	//画图
			}
		}
		
		class paintThread extends Thread {
			//无限重画线程
			@Override
			public void run() {
				while(true) {
					repaint();	//无限重画窗口
					try {
						Thread.sleep(40);	//40ms画一次
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}
		
		class keyControl extends KeyAdapter {
				//键盘控制
			@Override
			public void keyPressed(KeyEvent e) {
				//按下键
				p.PressKey(e);
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				//松开键
				p.LoosenKey(e);
			}
		}
}

