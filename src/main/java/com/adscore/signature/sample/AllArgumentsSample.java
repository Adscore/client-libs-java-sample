// MIT License
//
// Copyright (c) 2020 AdScore Technologies DMCC [AE]
//
// Permission is hereby granted, free of charge, to any person obtaining a copy
// of this software and associated documentation files (the "Software"), to deal
// in the Software without restriction, including without limitation the rights
// to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
// copies of the Software, and to permit persons to whom the Software is
// furnished to do so, subject to the following conditions:
//
// The above copyright notice and this permission notice shall be included in all
// copies or substantial portions of the Software.
//
// THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
// IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
// FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
// AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
// LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
// OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
// SOFTWARE.

package com.adscore.signature.sample;

import com.adscore.signature.SignatureVerificationResult;
import com.adscore.signature.SignatureVerifier;
import java.util.Arrays;

class AllArgumentsSample implements Sample {

  @Override
  public String getName() {
    return "all-args-sample";
  }

  @Override
  public SignatureVerificationResult run(String[] args) {
    // expiry time in seconds, against requestTime and signatureTime is checked against
    int expiryTime = Integer.parseInt(args[6]);

    // ip addresses
    String[] ipAddresses = Arrays.copyOfRange(args, 7, args.length);

    return SignatureVerifier.verify(
        args[1], // adscore signature
        args[2], // user agent
        args[3], // sign_role
        args[4], // adscore key
        Boolean.parseBoolean(args[5]), // is adscore key base64 encoded,
        expiryTime,
        ipAddresses);
  }
}
