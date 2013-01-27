package com.gmail.libra.learn.oddfilter;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;

/**
 * 処理本体
 */
@Path("/oddfilter")
public class OddFilter {
    /**
     * @return 表示される簡単な説明文
     */
    @GET
    @Path("/whatisthis")
    public String showWhatIsThis() {
        return "This application picks up odd numbers.";
    }

    /**
     * 任意の数を表したXMLを受け取り、奇数を取り出してXMLで返す
     * 
     * @param numbers
     * @return Numbersオブジェクト
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
