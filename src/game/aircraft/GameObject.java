package game.aircraft;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

public class GameObject {
	//游戏物体的父类，简化子类
	public Image image;
	public int x,y;
	public int speed;
	public int width,height;
	
	public void drawSelf(Graphics g) {
		//画自己
		g.drawImage(image,x,y,null);
	}
	
		//三个构造器方便子类初始化
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
		//返回物体所在矩形便于后续碰撞检测
		return new Rectangle(x, y, width, height);
	}
}
