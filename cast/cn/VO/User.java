package cn.VO;
import java.io.Serializable;
/**
 * �����࣬�ݴ��û���Ϣ
 * <br>ʵ�ֽӿ�Serializable �����ǰѶ���ֱ���Զ�����д�뵽�ļ����Ҳ��𻵽ṹ
 * 
 * @author ���ŷ�
 *
 */
public class User implements Serializable {
	private static final long serialVersionUID = 1L;
	private String name;// �ǳ�
	private String account;// �˺�
	private String password;// ����
	private String phoneRegion;// �������
	private String phoneNumber;// ����
	private boolean vip;// VIP

	public User() {
	}

	public User(String name, String account, String password, String phoneRegion, String phoneNumber) {
		this.name = name;
		this.account = account;
		this.password = password;
		this.phoneRegion = phoneRegion;
		this.phoneNumber = phoneNumber;
		this.vip = false;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhoneRegion() {
		return phoneRegion;
	}

	public void setPhoneRegion(String phoneRegion) {
		this.phoneRegion = phoneRegion;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public boolean isVip() {
		return vip;
	}

	public void setVip(boolean vip) {
		this.vip = vip;
	}

}