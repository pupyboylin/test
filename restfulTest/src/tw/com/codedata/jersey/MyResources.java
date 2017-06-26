package tw.com.codedata.jersey;

import javax.ws.rs.BeanParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import bean.MyBean;

@Path("myresources")
public class MyResources {
	@POST
	@Path("{id}")
	public void post(@BeanParam MyBean myBean) {
	}

}