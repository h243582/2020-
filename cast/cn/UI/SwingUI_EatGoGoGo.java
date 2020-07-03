package cn.UI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.TreeSet;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import cn.ServiceDaoImpl.FoodServiceDaoImpl;
import cn.ServiceDaoImpl.OrderServiceDaoImpl;
import cn.Util.Constant;
import cn.Util.MyBackgound;
import cn.VO.Food;
import cn.VO.Order;
import cn.VO.User;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 * �Է���ͽ���
 * 
 * @author ���ŷ�
 *
 */
public class SwingUI_EatGoGoGo {
	private User user;

	public SwingUI_EatGoGoGo(User user) {
		this.user = user;
		// ���ñ���
		Constant.pEat = new MyBackgound("cast\\Image\\pEatGoGoGo.jpg");
		Constant.pEat.setBounds(0, 0, Constant.Width, Constant.Heigth);
		Constant.pEat.setLayout(null);
		Constant.BOSS.getContentPane().add(Constant.pEat);
		// ��Ʒ���ǩ
		JLabel loginBigLabel1 = new JLabel("��ѡ����Ҫ��Ĳ�ƷӴ ~ ");
		loginBigLabel1.setForeground(Color.MAGENTA);
		loginBigLabel1.setFont(new Font("��Բ", Font.BOLD, 50));
		loginBigLabel1.setBounds(49, 30, 660, 100);
		Constant.pEat.add(loginBigLabel1);
		// �������
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(164, 136, 545, 635);
		Constant.pEat.add(scrollPane);
		// �������
		JTable table = new JTable();
		table.setRowHeight(22);// �����и�
		table.setFont(new Font("��Բ", Font.BOLD, 18));// ��������
		table.setSelectionBackground(Color.GREEN);// ����ѡ�񱳾�ɫ
		table.setSelectionForeground(Color.blue);// ����ѡ������ɫ
		// ����ǩ
		DefaultTableModel littleTable = new DefaultTableModel(new Object[][] {}, new String[] { "���", "����", "�۸�" }) {
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int column) {
				return false;// ����true��ʾ�ܱ༭��false��ʾ���ܱ༭
			}
		};
		table.setModel(littleTable);
		scrollPane.setViewportView(table);
		// ���õ�Ԫ����ж���
		DefaultTableCellRenderer r = new DefaultTableCellRenderer();
		r.setHorizontalAlignment(JLabel.CENTER);
		table.setDefaultRenderer(Object.class, r);
		// ������м�¼���ȵ�����
		TreeSet<Food> al = new FoodServiceDaoImpl().showFood(1);
		// ȫ����ӵ���������
		for (Food objFood : al) {
			littleTable.addRow(new Object[] { objFood.getId(), objFood.getName(), objFood.getPrice() });
		}
		// ���빺�ﳵ��ť
		JButton eatButton = new JButton("���빺�ﳵ");
		eatButton.setFont(new Font("��Բ", Font.PLAIN, 16));
		eatButton.setBounds(164, 781, 545, 23);
		Constant.pEat.add(eatButton);
		// �ı����������Щ���
		JTextArea Area = new JTextArea();
		Area.setEditable(false);
		Area.setBounds(155, 125, 564, 688);
		Constant.pEat.add(Area);

		// ���ѵ�Ĳ˵�����ǩ
		JLabel loginBigLabel2 = new JLabel("���ѵ�Ĳ˵���");
		loginBigLabel2.setForeground(Color.MAGENTA);
		loginBigLabel2.setFont(new Font("��Բ", Font.BOLD, 50));
		loginBigLabel2.setBounds(770, 159, 546, 100);
		Constant.pEat.add(loginBigLabel2);
		// �������
		JScrollPane scrollPane2 = new JScrollPane();
		scrollPane2.setBounds(790, 280, 406, 491);
		Constant.pEat.add(scrollPane2);
		// �������
		JTable table2 = new JTable();
		table2.setRowHeight(22);// �����и�
		table2.setFont(new Font("��Բ", Font.BOLD, 18));// ��������
		table2.setSelectionBackground(Color.GREEN);// ����ѡ�񱳾�ɫ
		table2.setSelectionForeground(Color.blue);// ����ѡ������ɫ
		// ���shux
		DefaultTableModel littleTable2 = new DefaultTableModel(new Object[][] {}, new String[] { "���", "����", "�۸�" }) {
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int column) {
				return false;// ����true��ʾ�ܱ༭��false��ʾ���ܱ༭
			}
		};
		table2.setModel(littleTable2);
		scrollPane2.setViewportView(table2);
		// ���õ�Ԫ����ж���
		DefaultTableCellRenderer r2 = new DefaultTableCellRenderer();
		r2.setHorizontalAlignment(JLabel.CENTER);
		table2.setDefaultRenderer(Object.class, r2);
		// ɾ�����ﳵ��ĳЩ��
		JButton removeButton = new JButton("ɾ����");
		removeButton.setFont(new Font("��Բ", Font.PLAIN, 16));
		removeButton.setBounds(790, 781, 406, 24);
		Constant.pEat.add(removeButton);
		// �ı�����Ҳ���Щ���
		JTextArea Area_1 = new JTextArea();
		Area_1.setEditable(false);
		Area_1.setBounds(780, 269, 428, 544);
		Constant.pEat.add(Area_1);

		// ��ӭ�˻���ǩ
		StringBuilder sb = new StringBuilder();
		if (user != null) {
			sb.append("��ӭ����~ ").append(user.getName());
		} else {
			sb.append("����Ǹ��ο�Ӵ~");
		}
		JLabel meLabel = new JLabel(sb.toString());
		meLabel.setForeground(Color.BLUE);
		meLabel.setFont(new Font("��Բ", Font.BOLD, 32));
		meLabel.setBounds(1237, 64, 289, 70);
		Constant.pEat.add(meLabel);
		// ȷ������ť
		JButton SureButton = new JButton("ȷ������");
		SureButton.setFont(new Font("��Բ", Font.BOLD, 20));
		// SureButton.setForeground(Color.WHITE);
		// SureButton.setBackground(Color.RED);
		SureButton.setBounds(1253, 331, 177, 45);
		Constant.pEat.add(SureButton);
		// ���������水ť
		JButton returnButton = new JButton("����������");
		// returnButton.setForeground(Color.WHITE);
		returnButton.setFont(new Font("��Բ", Font.BOLD, 20));
		// returnButton.setBackground(Color.BLUE);
		returnButton.setBounds(1253, 496, 177, 45);
		Constant.pEat.add(returnButton);
		// �˳�ϵͳ
		JButton exitButton = new JButton("�˳�ϵͳ");
		// exitButton.setForeground(Color.WHITE);
		exitButton.setFont(new Font("��Բ", Font.BOLD, 20));
		// exitButton.setBackground(Color.BLUE);
		exitButton.setBounds(1253, 673, 177, 45);
		Constant.pEat.add(exitButton);

		// ���빺�ﳵ�¼�
		eatButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int[] rows = table.getSelectedRows();// ��ȡѡ����һ�л����
				if (rows.length < 0) {
					return;
				}

				for (int i : rows) {
					Food fd = new Food((long) table.getValueAt(i, 0), (String) table.getValueAt(i, 1),
							(double) table.getValueAt(i, 2));
					littleTable2.addRow(new Object[] { fd.getId(), fd.getName(), fd.getPrice() });
				}
			}
		});
		// ɾ�����ﳵ��ĳЩ��
		removeButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int[] rows = table2.getSelectedRows();// ��ȡѡ����һ�л����
				if (rows.length < 0) {
					return;
				}
				// ��������Ӹ��м��������Ϊÿ��ɾ���У�������л����ƣ������Ҿ�ÿɾ��һ�У��Ҿ�Ҫ����� 1
				int temp = 0;
				for (int rowi : rows) {
					littleTable2.removeRow(rowi - temp);
					temp++;
				}
			}
		});
		// ��ȷ�϶�����ť����¼�
		SureButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				long i = table2.getRowCount();
				float sum = 0;
				ArrayList<Food> al = new ArrayList<Food>();
				for (int x = 0; x < i; x++) {
					Food f = new FoodServiceDaoImpl().find((long) table2.getValueAt(x, 0));
					if (user == null) {
						f.setPrice(f.getPrice() * 0.7);
					}
					sum += f.getPrice();
					al.add(f);
				}
				StringBuilder sb = new StringBuilder();
				// ����Ǹ��ο�
				if (user == null) {
					sb.append("һ���ǣ�");
				} else {
					sb.append("��������ݵ���Ӵ��������7��~\n\rһ���ǣ�");
				}
				sb.append(String.valueOf(sum)).append("Ԫ,\n\r").append("�Ƿ�ȷ�Ϲ���?");
				int select = JOptionPane.showConfirmDialog(null, sb.toString(), "ȷ��", 0, 0,
						new ImageIcon(Constant.gifBuy));
				// select Ϊ�û���ĵڼ�����ť
				if (select == 0) {
					JOptionPane.showMessageDialog(null, "����ɹ������ȷ���˳����������档", null, 0, new ImageIcon(Constant.gifBuy));
					// д���ļ�
						// ����Ǹ��ο�//�Ǹ�����ݵ���
						try {
							new OrderServiceDaoImpl().append(new Order(user, al));
						} catch (Exception e1) {
					}
					Constant.pEat.setVisible(false);
					Constant.pMain.setVisible(true);
				}
			}
		});
		// �����������¼�
		returnButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int select = JOptionPane.showConfirmDialog(null, "��ȷ��Ҫȡ������ ������������?", "ȷ��", 0, 0,
						new ImageIcon(Constant.gifReturn));
				// select Ϊ�û���ĵڼ�����ť
				if (select == 0) {
					Constant.pEat.setVisible(false);
					Constant.pMain.setVisible(true);
				}
			}
		});
		// �˳��¼�
		exitButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int select = JOptionPane.showConfirmDialog(null, "��ȷ��Ҫȡ������ �˳�ϵͳ��?", "ȷ��", 0, 0,
						new ImageIcon(Constant.gifExit));
				// select Ϊ�û���ĵڼ�����ť
				if (select == 0) {
					System.exit(0);
				}
			}
		});
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}