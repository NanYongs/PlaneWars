package game.aircraft;

import java.awt.Color;
import java.awt.Graphics;

public class GameShell extends GameObject{
	//�ڵ���
	public double radian;	//����
	
	public GameShell() {
		//��ʼ��
		 x = 200;
		 y = 200;
		 width = 10;
		 height = 10;
		 speed = 4;
		 radian = Math.random()*Math.PI*2;	//�������������0��2��
	}
	
	public void drawShell(Graphics g) {
			//���ڵ�
		Color c = g.getColor();	//��������ɫ
		g.setColor(Color.GREEN);	//�������ó���ɫ
		g.fillOval(x, y, width, height);	//�����Բ״�ڵ�
		g.setColor(c);	//���껹��
		
			//�ڵ���������Ƕȷ�
		 x += speed*Math.cos(radian);
		 y += speed*Math.sin(radian);
		 
		 if(x < 0 || x > GameConstant.WINDOW_WIDTH-width) {
			 //�����߽�,widthΪ�ڵ��Լ��Ŀ��
			 radian = Math.PI-radian;	//X�ᷭת���ڵ�����ı�
		 }
		 
		 if (y < 30 || y > GameConstant.WINDOW_HEIGHT-height) {
			 //�����߽磬30Ϊ�������߶ȣ�heightΪ�ڵ��Լ��ĸ߶�
			 radian = -radian;	//Y�ᷭת���ڵ�����ı�
		 }
	}
	
}
