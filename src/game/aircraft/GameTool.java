package game.aircraft;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

public class GameTool {
	//������
	private GameTool() {
		
	}
	
	public static Image getImage(String path) {
		BufferedImage bi = null;	//��ͼƬ���ص��ڴ������в���
		try {
			//��ȡ��Դ·��
			URL u = GameTool.class.getClassLoader().getResource(path);
			bi = ImageIO.read(u);	//����һ�� BufferedImage����Ϊ ImageReader�������ṩ URL �Ľ����
		} catch (IOException e) {
			e.printStackTrace();
		}
		return bi;
	}		
}
