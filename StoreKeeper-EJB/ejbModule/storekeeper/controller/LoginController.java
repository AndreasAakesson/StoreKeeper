package storekeeper.controller;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import storekeeper.datamodel.User;
import storekeeper.ejb.UserEJB;

@Named(value = "loginController")
@Stateless
public class LoginController {

	@EJB
	private UserEJB userEJB;
	
	private String email;
	private String password;
	//private LoginCredentials credentials = new LoginCredentials();
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String login() {
		User user = userEJB.login(email, password);
		if(user != null)
			return "index";
		
		return "index";
	    /*FacesContext context = FacesContext.getCurrentInstance();
	    HttpServletRequest request = (HttpServletRequest) 
	        context.getExternalContext().getRequest();
	    try {
	      request.login(this.email, this.password);
	    } catch (ServletException e) {
	     
	      context.addMessage(null, new FacesMessage("Login failed."));
	      return "error";
	    }
	    return "order/index";*/
	  }

	  public void logout() {
	    FacesContext context = FacesContext.getCurrentInstance();
	    HttpServletRequest request = (HttpServletRequest) 
	        context.getExternalContext().getRequest();
	    try {
	      request.logout();
	    } catch (ServletException e) {
	      context.addMessage(null, new FacesMessage("Logout failed."));
	    }
	  }
	
	/*public LoginCredentials getCredentials() {
		return credentials;
	}*/
	
	
	/*public static class LoginCredentials {
		private String email;
		private String password;
		
		public void setEmail(String email) {
			this.email = email;
		}
		
		public String getEmail() {
			return email;
		}
		
		public void setPassword(String password) {
			this.password = password;
		}
		
		public String getPassword() {
			return password;
		}
	}*/
}
