package tw.com.codedata.jersey;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.glassfish.jersey.server.mvc.Viewable;

import com.fasterxml.jackson.databind.ObjectMapper;

@Path("/hello")
public class HelloRS {

	@GET
	public String sayHelloWorld() {
		///123123
		return "Hello world";
	}

	@GET
	@Path("/{name}")
	public String sayHello(@PathParam("name") String name, @QueryParam("count") @DefaultValue("1") int count) {
		return "Hello, " + name + ",COUNT=" + count;
	}

	@Path("/sub")
	public Class sayHelloToMySelf() {
		return SubResource.class;
	}

	public static class SubResource {
		@GET
		public String get() {
			return "Hello, sub-resource.";
		}
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
	public String postHelloWorld(@QueryParam("RequestBody") String requestBody) throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		Map<String, String> testMap = new HashMap<String, String>();
		testMap.put("requestbody", requestBody);
		return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(testMap);
	}
}
