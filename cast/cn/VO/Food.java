package cn.VO;

import java.io.Serializable;

/**
 * �����࣬�����ݴ����ݿ��Ʒ������¼
 * @author ���ŷ�
 *
 */
public class Food implements Serializable{
	private static final long serialVersionUID = 1L;
	private long id;
	private String name;
	private double price;
	public Food() {
		super();
	}
	public Food(long id, String name, double price) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
}