package com.gmail.libra.learn.oddfilter;

import java.util.ArrayList;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Consumes;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/**
 * �����{��
 */
@Path("/oddfilter")
public class OddFilter {
    private Logger logger;
    private UserInformation userInfo;

    public OddFilter() throws NamingException {
        InitialContext context = new InitialContext();
        logger = (Logger)context.lookup("java:global/oddfilter/LoggerBean");
        userInfo = (UserInformation)context.lookup("java:global/oddfilter/UserInformationBean");
    }

    /**
     * @return �\�������ȒP�Ȑ�����
     */
    @GET
    @Path("/whatisthis")
    public String showWhatIsThis() {
        return "This application picks up odd numbers.";
    }

    @GET
    @Path("/users")
    @Produces("text/plain")
    public String getUserList() {
        StringBuilder builder = new StringBuilder();

        for (User u : userInfo.list()) {
            builder.append(u.toString());
            builder.append("\n");
        }

        return builder.toString();
    }

    /**
     * �C�ӂ̐���\����XML���󂯎��A������o����XML�ŕԂ�
     * 
     * @param numbers
     * @return Numbers�I�u�W�F�N�g
     */
    @POST
    @Path("/filter/{user}")
    @Consumes("application/xml")
    @Produces("application/xml")
    public Numbers filter(@PathParam("user") String id, Numbers numbers) {
        logger.log(userInfo.find(id), numbers.toString());

        ArrayList<Integer> oddNumbers = new ArrayList<Integer>();

        for (int n : numbers.getNumbers()) {
            if (n % 2 == 1) {
                oddNumbers.add(n);
            }
        }

        numbers.setNumbers(oddNumbers);

        return numbers;
    }

    @GET
    @Path("/log")
    @Produces("text/plain")
    public String getLog() {
        StringBuilder builder = new StringBuilder();

        for (Log l : logger.list()) {
            builder.append(l.toString());
            builder.append("\n");
        }

        return builder.toString();
    }
}
