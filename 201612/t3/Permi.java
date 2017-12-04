public class Permi {
	private String name;
	private int level;
	public Permi() {}

	public Permi(String per) {
		String[] p = per.split(":");
		if (p.length == 1) {
			Permi.this.name = p[0];
			Permi.this.level = -1;
		} else if (p.length == 2) {
			Permi.this.name = p[0];
			Permi.this.level = Integer.parseInt(p[1]);
		}
	}

	public String getName() {
		return this.name;
	}
	public void setName(String s) {
		this.name = s;
	}
	public int getLevel() {
		return this.level;
	}
	public void setLevel(int l) {
		this.level = l;
	}

	/**
	*判断两个Permi的关系。
	*若两者名字不同，不是同一种权限，返回-1；
	*若名字相同：
	*	不分等级权限，返回0；
	*	分等级权限，若
	*/
	public int equals(Permi p) {
		if (this.name.equals(p.getName())) {
			if(this.level == -1 && this.level < p.getLevel()) //分等级权限
				return p.getLevel();//返回较大的权限等级值
			else if(this.level == -1 && p.getLevel() == -1) //不分等级权限
				return -1;//返回true;
			else if(this.level != -1 && this.level <= p.getLevel() ) //分等级权限
				return -1;//返回true;
			else //
				return -2;//返回false
		} else
			return -2;//返回false;
	}

	public String toString() {
		return this.name +(this.level != -1 ? (":" + this.level) : "");
	}
}
