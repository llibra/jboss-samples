package com.gmail.libra.learn.oddfilter;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;

/**
 * �����{��
 */
@Path("/oddfilter")
public class OddFilter {
    /**
     * @return �\�������ȒP�Ȑ�����
     */
    @GET
    @Path("/whatisthis")
    public String showWhatIsThis() {
        return "This application picks up odd numbers.";
    }

    /**
     * �C�ӂ̐���\����XML���󂯎��A������o����XML�ŕԂ�
     * 
     * @param numbers
     * @return Numbers�I�u�W�F�N�g
     */
    @POST
    @Path("/filter")
    @Consumes("application/xml")
    @Produces("application/xml")
    public Numbers filter(Numbers numbers) {
        ArrayList<Integer> oddNumbers = new ArrayList<Integer>();

        for (int n : numbers.getNumbers()) {
            if (n % 2 == 1) {
                oddNumbers.add(n);
            }
        }

        numbers.setNumbers(oddNumbers);

        return numbers;
    }
}
