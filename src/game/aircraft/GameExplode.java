package game.aircraft;

import java.awt.Graphics;
import java.awt.Image;

public class GameExplode {
	//���طɻ���ըͼƬ��
	double x,y;	//��ըλ��
	int count;	//����
	
	static Image[] image = new Image[16];	//����static����ҪͼƬ��������
	
	static {
		for(int i = 0; i < 16; i++) {
			//����ͼƬ
			image[i] = GameTool.getImage("image/explode/e" + (i + 1)
					+ ".gif");
			image[i].getWidth(null);
		}
	}
	
	public void drawImage(Graphics g) {
		//��������16��ͼƬ
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
