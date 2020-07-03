package cn.Util;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 * �Զ������������࣬�Դ�����ͼ
 * 
 * @author ���ŷ�
 *
 */
public class MyBackgound extends JPanel {
	private static final long serialVersionUID = 1L;
	private String imgStr;// ͼƬ·��
	private int x;
	private int y;
	private int width;
	private int height;

	/**
	 * �����Զ��屳��������Ļ
	 * @param imgStr ͼƬ·��
	 */
	public MyBackgound(String imgStr) {
		this.imgStr = imgStr;
		this.y = 0;
		this.width = -1;
		this.height = -1;
	}

	/**
	 * �����Զ��屳��λ�ô�С
	 * 
	 * @param imgStr ͼƬ·��
	 * @param x      ������
	 * @param y      ������
	 * @param width  ��
	 * @param height ��
	 */
	public MyBackgound(String imgStr, int x, int y, int width, int height) {
		this.imgStr = imgStr;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}

	public void setBoundh(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}

	@Override
	protected void paintComponent(Graphics g) {
		// int width = this.getWidth();
		// int height = this.getHeight();
		// �����ʾ
		g.clearRect(0, 0, width, height);
		try {
			BufferedImage image = ImageIO.read(new FileInputStream(imgStr));
			//Image image = ImageIO.read(new File(imgStr));
			if (this.width == -1 && this.height == -1) {
				// ռ�������ؼ�
				g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), null);
			} else {
				// �Զ���ͼƬռ����λ��
				g.drawImage(image, x, y, this.width, this.height, null);
			}
		} catch (Exception e) { 
			e.printStackTrace();
		}
	}
}