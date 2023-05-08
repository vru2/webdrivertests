package test.java.paymentsUI;

import java.util.Random;

public class PaymentUI_CommonUtilities {

    public static int generateFiveDigitRandomNumber(){
        Random r = new Random( System.currentTimeMillis() );
        System.out.println("random Num "+r);
        return 10000 + r.nextInt(20000);
    }


}
