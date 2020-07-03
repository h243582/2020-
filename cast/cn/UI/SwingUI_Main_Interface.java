package cn.UI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import cn.Util.Constant;
import cn.Util.MyBackgound;

/**
 * �ǽ���ϵͳ��������
 * 
 * @author ���ŷ�
 *
 */
public class SwingUI_Main_Interface {
	public SwingUI_Main_Interface() {
		Constant.pMain = new MyBackgound("cast/Image/pMainPlane.jpg");
		Constant.pMain.setBounds(0, 0, Constant.Width, Constant.Heigth);
		Constant.pMain.setLayout(null);
		Constant.BOSS.getContentPane().add(Constant.pMain);

		// ��¼ϵͳ��ť
		JButton loginButton = new JButton("��¼ϵͳ");
		loginButton.setForeground(Color.WHITE);
		loginButton.setBackground(Color.BLACK);
		loginButton.setFont(new Font("��Բ", Font.BOLD, 22));
		loginButton.setBounds(380, 640, 150, 60);
		Constant.pMain.add(loginButton);
		// �ο͵�¼��ť
		JButton intoButton = new JButton("�ο͵�¼");
		intoButton.setBackground(Color.BLACK);
		intoButton.setForeground(Color.WHITE);
		intoButton.setFont(new Font("��Բ", Font.BOLD, 22));
		intoButton.setBounds(700, 640, 150, 60);
		Constant.pMain.add(intoButton);
		// �˳�ϵͳ��ť
		JButton closeButton = new JButton("�˳�ϵͳ");
		closeButton.setForeground(Color.WHITE);
		closeButton.setBackground(Color.BLACK);
		closeButton.setFont(new Font("��Բ", Font.BOLD, 22));
		closeButton.setBounds(1020, 640, 150, 60);
		Constant.pMain.add(closeButton);
		// �������Ա����
		JButton Administrator = new JButton("����Ա");
		Administrator.setForeground(Color.WHITE);
		Administrator.setFont(new Font("��Բ", Font.BOLD, 12));
		Administrator.setBackground(Color.BLACK);
		Administrator.setBounds(1468, 840, 70, 25);
		Constant.pMain.add(Administrator);
		// ��¼ϵͳ�¼�
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Constant.pMain.setVisible(false);
				Constant.pLogin.setVisible(true);
				// login();
			}
		});
		// �ο͵�¼�¼�
		intoButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int select = JOptionPane.showConfirmDialog(null, "�Ƿ�ȷ��ʹ���ο͵�¼?", "ȷ��", 0, 0,
						new ImageIcon(Constant.gifBoy));

				// select Ϊ�û���ĵڼ�����ť
				if (select == 0) {
					new SwingUI_EatGoGoGo(null);
					Constant.pMain.setVisible(false);
					// Constant.pEat.setVisible(true);
				}
			}
		});
		// ����Ա��ť�����¼�
		Administrator.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String password;
				do {
				password = JOptionPane.showInputDialog(null, "��������Ĺ���Ա����", "0000");
				if (password != null) {
					try {
						//ʹ�������ļ��õ���ȷ������
						Properties prop = new Properties();
						InputStream inputStream = new FileInputStream("cast\\configuration\\AdministratorPassword.properties");
						prop.load(inputStream);
						inputStream.close();
						//���ݼ���ȡֵ,�ж������Ƿ���ȷ
						if(password.equals(prop.getProperty("Administrator"))) {
							//�������Ա����
							JOptionPane.showMessageDialog(null,"������ȷӴ~~~~~~~");
							Constant.pMain.setVisible(false);
							Constant.pAdmin.setVisible(true);
							break;
						}else {
							JOptionPane.showMessageDialog(null,"����������������룡","����", 0);
						}

					} catch (Exception e2) {
					}
				}else {
					break;
				}
				}while(password!=null);
			}
		});

		// �˳�ϵͳ�¼�
		closeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int select = JOptionPane.showConfirmDialog(null, "�Ƿ�ȷ���˳�ϵͳ?", "ȷ��", 0, 0,
						new ImageIcon(Constant.gifExit));
				// select Ϊ�û���ĵڼ�����ť
				if (select == 0) {
					System.exit(0);
				}
			}
		});
	}

}