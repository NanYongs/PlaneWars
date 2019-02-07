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
	
	Image bg = GameTool.getImage("image/background.jpg");	//����ͼƬ
	Image plane = GameTool.getImage("image/plane.png");
	GamePlane p = new GamePlane(plane,250,250);	//�����ɻ����󣬴���ʵ��
	GameShell[] shell = new GameShell[50];	//�����ڵ�����,50���ڵ�
	GameExplode ge;	//������ը����
	
	private Image offScreenImage = null;	//��Ļ���Ӱ��Ϊ��

		public static void main(String[] args) {
			Game game = new Game();
			game.initWindow();	//��ʼ������
		}
		
		public void initWindow() {
			//��ʼ������
			this.setTitle("�ɻ���ս");	//���ñ���
			this.setVisible(true);	//���ÿɼ�
			this.setSize(GameConstant.WINDOW_WIDTH, GameConstant.WINDOW_HEIGHT);	//���ÿ��
			this.setLocation(700, 300);	//���ô���λ��
			
			this.addWindowListener(new WindowAdapter() {
				//�����¼�
				@Override
				public void windowClosing(WindowEvent e) {
					System.exit(0);	//����������ֹ
				}
			});
			new paintThread().start();	//���������ػ��߳�
			addKeyListener(new keyControl());	//���Ӽ��̼���
			
			for(int i = 0; i <shell.length; i++) {
					//��ʼ��50���ڵ�
				shell[i] = new GameShell();
			}
		}
		
		@Override
		public void paint(Graphics g) {
			//�Զ�ִ��������ã�gΪ����
			g.drawImage(bg,0,0,null);	//������λ��
			p.drawSelf(g);	//���ɻ�
			
				//����50���ڵ�
			for(int i = 0; i < shell.length; i++) {
				shell[i].drawShell(g);
				//�ڵ���ɻ���ײ
				boolean crash = shell[i].getRect().intersects(p.getRect());
				if(crash) {
					p.state = false;
					if (ge == null) {
						//ֻ����һ������
					ge = new GameExplode(p.x, p.y);	//����ɻ����걬ը
					}
					ge.drawImage(g);	//������ը
				}
			}
		}
		
		public void DoubleBuffer(Graphics g) {
			//˫���弼��������ͼƬ��˸
			if(offScreenImage == null) {
				//����һ������˫����ġ�������Ļ����Ƶ�ͼ��
				offScreenImage = this.createImage(GameConstant.WINDOW_WIDTH
						,GameConstant.WINDOW_HEIGHT);
				//���������Ʊ���ͼ��ʹ�õ�ͼ��������
				Graphics gOff = offScreenImage.getGraphics();
				paint(gOff);	
				g.drawImage(offScreenImage,0,0,null);	//��ͼ
			}
		}
		
		class paintThread extends Thread {
			//�����ػ��߳�
			@Override
			public void run() {
				while(true) {
					repaint();	//�����ػ�����
					try {
						Thread.sleep(40);	//40ms��һ��
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}
		
		class keyControl extends KeyAdapter {
				//���̿���
			@Override
			public void keyPressed(KeyEvent e) {
				//���¼�
				p.PressKey(e);
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				//�ɿ���
				p.LoosenKey(e);
			}
		}
}

