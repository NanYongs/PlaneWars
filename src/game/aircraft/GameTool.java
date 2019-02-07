package game.aircraft;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

public class GameTool {
	//工具类
	private GameTool() {
		
	}
	
	public static Image getImage(String path) {
		BufferedImage bi = null;	//将图片加载到内存对其进行操作
		try {
			//获取资源路径
			URL u = GameTool.class.getClassLoader().getResource(path);
			bi = ImageIO.read(u);	//返回一个 BufferedImage，作为 ImageReader解码所提供 URL 的结果。
		} catch (IOException e) {
			e.printStackTrace();
		}
		return bi;
	}		
}
