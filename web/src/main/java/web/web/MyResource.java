package web.web;

import java.sql.SQLException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.jsoup.nodes.Document;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("url")
public class MyResource {

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     * @throws SQLException 
     */
	@Path("{url}")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt(@PathParam("url") String url) throws SQLException {
    	//make connection
		url = "https://"+url;
    			JsoupConnection job =new JsoupConnection(url);
    			Document jSoupDoc = job.getDoc();
    			
    			//Parse
    			Parser par = new Parser(jSoupDoc);
    			WebDataStructure wb = par.filterData();
    			MySqlDataIngestion mysqling =new MySqlDataIngestion();
    			mysqling.ingestData(wb);
    			
    			
        return "Inserted into Mysql Succesfully!!";
    }
}
