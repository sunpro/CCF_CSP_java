import java.util.List;
import java.util.ArrayList;

class Role {
	private String name;
	private List<Permi> permiList;
	
	public Role(){
		this.name = "";
		this.permiList = new ArrayList<Permi>();
	}
	public Role(String n){
		this.name = n;
		this.permiList = new ArrayList<Permi>();
	}
	
	public String getName(){
		return this.name;
	}
	public void setName(String s){
		this.name = s;
	}
	public int getPermiCount(){
		return this.permiList.size();
	}
	public List<Permi> getPermiList(){
		return this.permiList;
	}
	public void addPermi(Permi p){
		this.permiList.add(p);
	}
	
	public String toString(){
		String s = this.name + "~" ;
		for(Permi p : this.permiList){
			s += p.toString() + "+";
		}
		return s;
	}
} 
