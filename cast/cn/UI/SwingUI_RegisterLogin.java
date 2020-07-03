package cn.UI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import cn.ServiceDaoImpl.UserServiceDaoImpl;
import cn.Util.Constant;
import cn.VO.User;

/**
 * �û�ע�����
 * 
 * @author ���ŷ�
 *
 */
public class SwingUI_RegisterLogin {
	/**
	 * �û�ע����湹�췽��
	 */
	public SwingUI_RegisterLogin() {
		// �����Ҳ��ı�
		Constant.pRegister = new JPanel();
		Constant.pRegister.setBackground(Color.WHITE);
		Constant.pRegister.setBounds(600, 0, Constant.Width, Constant.Heigth);
		Constant.BOSS.getContentPane().add(Constant.pRegister);
		Constant.pRegister.setLayout(null);
		// �Ӹ�С��ͼ
		JLabel gif = new JLabel();
		gif.setBounds(609, 121, 100, 100);
		gif.setIcon(new ImageIcon("cast\\Image\\11.gif"));
		Constant.pRegister.add(gif);
		// �˺������¼��ǩ1
		JLabel loginBigLabel1 = new JLabel("��ӭע���˻�");
		loginBigLabel1.setFont(new Font("����", Font.BOLD, 50));
		loginBigLabel1.setBackground(Color.WHITE);
		loginBigLabel1.setBounds(231, 68, 357, 100);
		Constant.pRegister.add(loginBigLabel1);
		// �˺������¼��ǩ
		JLabel loginBigLabel2 = new JLabel("ÿһ�죬���ڳԷ�");
		loginBigLabel2.setFont(new Font("����", Font.BOLD, 26));
		loginBigLabel2.setBackground(Color.WHITE);
		loginBigLabel2.setBounds(230, 171, 250, 66);
		Constant.pRegister.add(loginBigLabel2);
		// �ǳƱ�ǩ
		JLabel nameLabel = new JLabel("�ǳ�");
		nameLabel.setFont(new Font("��Բ", Font.BOLD, 20));
		nameLabel.setBackground(Color.WHITE);
		nameLabel.setBounds(252, 278, 60, 50);
		Constant.pRegister.add(nameLabel);
		// �ǳ��ı���
		JTextField nameTextField = new JTextField();
		nameTextField.setFont(new Font("����", Font.PLAIN, 20));
		nameTextField.setColumns(10);
		nameTextField.setBounds(311, 283, 368, 40);
		Constant.pRegister.add(nameTextField);
		// �˺ű�ǩ
		JLabel accountLabel = new JLabel("�˺�");
		accountLabel.setBackground(Color.WHITE);
		accountLabel.setFont(new Font("��Բ", Font.BOLD, 20));
		accountLabel.setBounds(252, 333, 60, 50);
		Constant.pRegister.add(accountLabel);
		// �˺��ı���
		JTextField accountTextField = new JTextField();
		accountTextField.setFont(new Font("����", Font.PLAIN, 20));
		accountTextField.setBounds(311, 338, 368, 40);
		Constant.pRegister.add(accountTextField);
		accountTextField.setColumns(10);
		// �����ǩ
		JLabel passwordLabel = new JLabel("����");
		passwordLabel.setFont(new Font("��Բ", Font.BOLD, 20));
		passwordLabel.setBounds(252, 393, 60, 50);
		Constant.pRegister.add(passwordLabel);
		// �����ı���
		JPasswordField passwordTextField = new JPasswordField();
		passwordTextField.setFont(new Font("����", Font.PLAIN, 20));
		passwordTextField.setBounds(311, 398, 368, 40);
		Constant.pRegister.add(passwordTextField);
		// ע�ᰴť
		JButton loginOnButton = new JButton("����ע��");
		loginOnButton.setFont(new Font("��Բ", Font.BOLD, 20));
		loginOnButton.setForeground(Color.WHITE);
		loginOnButton.setBackground(Color.BLUE);
		loginOnButton.setBounds(251, 532, 428, 50);
		Constant.pRegister.add(loginOnButton);
		// �м�Ӹ��ָ���
		JSeparator separator = new JSeparator();
		separator.setOrientation(JSeparator.VERTICAL);
		separator.setBounds(616, 685, 1, 22);
		Constant.pRegister.add(separator);
		// �������������ӱ�ǩ
		JLabel returnLabel = new JLabel("����������");
		returnLabel.setFont(new Font("��Բ", Font.BOLD, 15));
		returnLabel.setBackground(Color.WHITE);
		returnLabel.setBounds(645, 675, 88, 32);
		Constant.pRegister.add(returnLabel);

		// �ֻ��ű�ǩ
		JLabel phoneLabel = new JLabel("�ֻ���");
		phoneLabel.setFont(new Font("��Բ", Font.BOLD, 20));
		phoneLabel.setBackground(Color.WHITE);
		phoneLabel.setBounds(361, 451, 70, 50);
		Constant.pRegister.add(phoneLabel);
		// �ֻ����ı���
		JTextField phoneTextField = new JTextField();
		phoneTextField.setFont(new Font("����", Font.PLAIN, 20));
		phoneTextField.setColumns(10);
		phoneTextField.setBounds(429, 456, 250, 40);
		Constant.pRegister.add(phoneTextField);
		// �ֻ��ŵ�������ѡ�
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setBackground(Color.WHITE);
		comboBox.setFont(new Font("��Բ", Font.BOLD, 20));
		comboBox.setModel(new DefaultComboBoxModel<String>(new String[] { "+86", "+852", "+853", "+886" }));
		comboBox.setBounds(251, 456, 100, 40);
		Constant.pRegister.add(comboBox);
		// ��ѡ��Ҫѡ����
		JCheckBox CheckBox = new JCheckBox("�����Ķ���ͬ����ط����������˽����");
		CheckBox.setBackground(Color.WHITE);
		CheckBox.setBounds(252, 605, 264, 23);
		Constant.pRegister.add(CheckBox);

		JLabel functionLabel = new JLabel("Copyright  1998-2020Tencent All Rights Reserved");
		functionLabel.setBounds(293, 805, 386, 22);
		Constant.pRegister.add(functionLabel);

		// ��ע�ᰴť�����¼�
		loginOnButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// �ж�Ҫ�����ǳ�
				String name = nameTextField.getText().trim();
				if (!name.matches(".{1,20}")) {
					JOptionPane.showMessageDialog(null, "�������ǳ�(��󳤶�20)");
					return;
				}
				// �ж�Ҫ�����˺Ų��� �˺��Ƿ�淶
				String account = accountTextField.getText().trim();
				if (account.matches("")) {
					JOptionPane.showMessageDialog(null, "�������˺�");
					return;
				} else if (!account.matches("[a-zA-Z]{1}[\\w]{5,9}")) {
					JOptionPane.showMessageDialog(null, "�˺ſ�ͷ��������ĸ�ҳ���6-10");
					return;
				}
				// �ж��˺��Ƿ��Ѵ���
				try {
					if (new UserServiceDaoImpl().repetition(account)) {
						JOptionPane.showMessageDialog(null, "�˺��Ѵ���");
						accountTextField.requestFocus();
						return;
					}
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				// �ж�Ҫ��������
				String password = new String(passwordTextField.getPassword());
				if (password.matches("")) {
					JOptionPane.showMessageDialog(null, "����������");
					return;
				}
				// �ж��ֻ���
				String phoneNumber = phoneTextField.getText().trim();
				if (!phoneNumber.matches("\\d{11}")) {
					JOptionPane.showMessageDialog(null, "��������ȷ���ֻ���");
					return;
				}
				// �����ѡ��û���ͳ�����ʾ��
				if (!CheckBox.isSelected()) {
					JOptionPane.showMessageDialog(null, "�빴ѡ�����Ķ�Э��");
					return;
				}
				// ������ȫ������,��ʼд�뵽�ļ�
				User u = new User(name, account, password, (String) comboBox.getSelectedItem(), phoneNumber);
				try {
					new UserServiceDaoImpl().append(u);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				JOptionPane.showMessageDialog(null, "��ϲ����ע��ɹ��� ", "��ϲ��ϲ", 0, new ImageIcon(Constant.gifGood));
				Constant.pRegister.setVisible(false);
				Constant.pLogin.setVisible(true);
			}
		});
		// �����������¼�
		returnLabel.addMouseListener(new MouseAdapter() {
			// �������ǩ�¼�
			public void mouseClicked(MouseEvent e) {
				int select = JOptionPane.showConfirmDialog(null, "��ȷ��Ҫȡ��ע�Ტ ������������?", "ȷ��", 0, 0,
						new ImageIcon(Constant.gifReturn));
				// select Ϊ�û���ĵڼ�����ť
				if (select == 0) {
					Constant.pRegister.setVisible(false);
					Constant.pMain.setVisible(true);
				}
			}

			// ���������ǩ�¼�
			@Override
			public void mouseEntered(MouseEvent e) {
				returnLabel.setText("<html><u>����������</u><html>");
			}

			// ����뿪�¼�
			public void mouseExited(MouseEvent e) {
				returnLabel.setText("����������");
			}
		});

	}

}
