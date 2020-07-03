package cn.Factory;

import java.awt.EventQueue;
import java.io.IOException;
import cn.UI.SwingUI_Main;

/**
 * UI����Ĺ�����
 * @author ���ŷ�
 *
 */
public class UIFactory {
	public void runUI() throws IOException {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new SwingUI_Main();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
