package storekeeper.auth;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import storekeeper.datamodel.User;
import java.io.Serializable;

@SessionScoped
@Named("auth")
public class Authentication implements Serializable {

	private static final long serialVersionUID = -8434530560893290733L;
	
	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public boolean isLoggedOn()
	{
		return user != null;
	}
	
	public boolean isGuest()
	{
		return !isLoggedOn();
	}
	
	public String logout() {
		user = null;
		return "index.xhtml";
	}
}
