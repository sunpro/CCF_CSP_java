import java.util.List;
import java.util.ArrayList;

class User {
	private String name;
	private List<Role> roleList;
	
	public User(){
		this.name = "";
		this.roleList = new ArrayList<Role>();
	}
	public User(String name){
		this.name = name;
		this.roleList = new ArrayList<Role>();
	}
	
	public String getName(){
		return this.name;
	}
	public void setName(String name){
		this.name = name;
	}
	public List<Role> getRoleList(){
		return this.roleList;
	}
	public void addRole(Role role){
		this.roleList.add(role);
	}
	public String toString(){
		String s = name + "~";
		for(Role role : roleList){
			s += role.toString() + "+";
		}
		return s;
	}
} 
