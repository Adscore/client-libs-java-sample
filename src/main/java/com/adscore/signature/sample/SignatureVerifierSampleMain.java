/*
 * Copyright (c) 2020 AdScore Technologies DMCC [AE]
 *
 * Licensed under MIT License;
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.adscore.signature.sample;

import com.adscore.signature.SignatureVerificationResult;
import java.util.HashMap;
import java.util.Map;

public class SignatureVerifierSampleMain {

  private static final Map<String, Sample> samples;

  static {
    samples = new HashMap<>();

    // Register all samples
    ConstantArgumentsBaseSample baseSample = new ConstantArgumentsBaseSample();
    samples.put(baseSample.getName(), baseSample);

    AllArgumentsSample allArgumentsSample = new AllArgumentsSample();
    samples.put(allArgumentsSample.getName(), allArgumentsSample);
  }

  public static void main(String[] args) {

    if (args == null || args.length == 0 || samples.get(args[0]) == null) {
      throw new SignatureVerifierSampleException(
          "Not found sample for given sample name. Check README.md or provide correct sample name as a first argument.");
    }

    SignatureVerificationResult verifyResult = samples.get(args[0]).run(args);

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

    // True if either requestTime or signatureTime expired
    Boolean expired = verifyResult.getExpired();

    System.out.println(
        String.format(
            "Score:%s verdict:%s expired:%s error:%s ipAddress:%s requestTime:%s signatureTime:%s",
            score, verdict, expired, error, ipAddress, requestTime, signatureTime));
  }
}
