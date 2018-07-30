package org.linus.fileDownloadProj.pdfDownloader;

import java.io.File;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import org.apache.log4j.Logger;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("myresource")
public class MyResource {

	final static Logger logger = Logger.getLogger(MyResource.class);
	
    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    
    @GET
    @Path("/get")
    @Produces("application/pdf")
    public Response getFile() {
    	
    	logger.error("Entered the getFile() Method"); 
  
        File file = new File("/home/sunil/books/renamed/FRUSTRATION.pdf");
        
        logger.error("fileName is : " + file.getName());
  
        ResponseBuilder response = Response.ok((Object) file);
        response.header("Content-Disposition",
            "attachment; filename=\"FRUSTRATION.pdf\"");
        return response.build();
    }
}
