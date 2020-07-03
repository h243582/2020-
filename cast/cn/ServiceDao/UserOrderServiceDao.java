package cn.ServiceDao;

import java.util.TreeSet;

import cn.VO.CollectForm;

/**
 * ����dao���UserOrder�ӿڵ��û��򶩵�ʵ�ַ�����ӿڣ���factory����
 * 
 * @author ���ŷ�
 *
 * @param <V>
 */
public interface UserOrderServiceDao<V> {
	/**
	 * ���˻���Ϣ׷�ӵ��ļ� <br>
	 * ʹ��UserDAO�ӿ��е�addFile����<br>
	 * 
	 * @param u ����˻�
	 * @return ����Ƿ�ɹ�
	 * @throws Exception ���쳣
	 */
	public boolean append(V u) throws Exception;

	/**
	 * ɾ���ļ��е����û� <br>
	 * ʹ��UserDAO�ӿ��е�remove����<br>
	 * 
	 * @param account ���˺Ų���ɾ���û�
	 * @return ɾ���Ƿ�ɹ�
	 * @throws Exception ���쳣
	 */
	public boolean delete(String account) throws Exception;

	/**
	 * �޸��ǳ� <br>
	 * ʹ��UserDAO�ӿ��е�updateName����<br>
	 * 
	 * @param account �����˺�
	 * @param name    �޸ĺ���ǳ�
	 * @return �޸��Ƿ�ɹ�
	 * @throws Exception ���쳣
	 * 
	 */
	public boolean updateName(String account, String name) throws Exception;

	/**
	 * �޸����� <br>
	 * ʹ��UserDAO�ӿ��е�updatePassword����<br>
	 * 
	 * @param account  �����˺�
	 * @param password �޸ĺ������
	 * @return �޸��Ƿ�ɹ�
	 * @throws Exception ���쳣 ���쳣
	 */
	public boolean updatePassword(String account, String password) throws Exception;

	/**
	 * �޸ĵ绰 <br>
	 * ʹ��UserDAO�ӿ��е�updatePhone����<br>
	 * 
	 * @param account     �����˺�
	 * @param phoneRegion �������
	 * @param phoneNumber ����
	 * @return �޸��Ƿ�ɹ�
	 * @throws Exception ���쳣
	 * 
	 */
	public boolean updatePhone(String account, String phoneRegion, String phoneNumber) throws Exception;

	/**
	 * ע��ʱ�ж��Ƿ����ظ��˺� <br>
	 * ʹ��UserDAO�ӿ��е�repetition����<br>
	 * 
	 * @param account Ҫ�жϵ��˻�
	 * @return �ظ�true; ���ظ�false
	 * @throws Exception ���쳣
	 * 
	 */
	public boolean repetition(String account) throws Exception;

	/**
	 * �˺������Ƿ���� <br>
	 * ʹ��UserDAO�ӿ��е�loginOn����<br>
	 * 
	 * @param account  ��¼ʱ������˺�
	 * @param password ��¼ʱ���������
	 * @return ��¼�Ƿ�ɹ�,�ɹ�����true
	 * @throws Exception ���쳣
	 */
	public boolean loginOn(String account, String password) throws Exception;

	/**
	 * �����˺Ų����û� <br>
	 * ʹ��UserDAO�ӿ��е�findUser����<br>
	 * 
	 * @param account �˺�
	 * @return ��������û�
	 * @throws Exception ���쳣
	 */
	public V findUser(String account) throws Exception;
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
