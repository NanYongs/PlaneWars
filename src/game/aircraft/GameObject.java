package game.aircraft;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

public class GameObject {
	//��Ϸ����ĸ��࣬������
	public Image image;
	public int x,y;
	public int speed;
	public int width,height;
	
	public void drawSelf(Graphics g) {
		//���Լ�
		g.drawImage(image,x,y,null);
	}
	
		//�������������������ʼ��
	public GameObject() {
	}
	
	public GameObject(Image image, int x, int y,
			 int speed, int width, int height) {
		this.image = image;
		this.x = x;
		this.y = y;
		this.speed = speed;
		this.width = width;
		this.height = height;
	}
	
	public GameObject(Image image, int x, int y) {
		this.image = image;
		this.x = x;
		this.y = y;
	}
	
	public Rectangle getRect() {
		//�����������ھ��α��ں�����ײ���
		return new Rectangle(x, y, width, height);
	}
}
