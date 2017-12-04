/**
 * 用户权限查询问题
 * 之前采用的思路是，分别创建权限/角色/用户三个类，用户中存储角色，角色中存储权限；查询用户权限时，遍历该用户的所有角色的所有权限，查看其中是否有该权限。。。
 * mmp，写下我当时的这段思路后，我老脸都红了。。。当时真的是一腔热血的怼啊，一点算法不懂，楞搞啊！当时因该是总是报运行超时，这么搞不超时才怪啊。
 * 新的思路，绝对不是最好，但是至少比傻白甜1.0时期强点吧。
 *依然分为三个类：用户/角色/权限；但是，存储的时候，角色只是过渡，用户直接存储其权限；查询的时候，针对某个用户，直接查询是否有该权限以及权限是否够的问题。总的来说，应该是增加存储时候的处理时间，但是大大减少查询的时间。
 **/
 import java.util.*;
 public class Main {
    public static Boolean debug = false;
    public static int level = 0;// 0 for info  1 for debug
    public static void main(String args[]) {
        //获取数据
        Scanner cin = new Scanner(System.in);
        // input Privission list
        int p = cin.nextInt();
        Privilege[] arrayPrivi = new Privilege[p];
        //List<Privi> priviList = new ArrayList<Privi>();
        for (int i = 0; i < p; i++) {
            arrayPrivi[i] = new Privilege(cin.next());
        }
        // input role list
        int r = cin.nextInt();
        Role[] arrayRole = new Role[r];
        for (int i = 0; i < r; i++) {
            String nameRole = cin.next();
            int countPrivi = cin.nextInt();
            Role role = new Role(nameRole, countPrivi);
            for (int j = 0; j < countPrivi; j++) {
                role.addPrivi(new Privilege(cin.next()));
            }
            arrayRole[i] = role;
        }
        //添加完角色后，查看一下角色列表
        if(Main.debug  && Main.level > 1){
            for(int j = 0; j < r; j++) {
                System.out.print("添加完角色后");
                System.out.println(arrayRole[j]);
            }
        }
        // input user list;
        int u = cin.nextInt();
        User[] arrayUser = new User[u];
        for (int i = 0; i < u; i++) {
            String name = cin.next();
            int countRole = cin.nextInt();
            User user = new User(name);
            for (int j = 0; j < countRole; j++) {
                Role role = roleFactory(arrayRole,cin.next());
                if(Main.debug  && Main.level > 0){
                    System.out.println("Main:role to added:" + role);
                }
                user.addRole(role);
                //打印用户信息
                if(Main.debug  && Main.level > 0){
                    System.out.println("Main: user: " + user);
                }
            }
            arrayUser[i] = user;
            //添加完用户后，查看一下角色列表
            if(Main.debug  && Main.level > 0){
                for(int k = 0; k < r; k++) {
                    System.out.print("添加完一个用户后role list: ");
                    System.out.println(arrayRole[k]);
                }
            }
            //打印用户信息
            if(Main.debug  && Main.level > 0){
                System.out.println("Main: 角色加载完后的user: " + user);
            }
        }
        //
        int q = cin.nextInt();
        QueryHolder[] arrayQuery = new QueryHolder[q];
        for (int i = 0; i < q; i++) {
            arrayQuery[i] = new QueryHolder(cin.next(),cin.next());
        }
        cin.close();
        if(Main.debug  && Main.level > 1) 
              System.out.println("Main:输入结束");
        //查询开始！
        for(QueryHolder query : arrayQuery) {
            User qUser = userFactory(arrayUser, query.qUserName);
            if(qUser == null){
                System.out.println(false);
                continue;
            }
            if(Main.debug  && Main.level > 1)
                System.out.println("Main:qUser: " + qUser);
            int result = qUser.quaryPrivi(query.qPrivi);
            if(result == -2 )
                System.out.println("false");
            else if (result == -1)
                System.out.println("true");
            else 
                System.out.println("" + result);
        }
    }

    /**根据角色名字返回角色对象
    */
    private static Role roleFactory(Role[] arrayRole,String name) {
        for(Role role : arrayRole) {
            if(name.equals(role.getRoleName())) {
                return role;
            }
        }
        return null;
    }

   /**根据用户名字返回用户对象
    */
    private static User userFactory(User[] arrayUser,String name) {
        for(User user : arrayUser) {
            if(name.equals(user.getUserName())) {
                return user;
            }
        }
        return null;
    }

 }

 /**查询参数持有类
  *
  */
 class QueryHolder {
        public String qUserName;
        public Privilege qPrivi;
        QueryHolder(String username, String Priviname) {
            this.qUserName = username;
            this.qPrivi = new Privilege(Priviname);
        }
        public String toString() {
            return "query: " + this.qUserName + " " + this.qPrivi; 

        }
 }

 /**用户类
  *
  **/
 class User {
     //用户名
     private String userName;
     //用户拥有角色的数量
     private int numRoles;
     //用户拥有权限的列表
     private List<Privilege> userPrivi;
     /**
     *构造函数
     **/
     public User(){}
     public User(String userName){
         this.userName = userName;
         //this.numRoles = numRoles;
         this.userPrivi = new ArrayList<Privilege>();
     }

     /**重写toString()方法
      *
      **/
      public String toString() {
          String str = "user:" + this.userName + "-";
          for (Privilege privi : this.userPrivi)
              str += privi + " ";
          return str;
      }


     public String getUserName() {
         return this.userName;
     }

     /**查询用户是否具有某权限
      * 注意：权限等级是0-9，所以
      *@return -2(不具备该权限/具备该权限但是等级不够）;
      *@return -1 (具备该权限且其具有的等级不低于给出的等级);
      *@return >=0的值 具备该权限，且最高权限为返回值；
      **/
      public int quaryPrivi(Privilege privi) {

          for(Privilege p : this.userPrivi) {
              if(p.namePrivi.equals(privi.namePrivi)){//首先查看是否有重名权限：
                  if(privi.rankPrivi <= p.rankPrivi){
                      //无等级权限；直接返回0；
                      // 有等级权限, 给出了权限等级且其具有的等级不低于给出的等级, 返回 0；
                      if(p.rankPrivi == -1 || privi.rankPrivi != -1)
                          return -1;
                      // 有等级权限, 但是没给出权限等级, 返回其拥有的最高等级权限；
                      else
                          return p.rankPrivi;
                  }else 
                      return -2;
              }
          }
          //没有重名权限
          return -2;
      }

     /** 
      * 获取用户的权限集合
      */
     public List<Privilege> getUserPrivi(){
         return this.userPrivi;
     }

     /***添加用户的角色属性,
      *直接将角色的权限存到用户的权限列表中
      *注意，添加的角色的时候，可能会出现，不同角色具有相同的权限，但是权限等级不同的情况；
      *对于不同的角色中，权限名相同的部分，如果都是无等级权限或者等级相同，由于是List,自动删除重复的。如果是不同等级的同名权限，则保留高等级的权限。
      **/
      public void addRole(Role r) {
          if(Main.debug && Main.level > 0){ 
              System.out.println("add role: user:" + this.userName);
              System.out.println("add role: role to added: " + r);
          }
          //获取待添加角色的权限列表
          List<Privilege> rolePrivi = r.getRolePrivi();
          //获取该用户的权限数量，如果数量为0，则不会存在权限冲突的问题，直接添加所有权限
          int numUserPrivi = this.userPrivi.size();
          if(numUserPrivi == 0){
              this.userPrivi.addAll(rolePrivi);
              return;
          }
          //如果该用户已经有了部分权限，则要判断待添加的角色的权限是否和已有的重复；
          //获取待添加角色的权限的数量
          int numRolePrivi = rolePrivi.size();
          for(int i = 0; i < numRolePrivi; i++) {
              Boolean hasSameName = false;//是否有重名权限的标志，每次迭代要初始化
              if(Main.debug  && Main.level > 1){ 
                System.out.println("add role:" + i);
                System.out.println("add role: rolePrivi:i:" + rolePrivi.size());
              }
              Privilege iPrivi = rolePrivi.get(i);
              for (int j = 0; j < numUserPrivi; j++) {
                  if(Main.debug  && Main.level > 1){ 
                    System.out.println("add role: userPrivi:j:" + j);
                    System.out.println("add role: userPrivi:j:" + this.userPrivi.size());
                  }
                  Privilege jPrivi = this.userPrivi.get(j);
                  if (iPrivi.namePrivi.equals(jPrivi.namePrivi)){//有重名权限
                      hasSameName = true;
                      if(iPrivi.rankPrivi > jPrivi.rankPrivi){ //有重名权限，且新的权限的等级高于原权限等级，把已有的权限删掉，添加新的权限，更新用户权限数量
                          this.userPrivi.remove(j);
                          this.userPrivi.add(iPrivi);
                          //numUserPrivi = this.userPrivi.size();
                      }else{ //有重名权限，且新的权限的等级不高于原权限等级，则不需要添加，把该权限从角色权限列表删除，更新角色列表权限的数量；
                          //rolePrivi.remove(i);
                          //numRolePrivi = rolePrivi.size();
                      }
                      //如果发现了重名权限，因为角色权限列表肯定没有重名权限，且用户权限列表也没有重名权限，因此可以跳出用户的循环。
                      break;
                  }
              }
              //user已有的权限和要添加的权限都不重名：添加
              if(!hasSameName){
                  this.userPrivi.add(iPrivi);
              }
          }
          //排除了所有重名可能，直接添加所有权限
          //this.userPrivi.addAll(rolePrivi);
      }


 }

 /**角色类
  * 
  **/
 class Role {
     //角色名称
     private String roleName;    
    //角色拥有的权限列表: 二维数组存放格式: [[权限1名，权限1等级]，[权限2名，权限2等级], ...](其中，权限名由对应的数字表示！)
     private List<Privilege> rolePrivilege;
     //权限存放数量的计数器
     //private int counterPrivilege;
     //public Role(){}
     /**
      *Role 构造函数
      *@param roleName 
      *@param numPrivilege 该角色拥有的权限种类数目，由此初始化rolePrivilege
      **/
     public Role(String roleName, int numOfPrivilege){
         this.roleName = roleName;
         //this.counterPrivilege = 0;
         this.rolePrivilege = new ArrayList<Privilege>();
     }

     public String toString() {
         String str = "Role:" + this.roleName + "-";
         for (Privilege privi : rolePrivilege)
             str += privi + " ";
         return str;
     }

     public String getRoleName(){
         return this.roleName;
     }

     public List<Privilege> getRolePrivi(){
         return this.rolePrivilege;
     }
     /**为角色增加权限；
      * 注意！权限可以重复出现，如果带等级的权限重复出现，以等级最高的为准
      *@param Privilege 权限字符串，格式：name:rank; 如 crm:1
      *为降低空间，提高速度，直接将name根据映射关系记录成数字;
      **/
     public void addPrivi(Privilege privi) {
         //获取权限的名字
         String namePrivi = privi.namePrivi;
         //获取权限的等级
         int rankPrivi = privi.rankPrivi;
         //获取该角色已有的权限的数量
         int numRolePrivi = this.rolePrivilege.size();
         //确认是否有重复的权限，重复的权限保存最高的权限。
         Boolean hasSameName = false;
         Privilege iPrivi = null;
         for (int i  =0; i < numRolePrivi; i++) { //遍历已有的权限列表
             iPrivi = this.rolePrivilege.get(i);
             if (iPrivi.namePrivi.equals(namePrivi)){ //有重名权限
                 hasSameName = true;
                 if(iPrivi.rankPrivi < rankPrivi){//替换列表中等级较低的权限
                     this.rolePrivilege.remove(i);
                     this.rolePrivilege.add(privi);
                 } 
                 //如果iprivi.rankprivi >= rankprivi:
                 //不移除、不添加，后面也不操作
                 break;
             }
         }
         if(!hasSameName)
            this.rolePrivilege.add(privi);
     }
 }

 /**权限类
  *为了提高速度，将Privilege直接存储为数组；[p1,p2,p3....]
  */
 class Privilege {
     public String namePrivi;
     //权限等级是0-9，所以-1表示为无等级权限；
     public int rankPrivi;
     public Privilege(){}
     /** 
      *
      */
     public Privilege(String nk){
         String[] privi = nk.split(":");
         if(privi.length == 2){
             this.namePrivi = privi[0];
             this.rankPrivi = Integer.parseInt(privi[1]);
         }else if (privi.length == 1) {
             this.namePrivi = privi[0];
             this.rankPrivi = -1;
         }else {
             this.namePrivi = "utility";
             this.rankPrivi = -1;
         }
     }
     public Privilege(String namePrivi, int rankPrivi){
         this.namePrivi = namePrivi;
         this.rankPrivi = rankPrivi;
     }

     public String toString() {
         if(this.rankPrivi == -1)
             return "privi=" + this.namePrivi;
         else 
             return "privi=" + this.namePrivi + ":" + this.rankPrivi;
     }

     /**
      *重写equals方法
      */
     public Boolean equals(Privilege p) {
          if(this.namePrivi.equals(p.namePrivi) && (this.rankPrivi == p.rankPrivi))
              return true;
          return false;
     }
 }