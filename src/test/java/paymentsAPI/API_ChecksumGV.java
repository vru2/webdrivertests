
package test.java.  paymentsAPI;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class API_ChecksumGV {
    public static void main(String[] args) {
        String currency = "INR";
        String amount = "10000";
        String userEmail = "kiran.kumar@cleartrip.com";
        String paymentId = "44582482";
        String checkSumKey = "cleartrip";

        String pipe = "|";
        String hashType = "SHA-256";
        String hash = new StringBuilder()
                .append(currency).append(pipe)
                .append(amount).append(pipe)
                .append(userEmail).append(pipe)
                .append(paymentId).append(pipe)
                .append(checkSumKey).toString();
        System.out.println(calculateHash(hashType,hash));
    }

    public static String calculateHash(String hashType, String input) {
        byte[] hashseq = input.getBytes();
        StringBuffer hexString = new StringBuffer();
        try {
            MessageDigest algorithm = MessageDigest.getInstance(hashType);
            algorithm.reset();
            algorithm.update(hashseq);
            byte[] messageDigest = algorithm.digest();

            for (int i = 0; i < messageDigest.length; i++) {
                String hex = Integer.toHexString(0xFF & messageDigest[i]);
                if (hex.length() == 1) {
                    hexString.append("0");
                }
                hexString.append(hex);
            }

        } catch (NoSuchAlgorithmException e) {
            System.out.println("Error");
        }

        return hexString.toString();
    }


}
