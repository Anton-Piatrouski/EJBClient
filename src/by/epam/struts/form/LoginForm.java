package by.epam.struts.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

public class LoginForm extends ActionForm {
	private static final long serialVersionUID = 1L;
	private String userName;
	private String password;
	
	public String getUserName() {
		return userName;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
		//create a blank ActionErrors
		ActionErrors errors = new ActionErrors();
		
		//check for a blank user name
		if (userName.isEmpty()) {
			errors.add("userName", new ActionMessage("login.error.userName.missing"));
		}
		//check for a blank password
		if (password.isEmpty()) {
			errors.add("password", new ActionMessage("login.error.password.missing"));
		}
		return errors;
	}
}
