import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		// input Privission list
		int p = cin.nextInt();
		Privi[] arrayPrivi = new Privi[p];
		for (int i = 0; i < p; i++) {
			arrayPrivi[i] = new Privi(cin.next());
		}
		// input role list
		int r = cin.nextInt();
		Role[] arrayRole = new Role[r];
		for (int i = 0; i < r; i++) {
			String name = cin.next();
			int countrole = cin.nextInt();
			Role ro = new Role(name, countrole);
			for (int j = 0; j < countrole; j++) {
				ro.addPrivi(j, new Privi(cin.next()));
			}
			arrayRole[i] = ro;
		}
		// input user list;
		int u = cin.nextInt();
		User[] arrayUser = new User[u];
		for (int i = 0; i < u; i++) {
			String name = cin.next();
			int countrole = cin.nextInt();
			User us = new User(name,countrole);
			for (int j = 0; j < countrole; j++) {
				us.addRole(j, roleFactory(arrayRole,cin.next()));
			}
			arrayUser[i] = us;
		}
		//
		int q = cin.nextInt();
		Query[] arrayQuery = new Query[q];
		for (int i = 0; i < q; i++) {
			arrayQuery[i] = new Query(cin.next(),cin.next());
		}
		cin.close();
		//query
		StringBuilder sb = new StringBuilder();
		for (Query query : arrayQuery) {
			sb.append(check(query,arrayUser) + "\n");
		}
		System.out.println(sb.toString());
	}
	/**
	*
	*/
	private static Role roleFactory(Role[] arrayRole,String name) {
		for(Role role : arrayRole) {
			if(name.equals(role.getName())) {
				return role;
			}
		}
		return null;
	}

	/**
	*/
	private static String check(Query query,User[] arrayUser) {
		int flag = -3;
		String uname = query.qUserName;
		Privi up = query.qPrivi;
		for (User user : arrayUser){
			if (uname.equals(user.getName())) {
				Role[] userRoleArr = user.getRoleArray();
				for (Role role : userRoleArr) {
					Privi[] userRolePriviArr = role.getPriviArray();
					for (Privi privi : userRolePriviArr) {
						int temp = up.equals(privi);
						flag = (temp > flag) ? temp : flag;
						if(flag == -1) return "true";
					}
				}
				break;
			}
		}
		if (flag == -2 || flag == -3) {
			return "false";
		} else
			return flag + "";
	}

	static class Query {
		public String qUserName;
		public Privi qPrivi;
		Query(String username, String Priviname) {
			this.qUserName = username;
			this.qPrivi = new Privi(Priviname);
		}
	}
}
class Privi {
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
				return -1;//bufendengji
			else if(this.level != -1 && this.level <= p.getLevel() )
				return -1;//fendengji
			else
				return -2; //
		} else
			return -2;
	}
}

class Role {
	private String name;
	private Privi[] arrPrivi;

	public Role() {}
	public Role(String n,int count) {
		this.name = n;
		this.arrPrivi = new Privi[count];
	}

	public String getName() {
		return this.name;
	}
	public void setName(String s) {
		this.name = s;
	}
	public Privi[] getPriviArray() {
		return this.arrPrivi;
	}
	public void addPrivi(int index,Privi p) {
		this.arrPrivi[index] = p;
	}
}


class User {
	private String name;
	private Role[] arrRole;

	public User() {}
	public User(String name, int count) {
		this.name = name;
		this.arrRole = new Role[count];
	}

	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Role[] getRoleArray() {
		return this.arrRole;
	}
	public void addRole(int n, Role role) {
		this.arrRole[n] = role;
	}
}