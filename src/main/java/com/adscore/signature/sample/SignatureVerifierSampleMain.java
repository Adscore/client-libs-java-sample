package com.adscore.signature.sample;

import com.adscore.signature.SignatureVerificationResult;
import com.adscore.signature.SignatureVerifier;

public class SignatureVerifierSampleMain {

  /**
   * All examples shown below fails, because samples does not contain appropriate adscore signature
   * and key. These samples show usage of the Signature Verify API, and should be used with correct
   * data.
   */
  public static void main(String[] args) {
    baseExample();

  }

  private static void baseExample() {
    SignatureVerificationResult verifyResult =
        SignatureVerifier.verify(
            "adscoreSignatureBase64Encoded",
            "Mozilla/5.0 (iPhone; CPU iPhone OS 13_3_1 like Mac OS X) AppleWebKit/605.1.15 (KHTML, like Gecko) Version/13.0.5 Mobile/15E148 Safari/604.1",
            "customer",
            "adscoreKeyBase64Encoded",
            true,
            "92.96.235.182",
            "2001:8f8:1825:a600:950b:dae2:b606:640");

    // Possible scores and verdicts:
    // score  verdict
    // 0     "ok"
    // 3     "junk"
    // 6     "proxy"
    // 9     "bot"
    // null  "no verdict" (verification is not possible. Check error for more details)
    Integer score = verifyResult.getScore();
    String verdict = verifyResult.getVerdict();

    // Error message explaining e.g why "bot" score has been assigned to given request
    String error = verifyResult.getError();

    // Ip addresses used to check against the signature. It can be either IPv4 or IPv6
    String ipAddress = verifyResult.getIpAddress();

    // Epoch millis when request has been executed, resolved from the signature
    Integer requestTime = verifyResult.getRequestTime();

    // Epoch millis when signature for given request has been generated
    Integer signatureTime = verifyResult.getSignatureTime();

    System.out.println(String.format("Score:%s verdict%s error:%s ipAddress:%s requestTime:%s signatureTime:%s", score, verdict, error, ipAddress, requestTime,signatureTime));
  }
}
