package game.aircraft;

import java.awt.Graphics;
import java.awt.Image;

public class GameExplode {
	//加载飞机爆炸图片类
	double x,y;	//爆炸位置
	int count;	//计数
	
	static Image[] image = new Image[16];	//设置static不需要图片反复加载
	
	static {
		for(int i = 0; i < 16; i++) {
			//加载图片
			image[i] = GameTool.getImage("image/explode/e" + (i + 1)
					+ ".gif");
			image[i].getWidth(null);
		}
	}
	
	public void drawImage(Graphics g) {
		//轮流播放16张图片
		if (count <= 15) {
			g.drawImage(image[count],(int)x,(int)y,null);
			count++;
		}
	}
	
	public GameExplode(double x,double y) {
		this.x = x;
		this.y = y;
	}
}
