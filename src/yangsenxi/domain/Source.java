package yangsenxi.domain;

public class Source {
	private int sno;
	private String name;
	private String chinese;
	private String math;
	private String english;
	private String physics;
	private String chemistry;
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getChinese() {
		return chinese;
	}
	public void setChinese(String chinese) {
		this.chinese = chinese;
	}
	public String getMath() {
		return math;
	}
	public void setMath(String math) {
		this.math = math;
	}
	public String getEnglish() {
		return english;
	}
	public void setEnglish(String english) {
		this.english = english;
	}
	public String getPhysics() {
		return physics;
	}
	public void setPhysics(String physics) {
		this.physics = physics;
	}
	public String getChemistry() {
		return chemistry;
	}
	public void setChemistry(String chemistry) {
		this.chemistry = chemistry;
	}
	/**
	 * 重写 toString 方法
	 */
	@Override
	public String toString() {
		return "SourceDao [sno=" + sno + ", name=" + name + ", chinese=" + chinese + ", math=" + math + ", english="
				+ english + ", physics=" + physics + ", chemistry=" + chemistry + "]";
	}
	/**
	 * 重写构造方法
	 * @param sno
	 * @param name
	 * @param chinese
	 * @param math
	 * @param english
	 * @param physics
	 * @param chemistry
	 */
	public Source(int sno, String name, String chinese, String math, String english, String physics,
			String chemistry) {
		super();
		this.sno = sno;
		this.name = name;
		this.chinese = chinese;
		this.math = math;
		this.english = english;
		this.physics = physics;
		this.chemistry = chemistry;
	}
	
	
	
	
}
