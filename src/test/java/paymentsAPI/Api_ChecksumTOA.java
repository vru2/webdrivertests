
package test.java.paymentsAPI;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

class Api_ChecksumTOA {
    public static void main(String[] args) {
        String currency = "INR";
        Double amount = 500.0;
        String user_id = "13957750";
        String checksumkey = "294e275f-a119-47c1-9155-73a0e2a1b22d";

        String pipe = "|";
        String hashType = "SHA-256";
        String hash = new StringBuilder()
                .append(user_id).append(pipe)
                .append(currency).append(pipe)
                .append(amount).append(pipe)
                .append(checksumkey).toString();
        System.out.println(hash);

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