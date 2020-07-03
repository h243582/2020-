package cn.ServiceDao;

import java.util.TreeSet;
/**
 * ����dao���FoodDao�ӿڵ�ʵ�ַ�����ӿڣ���factory����
 * @author ���ŷ�
 *
 * @param <V>	����
 */
public interface FoodServiceDao<V> {
	/**
	 * �����ݿ��Ʒ���¼д��set����
	 * <br>ʹ��FoodDAO�ӿ��е�showFood����<br>
	 * @param temp ����ʽ 1:id��2:name��3:price
	 * @return	д���ļ��� ����
	 */
	public TreeSet<V> showFood(int temp);
	/**
	 * �޸����ݿⵥԪ�����ݣ������޸ı��
	 * <br>ʹ��FoodDAO�ӿ��е�update����<br>
	 * @param id ���Ϊ����
	 * @param strs �޸ĺ������
	 * @param y �޸ĵ��б�ʶ��
	 * @return	�ɹ�����true
	 */
	public boolean update(long id,String strs,int y);
	/**
	 * ��idɾ����
	 * <br>ʹ��FoodDAO�ӿ��е�remove����<br>
	 * @param id Ҫɾ���ĺ�
	 * @return �ɹ�����true
	 */
	public boolean delete(long id);
	/**
	 * �����ݿ���Ӽ�¼
	 * <br>ʹ��FoodDAO�ӿ��е�add����<br>
	 * @param name
	 * @param price
	 * @return	�ɹ�����true
	 */
	public boolean append(String name, double price);
	/**
	 * ��Ų��Ҳ�
	 * <br>ʹ��FoodDAO�ӿ��е�find����<br>
	 * @param id ���
	 * @return	���ز�
	 */
	public V find(long id);
}
