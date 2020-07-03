package cn.Dao;

import java.util.TreeMap;
import java.util.TreeSet;

import cn.VO.Food;
/**
 * ʳƷ��һЩ�����ӿ�
 * @author ���ŷ�
 *
 * @param <V> VO����
 */
public interface FoodDao<V>{
	/**
	 * �����ݿ��Ʒ���¼д��set����
	 * @param temp ����ʽ 1:id��2:name��3:price
	 * @return	д���ļ��� ����
	 */
	public TreeSet<V> showFood(int temp);
	/**
	 * �����ݿ��Ʒ���¼д��map����
	 * @return д���ļ��� ����
	 */
	public TreeMap<Long,Food> showFood2();

	/**
	 * �޸����ݿⵥԪ�����ݣ������޸ı��
	 * @param id ���Ϊ����
	 * @param strs �޸ĺ������
	 * @param y �޸ĵ��б�ʶ��
	 * @return	�ɹ�����true
	 */
	public boolean update(long id,String strs,int y);
	/**
	 * ��idɾ����
	 * @param id Ҫɾ���ĺ�
	 * @return �ɹ�����true
	 */
	public boolean remove(long id);
	/**
	 * �����ݿ���Ӽ�¼
	 * @param name
	 * @param price
	 * @return	�ɹ�����true
	 */
	public boolean add(String name, double price);
	/**
	 * ��Ų��Ҳ�
	 * @param id ���
	 * @return	���ز�
	 */
	public V find(long id);
	
}
