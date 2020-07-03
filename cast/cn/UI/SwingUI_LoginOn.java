package cn.UI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import cn.ServiceDaoImpl.UserServiceDaoImpl;
import cn.Util.Constant;
import cn.Util.MyBackgound;
import cn.VO.User;
/**
 * ��¼����
 * @author ���ŷ�
 *
 */
public class SwingUI_LoginOn {
	private User user;
	/**
	 * ��¼���湹�췽��
	 * @throws Exception ���쳣
	 */
	public SwingUI_LoginOn() throws Exception {
		// ���ñ���
		Constant.pLogin = new MyBackgound("cast\\Image\\pLogin.jpg");
		Constant.pLogin.setBounds(0, 0, Constant.Width, Constant.Heigth);
		Constant.pLogin.setLayout(null);
		Constant.BOSS.getContentPane().add(Constant.pLogin);
		// �˺������¼��ǩ
		JLabel loginBigLabel = new JLabel("�˺������¼");
		loginBigLabel.setFont(new Font("����", Font.BOLD, 26));
		loginBigLabel.setBackground(Color.WHITE);
		loginBigLabel.setBounds(1149, 216, 193, 32);
		Constant.pLogin.add(loginBigLabel);
		// �˺ű�ǩ
		JLabel accountLabel = new JLabel("�˺�");
		accountLabel.setBackground(Color.WHITE);
		accountLabel.setFont(new Font("��Բ", Font.BOLD, 20));
		accountLabel.setBounds(1076, 298, 60, 50);
		Constant.pLogin.add(accountLabel);
		// �˺��ı���
		JTextField accountTextField = new JTextField();
		accountTextField.setFont(new Font("����", Font.PLAIN, 20));
		accountTextField.setBounds(1136, 303, 260, 40);
		Constant.pLogin.add(accountTextField);
		accountTextField.setColumns(10);
		// �����ǩ
		JLabel pswLabel = new JLabel("����");
		pswLabel.setFont(new Font("��Բ", Font.BOLD, 20));
		pswLabel.setBounds(1076, 365, 60, 50);
		Constant.pLogin.add(pswLabel);
		// �����ı���
		JPasswordField passwordTextField = new JPasswordField();
		passwordTextField.setFont(new Font("����", Font.PLAIN, 20));
		passwordTextField.setBounds(1136, 370, 260, 40);
		Constant.pLogin.add(passwordTextField);
		// ��¼��ť
		JButton loginOnButton = new JButton("��¼");
		loginOnButton.setFont(new Font("��Բ", Font.BOLD, 20));
		loginOnButton.setForeground(Color.WHITE);
		loginOnButton.setBackground(Color.GREEN);
		loginOnButton.setBounds(1076, 435, 320, 40);
		Constant.pLogin.add(loginOnButton);
		// ע�����˺����ӱ�ǩ
		JLabel registerLabel = new JLabel("ע�����˺�");
		registerLabel.setFont(new Font("��Բ", Font.BOLD, 15));
		registerLabel.setBackground(Color.WHITE);
		registerLabel.setBounds(1241, 512, 88, 32);
		Constant.pLogin.add(registerLabel);
		// �м�Ӹ��ָ���
		JSeparator separator = new JSeparator();
		separator.setOrientation(JSeparator.VERTICAL);
		separator.setBounds(1361, 518, 1, 22);
		Constant.pLogin.add(separator);
		// �������������ӱ�ǩ
		JLabel returnLabel = new JLabel("����������");
		returnLabel.setFont(new Font("��Բ", Font.BOLD, 15));
		returnLabel.setBackground(Color.WHITE);
		returnLabel.setBounds(1393, 512, 88, 32);
		Constant.pLogin.add(returnLabel);

		// �ı����������Щ���
		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setBounds(1013, 197, 468, 347);
		Constant.pLogin.add(textArea);
		
		//��¼��ť�����¼�
		loginOnButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// �ж�Ҫ�����˺Ų��� �˺��Ƿ�淶
				String account = accountTextField.getText().trim();
				if (account.matches("")) {
					JOptionPane.showMessageDialog(null, "�������˺�");
					return;
				}
				// �ж�Ҫ��������
				String password = new String(passwordTextField.getPassword());
				if (password.matches("")) {
					JOptionPane.showMessageDialog(null, "����������");
					return;
				}
				//�ж��˺������Ƿ���ȷ
				try {
					if(new UserServiceDaoImpl().loginOn(account,password)) {
						JOptionPane.showMessageDialog(null, "��¼�ɹ���",null, 0, new ImageIcon(Constant.gifGood));
						user = new UserServiceDaoImpl().findUser(account);
						//�򿪽���
						new SwingUI_EatGoGoGo(user);// �Է���ͽ���
						Constant.pLogin.setVisible(false);
						Constant.pEat.setVisible(true);
						return;
					}else {
						JOptionPane.showMessageDialog(null, "�˺Ż�����������������룡","�˺��������",0,new ImageIcon(Constant.gifSed));
						return;
					}
					
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
	
		//�����������¼�
		returnLabel.addMouseListener(new MouseAdapter() {
			//�������ǩ�¼�
			public void mouseClicked(MouseEvent e) {
				int select = JOptionPane.showConfirmDialog(null, "��ȷ��Ҫȡ����¼�� ������������?", "ȷ��", 0, 0, new ImageIcon(Constant.gifReturn));
				// select Ϊ�û���ĵڼ�����ť
				if (select == 0) {
					Constant.pLogin.setVisible(false);
					Constant.pMain.setVisible(true);
				}
			}
			//���������ǩ�¼�
			@Override
			public void mouseEntered(MouseEvent e) {
				returnLabel.setText("<html><u>����������</u><html>");
			}
			//����뿪��ǩ�¼�
			public void mouseExited(MouseEvent e) {
				returnLabel.setText("����������");
			}
		});
		//ע�����˺ű�ǩ�¼�
		registerLabel.addMouseListener(new MouseAdapter() {
			//�����ǩ�¼�
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(null, "����ע���о�ϲӴ~~~",null, 0, new ImageIcon(Constant.gifBoy));
				Constant.pLogin.setVisible(false);
				Constant.pRegister.setVisible(true);
				// ������౳��
				new Thread() {
					@Override
					public void run() {
						// ��1��ͼԤ�Ȼ���
						JPanel pRegisterJPG0 = new MyBackgound("cast\\Image\\pRegister0.jpg", 0, 0, 600, 865);
						pRegisterJPG0.setBounds(0, 0, 600, 865);
						Constant.BOSS.getContentPane().add(pRegisterJPG0);
						// ��2��ͼԤ�Ȼ���
						JPanel pRegisterJPG1 = new MyBackgound("cast\\Image\\pRegister1.jpg", 0, 0, 600, 865);
						pRegisterJPG1.setBounds(0, 0, 600, 865);
						Constant.BOSS.getContentPane().add(pRegisterJPG1);
						// ��3��ͼԤ�Ȼ���
						JPanel pRegisterJPG2 = new MyBackgound("cast\\Image\\pRegister2.jpg", 0, 0, 600, 865);
						pRegisterJPG2.setBounds(0, 0, 600, 865);
						Constant.BOSS.getContentPane().add(pRegisterJPG2);

						// ��ʼ�Զ��л�
						for (int i = 0; Constant.pRegister.isVisible(); i++) {
							switch ((i % 3)) {
							case 0: {
								pRegisterJPG0.setVisible(true);
								pRegisterJPG1.setVisible(false);
								pRegisterJPG2.setVisible(false);
								break;
							}
							case 1: {
								pRegisterJPG0.setVisible(false);
								pRegisterJPG1.setVisible(true);
								pRegisterJPG2.setVisible(false);
								break;
							}
							case 2: {
								pRegisterJPG0.setVisible(false);
								pRegisterJPG1.setVisible(false);
								pRegisterJPG2.setVisible(true);
								break;
							}
							}
							try {
								// �˴�Ϊ�˼��ٽ�����������������߳��ӳ�
								for (int j = 0; j <= 2000; j += 100) {
									sleep(100);
									if (!Constant.pRegister.isVisible()) {
										pRegisterJPG0.setVisible(false);
										pRegisterJPG1.setVisible(false);
										pRegisterJPG2.setVisible(false);
										break;
									}
								}
							} catch (InterruptedException e) {
							}
						}
					}
				}.start();
			}
			//���������ǩ�¼�
			@Override
			public void mouseEntered(MouseEvent e) {
				registerLabel.setText("<html><u>ע�����˺�</u><html>");
			}
			//����뿪��ǩ�¼�
			public void mouseExited(MouseEvent e) {
				registerLabel.setText("ע�����˺�");
			}
		});
	}

}