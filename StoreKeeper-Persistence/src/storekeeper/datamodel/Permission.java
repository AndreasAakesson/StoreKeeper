package storekeeper.datamodel;

import java.util.Set;

import javax.persistence.*;

@Entity
public class Permission implements java.io.Serializable {

	private static final long serialVersionUID = -6342850615388379877L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="permission_id")
	private int id;	
	private String name;
	private String description;
	@ManyToMany(cascade=CascadeType.ALL, mappedBy="permissions")
	protected Set<Role> roles;
	

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

	public void setRoles(Set<Role> iRoles){
		roles = iRoles;
	}

	public Set<Role> getRoles(){
		return roles;
	}
	
}
