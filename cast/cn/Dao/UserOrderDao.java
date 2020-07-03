package cn.Dao;

import java.util.ArrayList;
import java.util.TreeSet;

import cn.VO.CollectForm;

/**
 * �û������������ӿ�
 * @author ���ŷ�
 *
 * @param <V> �����Ķ���
 */
public interface UserOrderDao<V> {
	/**
	 * ��V������Ϣ׷�ӵ��ļ�
	 * ������FileInputStream(�ļ���,true)��ͬһ���ļ������л�����ÿ�ζ������ļ������л�һ��header���ڷ����л���ʱ��ÿ��
	 * ObjectInputStream ����ֻ���ȡһ��header �˴���дwriteStreamHeader����
	 * @param u Ҫд��Ķ���
	 * @return ����Ƿ�ɹ�
	 * @throws Exception ���쳣
	 */
	public boolean addFile(V u) throws Exception;
	/**
	 * ����ʽ ������ʽ���V����
	 * @return ����Ƿ�ɹ�
	 * @param list Ҫ��ӵ�V����
	 * @throws Exception ���쳣
	 */
	public boolean addAll(ArrayList<V> list) throws Exception;
	/**
	 * ���
	 * @throws Exception ���쳣
	 */
	public void showAll() throws Exception;
	/**
	 * ɾ���ļ��е����û�
	 * 
	 * @param account ���˺Ų���ɾ���û�
	 * @return ɾ���Ƿ�ɹ�
	 * @throws Exception ���쳣
	 */
	public boolean remove(String account) throws Exception;
	/**
	 * �޸��ǳ�
	 * @param account �����˺�
	 * @param name �޸ĺ���ǳ�
	 * @return �޸��Ƿ�ɹ�
	 * @throws Exception ���쳣
	 */
	public boolean updateName(String account,String name)throws Exception;
	/**
	 * �޸�����
	 * @param account �����˺�
	 * @param password �޸ĺ������
	 * @return �޸��Ƿ�ɹ�
	 * @throws Exception ���쳣
	 */
	public boolean updatePassword(String account,String password)throws Exception;
	/**
	 * �޸ĵ绰
	 * @param account �����˺�
	 * @param phoneRegion �������
	 * @param phoneNumber ����
	 * @return �޸��Ƿ�ɹ�
	 * @throws Exception ���쳣
	 */
	public boolean updatePhone(String account,String phoneRegion,String phoneNumber)throws Exception;
 
	/**
	 * ������˱��VIP
	 * 
	 * @param account �˺�
	 * @param vip vip
	 * @return �޸��Ƿ�ɹ�
	 */
	public boolean updateVIP(String account,boolean vip)throws Exception;
	/**
	 * ע��ʱ�ж��Ƿ����ظ��˺�
	 * @param account Ҫ�жϵ��˻�
	 * @return �ظ�true; ���ظ�false
	 * @throws Exception ���쳣
	 */
	public boolean repetition(String account) throws Exception;
	/**
	 * �˺������Ƿ����
	 * @param account ��¼ʱ������˺�
	 * @param password ��¼ʱ���������
	 * @return ��¼�Ƿ�ɹ�,�ɹ�����true
	 * @throws Exception ���쳣
	 */
	public boolean loginOn(String account,String password)throws Exception;
	/**
	 * �����˺Ų����û�
	 * @param account �˺�
	 * @return ��������û�
	 * @throws Exception ���쳣
	 */
	public V findUser(String account)throws Exception;
	
	/**
	 * �Զ�����ȡ����id
	 * @return ������
	 */
	public long getOrderId();
	/**
	 * ���ļ��ж�ȡ�õ�����V������Ϣ
	 * @return ����V����ļ���
	 */
	public TreeSet<V> getOrders();
	/**
	 * �õ�һ�����ܱ�
	 * @return ���ػ��ܱ�
	 */
	public CollectForm getOrdersCollect(); 
	/**
	 * ���ݵ��Ų��Ҷ���
	 * @param orderId ����
	 * @return ���ض���
	 */
	public V findOrder(long orderId);
}
