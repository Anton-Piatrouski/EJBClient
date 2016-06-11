package by.epam.tag.custom;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.rmi.PortableRemoteObject;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import by.epam.ejb.home.CustomerSvHome;
import by.epam.ejb.remote.CustomerSv;
import by.epam.model.bean.Customer;

@SuppressWarnings("serial")
public class CustomerTag extends TagSupport {
	private String var;
	
	public void setVar(String var) {
		this.var = var;
	}
	
	@Override
	public int doStartTag() throws JspException {
		// preparing properties for constructing an InitialContext object
		Properties properties = new Properties();
		properties.put(Context.INITIAL_CONTEXT_FACTORY,
				"org.jnp.interfaces.NamingContextFactory");
		properties.put(Context.PROVIDER_URL, "localhost:1099");
		try {
			// Get an initial context
			InitialContext jndiContext = new InitialContext(properties);
			
			// Get a reference to the Bean
			Object ref = jndiContext.lookup("CustomerSv");
			
			// Get a reference from this to the Bean's Home interface
			CustomerSvHome home = (CustomerSvHome) PortableRemoteObject.narrow(ref,
					CustomerSvHome.class);
			
			// Create a CustomerSv object from the Home interface
			CustomerSv customerSv = home.create();
			
			Customer customer = customerSv.retrieveCustomer();
			pageContext.setAttribute(var, customer);
		} catch (Exception e) {
			throw new JspException(e.getMessage());
		}
		return SKIP_BODY;
	}
	
	@Override
	public int doEndTag() {
		return EVAL_PAGE;
	}
}
