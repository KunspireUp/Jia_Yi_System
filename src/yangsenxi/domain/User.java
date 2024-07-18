package yangsenxi.domain;

public class User {
	private int sno;
	private String password;
	private String name;
	private String role;
	
	/**
	 * Get 和 Set 方法
	 * @return
	 */
	public int getSno() {
		return sno;
	}
	public void setSno(int sno) {
		this.sno = sno;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	/**
	 * 有参构造
	 * @param sno
	 * @param password
	 * @param name
	 * @param role
	 */
	public User(int sno, String password, String name, String role) {
		super();
		this.sno = sno;
		this.password = password;
		this.name = name;
		this.role = role;
	}
	/**
	 * 重写 toString 方法
	 */
	@Override
	public String toString() {
		return "UserDao [sno=" + sno + ", password=" + password + ", name=" + name + ", role=" + role + "]";
	}

}
