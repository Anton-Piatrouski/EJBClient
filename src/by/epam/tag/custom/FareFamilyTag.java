package by.epam.tag.custom;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.rmi.PortableRemoteObject;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import by.epam.ejb.home.FareFamilySvHome;
import by.epam.ejb.remote.FareFamilySv;
import by.epam.model.bean.FareFamily;

@SuppressWarnings("serial")
public class FareFamilyTag extends TagSupport {
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
			Object ref = jndiContext.lookup("FareFamilySv");
			
			// Get a reference from this to the Bean's Home interface
			FareFamilySvHome home = (FareFamilySvHome) PortableRemoteObject.narrow(ref,
					FareFamilySvHome.class);
			
			// Create a FareFamilySv object from the Home interface
			FareFamilySv fareFamilySv = home.create();
			
			FareFamily fareFamily = fareFamilySv.retrieveFareFamily();
			pageContext.setAttribute(var, fareFamily);
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
