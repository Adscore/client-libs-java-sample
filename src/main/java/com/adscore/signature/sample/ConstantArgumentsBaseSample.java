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

class ConstantArgumentsBaseSample implements Sample {

  @Override
  public String getName() {
    return "base-sample";
  }

  @Override
  public SignatureVerificationResult run(String[] args) {
    return SignatureVerifier.verify(
        "adscoreSignatureBase64Encoded",
        "Mozilla/5.0 (iPhone; CPU iPhone OS 13_3_1 like Mac OS X) AppleWebKit/605.1.15 (KHTML, like Gecko) Version/13.0.5 Mobile/15E148 Safari/604.1",
        "customer",
        "adscoreKeyBase64Encoded",
        true,
        "92.96.235.182",
        "2001:8f8:1825:a600:950b:dae2:b606:640");
  }
}
