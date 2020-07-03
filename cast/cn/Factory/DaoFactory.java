package cn.Factory;

import cn.Dao.FoodDao;
import cn.Dao.UserOrderDao;
import cn.Dao.impl.FoodDaoImpl;
import cn.Dao.impl.OrderDaoImpl;
import cn.Dao.impl.UserDaoImpl;
import cn.VO.Food;
import cn.VO.Order;
import cn.VO.User;
/**
 * ���Ǹ������ִ࣬��ʵ��������ݣ�����ʵ����
 * @author ���ŷ�
 *
 */
public class DaoFactory {
	/**
	 * ��ȡ�û�������ʵ����
	 * @return �û�������ʵ����
	 */
	public UserOrderDao<User> getUserFactoryInstance() {
		return new UserDaoImpl();
	}
	/**
	 * ��ȡʳƷ������ʵ����
	 * @return ʳƷ������ʵ����
	 */
	public FoodDao<Food>  getFoodFactoryInstance() {
		return new FoodDaoImpl();
	}
	/**
	 * ��ȡ����������ʵ����
	 * @return ����������ʵ����
	 */
	public UserOrderDao<Order>  getOrderFactoryInstance() {
		return new OrderDaoImpl();
	}
	
}
