package cn.UI;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import cn.ServiceDaoImpl.FoodServiceDaoImpl;
import cn.ServiceDaoImpl.OrderServiceDaoImpl;
import cn.Util.Constant;
import cn.Util.MyBackgound;
import cn.VO.CollectForm;
import cn.VO.Food;
import cn.VO.Order;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.TreeSet;

/**
 * ����Ա����
 * 
 * @author ���ŷ�
 *
 */
public class SwingUI_Administrator {
	private JButton updateFoodButton;
	private JButton removeFoodButton;
	private JButton addFoodButton;

	private JPanel pTable; // table�������
	private JScrollPane scrollPane;// �������
	private JTable table;// �����
	private DefaultTableModel littleTable; // ����¼С����

	private JPanel pTableOrder;// ���������

	public SwingUI_Administrator() {
		// ����
		Constant.pAdmin = new MyBackgound("cast\\Image\\pLogin.jpg");
		Constant.pAdmin.setBounds(0, 0, Constant.Width, Constant.Heigth);
		Constant.pAdmin.setLayout(null);
		Constant.BOSS.getContentPane().add(Constant.pAdmin);

		// �鿴���ж�����ť
		JButton searchOrderButton = new JButton("�鿴���ж���");
		searchOrderButton.setFont(new Font("��Բ", Font.PLAIN, 28));
		searchOrderButton.setBounds(200, 90, 210, 68);
		Constant.pAdmin.add(searchOrderButton);
		// �鿴���в��װ�ť
		JButton searchFoodButton = new JButton("�鿴���в���");
		searchFoodButton.setFont(new Font("��Բ", Font.PLAIN, 28));
		searchFoodButton.setBounds(200, 209, 210, 68);
		Constant.pAdmin.add(searchFoodButton);
		// �޸Ĳ��װ�ť
		updateFoodButton = new JButton("�޸Ĳ���");
		updateFoodButton.setFont(new Font("��Բ", Font.PLAIN, 28));
		updateFoodButton.setBounds(200, 328, 210, 68);
		Constant.pAdmin.add(updateFoodButton);
		// ɾ�������¼�
		removeFoodButton = new JButton("ɾ������");
		removeFoodButton.setFont(new Font("��Բ", Font.PLAIN, 28));
		removeFoodButton.setBounds(200, 462, 210, 68);
		Constant.pAdmin.add(removeFoodButton);
		// ���Ӳ��װ�ť
		addFoodButton = new JButton("���Ӳ���");
		addFoodButton.setFont(new Font("��Բ", Font.PLAIN, 28));
		addFoodButton.setBounds(200, 591, 210, 68);
		Constant.pAdmin.add(addFoodButton);
		// �������˵���ť
		JButton returnButton = new JButton("�������˵�");
		returnButton.setFont(new Font("��Բ", Font.PLAIN, 28));
		returnButton.setBounds(200, 722, 210, 68);
		Constant.pAdmin.add(returnButton);
		// ��Ԥ���ص�����ʾ
		showAllFood();
		pTable.setVisible(false);
		// �鿴���ж�����ť�¼�
		searchOrderButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				pTable.setVisible(false);
				try {
					pTableOrder.setVisible(false);
					Constant.pAdmin.remove(pTableOrder);
				}catch (Exception ee) {
				}
				showOrders();
				pTableOrder.setVisible(true);
			}
		});
		// �鿴���ױ�ť�¼�
		searchFoodButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					pTableOrder.setVisible(false);
				} catch (Exception e2) {
				}
				pTable.setVisible(true);
			}
		});
		// �޸Ĳ����¼���δ��ʾ����ʱ
		updateFoodButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (!pTable.isVisible())
					JOptionPane.showMessageDialog(null, "������ʾ��Ʒ�˵�");
			}
		});
		// ɾ�������¼���δ��ʾ����ʱ
		removeFoodButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (!pTable.isVisible())
					JOptionPane.showMessageDialog(null, "������ʾ��Ʒ�˵�");
			}
		});
		// ���Ӳ����¼���δ��ʾ����ʱ,���¼�

		// �������˵��¼�
		returnButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Constant.pAdmin.setVisible(false);
				Constant.pMain.setVisible(true);
			}
		});

	}

	/**
	 * ��ʾ�Ҳ��Ʒ��Ͷ�����
	 */
	public void showAllFood() {
		pTable = new MyBackgound("cast\\Image\\pLogin.jpg");

		pTable.setBounds(750, 123, 560, 700);
		Constant.pAdmin.add(pTable);
		pTable.setVisible(false);
		pTable.setLayout(null);
		// ˢ�»��߶�ȡ���ݿ��Ʒ������
		flushFoodTable(1);
		// ˢ�°�ť
		JButton flushButton = new JButton("ˢ��");
		flushButton.setBounds(10, 12, 260, 23);
		pTable.add(flushButton);
		// ��ѯ��Ű�ť
		JButton findButton = new JButton("��ѯ���");
		findButton.setBounds(290, 12, 260, 23);
		pTable.add(findButton);
		// �������
		JButton idSortButton = new JButton("�����");
		idSortButton.setBounds(10, 38, 174, 23);
		pTable.add(idSortButton);
		// ��������
		JButton nameSortButton = new JButton("������");
		nameSortButton.setBounds(192, 38, 174, 23);
		pTable.add(nameSortButton);
		// �۸�����
		JButton priceSortButton = new JButton("���۸�");
		priceSortButton.setBounds(376, 38, 174, 23);
		pTable.add(priceSortButton);
		// ���������ı���
		JTextField text = new JTextField();
		text.setHorizontalAlignment(SwingConstants.RIGHT);
		text.setFont(new Font("��Բ", Font.PLAIN, 20));
		text.setEditable(false);
		text.setBounds(10, 640, 540, 50);
		StringBuilder sb = new StringBuilder();
		sb.append("���Ĳ�Ʒ���� ").append(new FoodServiceDaoImpl().showFood(1).size()).append("��");
		text.setText(sb.toString());
		pTable.add(text);
		
		// �޸����ݰ�ť�¼�������ʾ����ʱ
		updateFoodButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (!pTable.isVisible())
					return;
				int x = table.getSelectedRow();// ��
				int y = table.getSelectedColumn();// ��
				StringBuilder sb = new StringBuilder().append("�������µ� ");
				switch (y) {
				case (-1): {
					// δѡ��Ԫ��
					JOptionPane.showMessageDialog(null, "��ѡ��Ԫ��!", "�밡", JOptionPane.ERROR_MESSAGE);
					return;
				}
				case 0: {
					// ��ֹ�޸ı��
					JOptionPane.showMessageDialog(null, "��ֹ�޸ı��!", "��ֹ", JOptionPane.ERROR_MESSAGE);
					return;

				}
				case 1: {
					sb.append("����");
					break;
				}
				case 2: {
					sb.append("�˵ļ۸�");
					break;
				}
				}
				String strs = JOptionPane.showInputDialog(null, sb.toString());
				if (strs != null) {
					new FoodServiceDaoImpl().update((long) table.getValueAt(x, 0), strs, y);
					table.setValueAt(strs, x, y);
				}
			}
		});
		// ɾ�����ݰ�ť�¼�
		removeFoodButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// �ؼ�δ��ʾʱ�������¼�
				if (!pTable.isVisible())
					return;
				int x = table.getSelectedRow();// ��
				if (x == -1) {
					// δѡ��Ԫ��
					JOptionPane.showMessageDialog(null, "��ѡ����!", "�밡", JOptionPane.ERROR_MESSAGE);
					return;
				}
				long id = (long) table.getValueAt(x, 0);
				StringBuilder sb = new StringBuilder();
				sb.append("��ȷ��Ҫɾ�����Ϊ ").append(id).append("�ģ�").append((String) table.getValueAt(x, 1)).append("����");
				int sel = JOptionPane.showConfirmDialog(null, sb.toString(), "ȷ�ϣ�", JOptionPane.YES_NO_OPTION);
				if (sel == 0) {
					new FoodServiceDaoImpl().delete(id);
					littleTable.removeRow(x);
					JOptionPane.showMessageDialog(null, "ɾ���ɹ�!");
				}
			}
		});
		// ������ݰ�ť�¼�������ʾ����ʱ
		addFoodButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String name = null;
				do {
					name = JOptionPane.showInputDialog(null, "��������Ҫ��ӵĲ�Ʒ�����ƣ�");
					try {
						if (name.equals("")) {
							// ����ȷ����������û����ֵ
							JOptionPane.showMessageDialog(null, "����������", "�밡", JOptionPane.ERROR_MESSAGE);
						} else {
							break;
						}
					} catch (Exception ee) {
						// �׿�ָ���쳣
					}
				} while (name != null);
				// ����۸�Ի���
				String strPrice = null;
				double price = 0;
				while (name != null) {
					strPrice = JOptionPane.showInputDialog(null, "��������Ҫ��ӵĲ�Ʒ�ļ۸�\n\r(����3Ԫ)��",
							JOptionPane.WARNING_MESSAGE);
					if (strPrice == null) {
						// ����ȡ����
						break;
					}
					if (strPrice.equals("")) {
						// ����ȷ����������û����ֵ
						JOptionPane.showMessageDialog(null, "����������", "�밡", JOptionPane.ERROR_MESSAGE);
						continue;
					}
					try {
						price = Double.parseDouble(strPrice);
						break;
					} catch (Exception e3) {
						// ת����ʧ��
						JOptionPane.showMessageDialog(null, "���������ֻ�С��", "�밡", JOptionPane.ERROR_MESSAGE);
						continue;
					}
				}
				if (name != null && !name.equals("") && price != 0)
					new FoodServiceDaoImpl().append(name, price);
			}
		});

		// ˢ�°�ť�¼�
		flushButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				flushFoodTable(1);
			}
		});
		// ID����ť�¼�
		idSortButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				flushFoodTable(1);
			}
		});
		// ��������ť�¼�
		nameSortButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				flushFoodTable(2);
			}
		});
		// �۸�����ť�¼�
		priceSortButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				flushFoodTable(3);
			}
		});

		// ���ұ�Ű�ť�¼�
		findButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});

	}

	/**
	 * ˢ�»���������
	 * 
	 * @param temp Ҫ����ı�ʶ��
	 */
	public void flushFoodTable(int temp) {
		// ɾ��������¼���
		try {
			pTable.remove(scrollPane);
		} catch (Exception e) {
		}
		pTable.setVisible(false);
		// �������
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 67, 540, 573);
		pTable.add(scrollPane);

		// ���
		table = new JTable();
		table.setRowHeight(22);// �����и�
		table.setFont(new Font("��Բ", Font.BOLD, 18));// ��������
		table.setSelectionBackground(Color.GREEN);// ����ѡ�񱳾�ɫ
		table.setSelectionForeground(Color.blue);// ����ѡ������ɫ
		// �������ǩ��
		littleTable = new DefaultTableModel(new Object[][] {}, new String[] { "���", "����", "�۸�" }) {
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
		// ������м�¼���ȵ����ݵ�����
		TreeSet<Food> ts = new FoodServiceDaoImpl().showFood(temp);
		// ȫ����ӵ���������
		for (Food food : ts) {
			littleTable.addRow(new Object[] { food.getId(), food.getName(), food.getPrice() });
		}

		pTable.setVisible(true);

	}

	/**
	 * �������
	 */
	public void showOrders() {
		pTableOrder = new MyBackgound("cast\\Image\\pLogin.jpg");

		pTableOrder.setBounds(650, 123, 700, 695);
		Constant.pAdmin.add(pTableOrder);
		pTableOrder.setVisible(false);
		pTableOrder.setLayout(null);
		// �������
		JScrollPane scrollPaneOrder = new JScrollPane();
		scrollPaneOrder.setBounds(10, 12, 680, 618);
		pTableOrder.add(scrollPaneOrder);
		// ���
		JTable tableOrder = new JTable();
		tableOrder.setRowHeight(22);// �����и�
		tableOrder.setFont(new Font("��Բ", Font.BOLD, 18));// ��������
		tableOrder.setSelectionBackground(Color.GREEN);// ����ѡ�񱳾�ɫ
		tableOrder.setSelectionForeground(Color.blue);// ����ѡ������ɫ
		// �������ǩ��
		littleTable = new DefaultTableModel(new Object[][] {},
				new String[] { "�������", "�����ͻ��˺�", "������ϸ��Ϣ", "�����۸�", "����ʱ��" }) {
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int column) {
				return false;// ����true��ʾ�ܱ༭��false��ʾ���ܱ༭
			}
		};
		tableOrder.setModel(littleTable);
		scrollPaneOrder.setViewportView(tableOrder);
		// ���õ�Ԫ����ж���
		DefaultTableCellRenderer r = new DefaultTableCellRenderer();
		r.setHorizontalAlignment(JLabel.CENTER);
		tableOrder.setDefaultRenderer(Object.class, r);
		// �����ݵ�����
		TreeSet<Order> ts = new OrderServiceDaoImpl().getOrders();
		// ȫ����ӵ���������
		for (Order o : ts) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd:HH:mm");
			littleTable.addRow(new Object[] { o.getOrderId(), o.getUser() == null ? "�ο�" : o.getUser().getAccount(),
					"˫���鿴", o.getSumPrice(), sdf.format(o.getDate()) });
		}
		// ���������ı���
		JTextField text = new JTextField();
		text.setHorizontalAlignment(SwingConstants.RIGHT);
		text.setFont(new Font("��Բ", Font.PLAIN, 20));
		text.setEditable(false);
		text.setBounds(10, 630, 680, 55);
		CollectForm cf = new OrderServiceDaoImpl().getOrdersCollect();
		StringBuilder sb = new StringBuilder();
		sb.append("�ӳ�ʼ���������Ķ�����Ŀ�� ").append(cf.getTsorder().size()).append("��").append(", �ܹ�ӯ����")
				.append(cf.getSumPrices()).append("Ԫ");
		text.setText(sb.toString());
		pTableOrder.add(text);
		// ����е�Ԫ���¼�
		tableOrder.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				//���
				Order o = new OrderServiceDaoImpl().findOrder((long)tableOrder.getValueAt(tableOrder.getSelectedRow(), 0));    
				ArrayList<Food> al = o.getFoods();
				StringBuilder sb = new StringBuilder();
				for (Food f : al) {
					sb.append("\t\t\t���:"+f.getId()+"\t\t\t    ����: "+f.getName()+"\t\t\t     ����: "+f.getPrice()+"\n\r");
				}
				JOptionPane.showMessageDialog(null, sb.toString());			
			}
		} );
	}
}