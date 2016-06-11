package by.epam.struts.action;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.rmi.PortableRemoteObject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import by.epam.ejb.home.UserSvHome;
import by.epam.ejb.remote.UserSv;
import by.epam.model.bean.User;
import by.epam.struts.form.LoginForm;

public class LoginAction extends Action {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		LoginForm loginForm = (LoginForm) form;
		String userName = loginForm.getUserName();
		String password = loginForm.getPassword();
		
		ActionForward fw = mapping.getInputForward();
		ActionMessages errors = new ActionMessages();
		
		// preparing properties for constructing an InitialContext object
		Properties properties = new Properties();
		properties.put(Context.INITIAL_CONTEXT_FACTORY, "org.jnp.interfaces.NamingContextFactory");
		properties.put(Context.PROVIDER_URL, "localhost:1099");
		
		// Get an initial context
		InitialContext jndiContext = new InitialContext(properties);
		// Get a reference to the Bean
		Object ref = jndiContext.lookup("UserSv");
		
		// Get a reference from this to the Bean's Home interface
		UserSvHome home = (UserSvHome) PortableRemoteObject.narrow(ref, UserSvHome.class);
		// Create a UserSv object from the Home interface
		UserSv userSv = home.create();
		
		User user = userSv.retrieveUser(userName, password);
		
		if (user == null) {
			errors.add("failure", new ActionMessage("login.error.request.processing"));
			
		} else if (userName.equals(user.getName())) {
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			
			fw = mapping.findForward("success");
		} else {
			errors.add("failure", new ActionMessage("login.error.failure"));
		}
		saveErrors(request, errors);
		return fw;
	}
}
