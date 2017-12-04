import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Check {
	private static List<Permi> permiList = new ArrayList<Permi>();
	private static List<Role> roleList = new ArrayList<Role>();
	private static List<User> userList = new ArrayList<User>();

	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		// input permission list
		int p = cin.nextInt();
		for (int i = 0; i < p; i++) {
			permiList.add(new Permi(cin.next()));
		}
		// input role list
		int r = cin.nextInt();
		for (int i = 0; i < r; i++) {
			//
			Role ro = new Role(cin.next());
			int pn = cin.nextInt();
			for (int j = 0; j < pn; j++) {
				ro.addPermi(new Permi(cin.next()));
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
		
		System.out.println("results:");
		long timeBefore = System.currentTimeMillis();
		for (Query query : queryList) {
			System.out.println(check(query));
		}
		long timeAfter = System.currentTimeMillis();
		System.out.println(timeAfter - timeBefore);
		cin.close();
	}

	/**
	*根据名字从roleList中找到匹配的Role并返回
	*/
	private static Role roleFactory(String name) {
		for(Role role : roleList) {
			if(name.equals(role.getName())) {
				return role;
			}
		}
		return new Role();
	}

	/**
	*从UserList、roleList、permiList中查询Query是否符合，并返回一个特定的字符串
	*/
	private static String check(Query query) {
		int flag = -3;
		for (User user : userList) {
			flag = -3;
			if (query.qUserName.equals(user.getName())) {
				List<Role> userRoleList = user.getRoleList();
				for (Role role : userRoleList) {
					List<Permi> userRolePermiList = role.getPermiList();
					for (Permi permi :userRolePermiList) {
						flag = query.qPermi.equals(permi) > flag ? query.qPermi.equals(permi) : flag;
					}
				}
			}
			if (flag != -3) {
				break;
			}
		}
		//根据flag的值确定返回的字符串
		if (flag == -2) {
			return "false";
		} else if(flag == -1){
			return "true";
		} else 
			return flag + "";
	}

	static class Query {
		public String qUserName;
		//String qPermi;
		public Permi qPermi;

		Query() {
			qUserName = "";
			qPermi = new Permi();
		}
		Query(String username) {
			this.qUserName = username;
			this.qPermi = new Permi();
		}
		Query(String username, String perminame) {
			this.qUserName = username;
			this.qPermi = new Permi(perminame);
		}
	}

}
