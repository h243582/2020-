package cn.ServiceDaoImpl;

import java.util.TreeSet;

import cn.Factory.DaoFactory;
import cn.ServiceDao.FoodServiceDao;
import cn.VO.Food;
/**
 * ����dao���FoodDao�ӿڷ�����ӿڵ�ʵ����
 * @author ���ŷ�
 *
 */
public class FoodServiceDaoImpl implements FoodServiceDao<Food> {
	@Override
	public TreeSet<Food> showFood(int temp) {
		return new DaoFactory().getFoodFactoryInstance().showFood(temp);
	}

	@Override
	public boolean update(long id, String strs, int y) {
		return new DaoFactory().getFoodFactoryInstance().update(id, strs, y);
	}

	@Override
	public boolean delete(long id) {
		return new DaoFactory().getFoodFactoryInstance().remove(id);
	}

	@Override
	public boolean append(String name, double price) {
		return new DaoFactory().getFoodFactoryInstance().add(name, price);
	}

	@Override
	public Food find(long id) {
		return new DaoFactory().getFoodFactoryInstance().find(id);
	}

}
