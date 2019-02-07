package game.aircraft;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;

public class GamePlane extends GameObject{
	//飞机类
	boolean left,up,down,right;	//上下左右
	int speed = 3;	//速度为3
	boolean state = true;	//飞机活着
	
	public void drawSelf(Graphics g) {
		if(state) {
			//飞机没死画飞机
			g.drawImage(image,x,y,null);
			if (left) { x -= speed; }
			if (right) { x += speed; }
			if (down) { y += speed; }
			if (up) { y -= speed; }
		} else {
			
		}

	}
	
	public GamePlane(Image image, int x, int y) {
		//初始化图片坐标
		this.image = image;
		this.x = x;
		this.y = y;
		this.speed = 3;
		this.width = image.getWidth(null);	//获取图片宽高度
		this.height = image.getHeight(null);
	}
	
	public void PressKey(KeyEvent e) {
		//按下键
		switch(e.getKeyCode()) {
		//返回与整数关联的密码
		case KeyEvent.VK_LEFT:
			left = true;	//左键left有效
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
		//松开键
		switch(e.getKeyCode()) {
		case KeyEvent.VK_LEFT:
			left = false;	//左键left失效
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
