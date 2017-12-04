import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	private static List<Privi> priviList = new ArrayList<Privi>();
	private static List<Role> roleList = new ArrayList<Role>();
	private static List<User> userList = new ArrayList<User>();

	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		// input Privission list
		int p = cin.nextInt();
		for (int i = 0; i < p; i++) {
			priviList.add(new Privi(cin.next()));
		}
		// input role list
		int r = cin.nextInt();
		for (int i = 0; i < r; i++) {
			//
			Role ro = new Role(cin.next());
			int pn = cin.nextInt();
			for (int j = 0; j < pn; j++) {
				ro.addPrivi(new Privi(cin.next()));
			}
			roleList.add(ro);
		}
		// input user list;
		int u = cin.nextInt();
		for (int i = 0; i < u; i++) {
			User us = new User(cin.next());
			int rn = cin.nextInt();
			for (int j = 0; j < rn; j++) {
				us.addRole(roleFactory(cin.next()));
			}
			userList.add(us);
		}
		//
		int q = cin.nextInt();
		List<Query> queryList = new ArrayList<Query>();
		for (int i = 0; i < q; i++) {
			Query qu = new Query(cin.next(),cin.next());
			queryList.add(qu);
		}
		//query 
		for (Query query : queryList) {
			System.out.println(check(query));
		}
		cin.close();
	}
	/**
	*
	*/
	private static Role roleFactory(String name) {
		for(Role role : roleList) {
			if(name.equals(role.getName())) {
				return role;
			}
		}
		return null;
	}

	/**
	*/
	private static String check(Query query) {
		int flag = -3;
		for (User user : userList) {
			flag = -3;
			if (query.qUserName.equals(user.getName())) {
				List<Role> userRoleList = user.getRoleList();
				for (Role role : userRoleList) {
					List<Privi> userRolePriviList = role.getPriviList();
					for (Privi privi :userRolePriviList) {
						flag = query.qPrivi.equals(privi) > flag ? query.qPrivi.equals(privi) : flag;
					}
				}
			}
			if (flag != -3) {
				break;
			}
		}
		if (flag == -2 || flag == -3) {
			return "false";
		} else if(flag == -1) {
			return "true";
		} else
			return flag + "";
	}

	static class Query {
		public String qUserName;
		public Privi qPrivi;
		Query() {
			qUserName = "";
			qPrivi = new Privi();
		}
		Query(String username) {
			this.qUserName = username;
			this.qPrivi = new Privi();
		}
		Query(String username, String Priviname) {
			this.qUserName = username;
			this.qPrivi = new Privi(Priviname);
		}
	}

	static class Privi {
		private String name;
		private int level;
		public Privi() {}

		public Privi(String per) {
			String[] p = per.split(":");
			if (p.length == 1) {
				Privi.this.name = p[0];
				Privi.this.level = -1;
			} else if (p.length == 2) {
				Privi.this.name = p[0];
				Privi.this.level = Integer.parseInt(p[1]);
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

		public int equals(Privi p) {
			if (this.name.equals(p.getName())) {
				if(this.level == -1 && this.level < p.getLevel())
					return p.getLevel();
				else if(this.level == -1 && p.getLevel() == -1)
					return -1;
				else if(this.level != -1 && this.level <= p.getLevel() )
					return -1;
				else
					return -2;
			} else
				return -2;
		}

		public String toString() {
			return this.name +(this.level != -1 ? (":" + this.level) : "");
		}
	}

	static class Role {
		private String name;
		private List<Privi> priList;

		public Role() {
			this.name = "";
			this.priList = new ArrayList<Privi>();
		}
		public Role(String n) {
			this.name = n;
			this.priList = new ArrayList<Privi>();
		}

		public String getName() {
			return this.name;
		}
		public void setName(String s) {
			this.name = s;
		}
		public int getPriviCount() {
			return this.priList.size();
		}
		public List<Privi> getPriviList() {
			return this.priList;
		}
		public void addPrivi(Privi p) {
			this.priList.add(p);
		}

		public String toString() {
			String s = this.name + "~" ;
			for(Privi p : this.priList) {
				s += p.toString() + "+";
			}
			return s;
		}
	}


	static class User {
		private String name;
		private List<Role> roleList;

		public User() {
			this.name = "";
			this.roleList = new ArrayList<Role>();
		}
		public User(String name) {
			this.name = name;
			this.roleList = new ArrayList<Role>();
		}

		public String getName() {
			return this.name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public List<Role> getRoleList() {
			return this.roleList;
		}
		public void addRole(Role role) {
			this.roleList.add(role);
		}
		public String toString() {
			String s = name + "~";
			for(Role role : roleList) {
				s += role.toString() + "+";
			}
			return s;
		}
	}
}