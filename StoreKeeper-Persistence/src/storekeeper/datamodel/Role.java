package storekeeper.datamodel;

import java.util.Set;

import javax.persistence.*;

@Entity
public class Role implements java.io.Serializable {

	private static final long serialVersionUID = -3299197207418523078L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="role_id")
	private int id;	
	private String name;
	private String description;
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="RolePermission", joinColumns=@JoinColumn(name="role_id"), inverseJoinColumns=@JoinColumn(name="permission_id"))
	private Set<Permission> permissions;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "role")
	private Set<User> users;

	public int getId(){
		return id;
	}
	
	public void setName(String iName){
		name = iName;
	}
	
	public String getName(){
		return name; 
	}
	
	public void setDescription(String iDescription){
		description = iDescription;
	}
	
	public String getDescription(){
		return description; 
	}

	public void setPermissions(Set<Permission> iPermissions){
		permissions = iPermissions;
	}

	public Set<Permission> getPermissions() { 
		return permissions; 
	}

	public void setUsers(Set<User> iUsers){
		users = iUsers;
	}

	public Set<User> getUsers() { 
		return users; 
	}

	protected void addUser(User iUser) {
		users.add(iUser);
	}
	
	protected void removeUser(User iUser) {
		users.remove(iUser);
	}
	
}
