package daihocnhatrang.duongthianhhong.Utils;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class ComonUtils {
  public ComonUtils() {
  }

  public static String hashPassword(String password) {
    try {
      MessageDigest md = MessageDigest.getInstance("MD5");
      byte[] messageDigest = md.digest(password.getBytes());
      BigInteger no = new BigInteger(1, messageDigest);

      String hashtext;
      for(hashtext = no.toString(16); hashtext.length() < 32; hashtext = "0" + hashtext) {
      }

      return hashtext;
    } catch (NoSuchAlgorithmException var5) {
      NoSuchAlgorithmException e = var5;
      throw new RuntimeException(e);
    }
  }
}
