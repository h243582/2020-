package cn.Util;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * ��̬����������
 * 
 * @author ���ŷ�
 *
 */
public class Constant {
	public static final String File = "cast\\configuration\\User.txt"; // �û�txt�ļ������ַ
	public static final String OrderId = "cast\\configuration\\OrderId.txt"; //�Զ����ɶ�����txt�ļ���ַ
	public static final String Order = "cast\\configuration\\Order.txt"; //�����ļ������ַ

	public static final int Width = 1540; // �涨���泤
	public static final int Heigth = 870; // �涨�����
	public static final String gifBoy = "cast\\Image\\GifBoy.gif"; 
	public static final String gifExit = "cast\\Image\\GifExit.gif";//�˳�ʱ
	public static final String gifBuy = "cast\\Image\\GifBuy.png"; //����ʱ
	public static final String gifGood = "cast\\Image\\GifGood.jpg"; //ע��ɹ�
	public static final String gifSed = "cast\\Image\\GifSed.gif"; //����ʱ
	public static final String gifReturn = "cast\\Image\\GifReturn.gif"; //����ʱ


	public static JFrame BOSS = new JFrame(); // ϵͳ������
	public static JPanel pMain; // ������
	public static JPanel pLogin;// ϵͳ��¼����
	public static JPanel pRegister;// ϵͳע�����
	public static JPanel pEat;// ϵͳ�Է�����
	public static JPanel pAdmin;// ����Ա����

	public static String Administrator = "123";// ϵͳϵͳ����Ա


	public static final String DBDRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	public static final String DBURL = "jdbc:sqlserver://;DataBaseName=2020�γ����";// ָ�����ݿ�
	public static final String DBUSER = "sa"; // �����û���
	public static final String PASSWORD = "123";// ����
}
