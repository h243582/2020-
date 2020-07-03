package cn.UI;
import javax.swing.JFrame;
import cn.Util.Constant;
/**
 * ��������������ʹ����������
 * @author ���ŷ�
 *
 */
public class SwingUI_Main   {
	/**
	 * ��������������ʹ�������������췽��
	 * @throws Exception ���쳣
	 */
	public SwingUI_Main() throws Exception {
		Constant.BOSS.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Constant.BOSS.setSize(Constant.Width, Constant.Heigth);
		Constant.BOSS.setTitle("�γ����");
		Constant.BOSS.getContentPane().setLayout(null);
		fullScreen();// ȫ��
		
		new SwingUI_Main_Interface();// Ԥ����������
		new SwingUI_LoginOn(); // Ԥ���ص�¼����
		new SwingUI_RegisterLogin();// ע�����
		//new SwingUI_EatGoGoGo();// �Է���ͽ���
		new SwingUI_Administrator(); //����Ա����
		//��ֻ��ʾ����ϵͳ����
		Constant.BOSS.setVisible(true);
		Constant.pMain.setVisible(true);
		Constant.pLogin.setVisible(false);
		Constant.pRegister.setVisible(false);
		Constant.pAdmin.setVisible(false);
		//Constant.pEat.setVisible(false);
	}
	/**
	 * ����ȫ��
	 */
	public void fullScreen() {
		Constant.BOSS.setUndecorated(true);// ȥ���߿�
		Constant.BOSS.setExtendedState(JFrame.MAXIMIZED_BOTH); // ���
		// this.setAlwaysOnTop(true); // ������ǰ��
		Constant.BOSS.setResizable(false); // ���ܸı��С
	}
}