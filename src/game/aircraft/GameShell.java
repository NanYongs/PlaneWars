package game.aircraft;

import java.awt.Color;
import java.awt.Graphics;

public class GameShell extends GameObject{
	//炮弹类
	public double radian;	//弧度
	
	public GameShell() {
		//初始化
		 x = 200;
		 y = 200;
		 width = 10;
		 height = 10;
		 speed = 4;
		 radian = Math.random()*Math.PI*2;	//弧度设置随机数0到2π
	}
	
	public void drawShell(Graphics g) {
			//画炮弹
		Color c = g.getColor();	//保存下颜色
		g.setColor(Color.GREEN);	//画笔设置成绿色
		g.fillOval(x, y, width, height);	//画填充圆状炮弹
		g.setColor(c);	//用完还回
		
			//炮弹沿着任意角度飞
		 x += speed*Math.cos(radian);
		 y += speed*Math.sin(radian);
		 
		 if(x < 0 || x > GameConstant.WINDOW_WIDTH-width) {
			 //超出边界,width为炮弹自己的宽度
			 radian = Math.PI-radian;	//X轴翻转，炮弹方向改变
		 }
		 
		 if (y < 30 || y > GameConstant.WINDOW_HEIGHT-height) {
			 //超出边界，30为标题栏高度，height为炮弹自己的高度
			 radian = -radian;	//Y轴翻转，炮弹方向改变
		 }
	}
	
}
