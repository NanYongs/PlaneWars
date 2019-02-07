package game.aircraft;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;

public class GamePlane extends GameObject{
	//�ɻ���
	boolean left,up,down,right;	//��������
	int speed = 3;	//�ٶ�Ϊ3
	boolean state = true;	//�ɻ�����
	
	public void drawSelf(Graphics g) {
		if(state) {
			//�ɻ�û�����ɻ�
			g.drawImage(image,x,y,null);
			if (left) { x -= speed; }
			if (right) { x += speed; }
			if (down) { y += speed; }
			if (up) { y -= speed; }
		} else {
			
		}

	}
	
	public GamePlane(Image image, int x, int y) {
		//��ʼ��ͼƬ����
		this.image = image;
		this.x = x;
		this.y = y;
		this.speed = 3;
		this.width = image.getWidth(null);	//��ȡͼƬ��߶�
		this.height = image.getHeight(null);
	}
	
	public void PressKey(KeyEvent e) {
		//���¼�
		switch(e.getKeyCode()) {
		//��������������������
		case KeyEvent.VK_LEFT:
			left = true;	//���left��Ч
			break;
			
		case KeyEvent.VK_UP:
			up = true;
			break;
			
		case KeyEvent.VK_RIGHT:
			right = true;
			break;
			
		case KeyEvent.VK_DOWN:
			down = true;
			break;
		}
	}
	
	public void LoosenKey(KeyEvent e) {
		//�ɿ���
		switch(e.getKeyCode()) {
		case KeyEvent.VK_LEFT:
			left = false;	//���leftʧЧ
			break;
			
		case KeyEvent.VK_RIGHT:
			right = false;	
			break;
			
		case KeyEvent.VK_DOWN:
			down = false;	
			break;
			
		case KeyEvent.VK_UP:
			up = false;	
			break;
		}
	}
}
