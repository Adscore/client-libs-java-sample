<h1> 1. What What is this </h1>
This is a super simple CLI-based sample showing how one could use Adscore API within his code.
It contains 

<h4> 2. The purpose of clients-libs-java-samples </h4>
  
All examples shown below fails, because samples does not contain appropriate adscore signature
and key. These samples show usage of the Signature Verify API, and should be used with correct
data.

`ConstantArgumentsBaseSample.java` Does not take any parameters,
it`s a pure example of usage of the lib API with hardcoded parameters values. See how to execute it in point 3rd.

`AllArgumentsSample.java` To execute this example, appropriate parameters have to be provided via command-line.
See how to execute it in point 3rd.
   
<h4>3. Which classes are samples?</h4>
All classes that implement Sample.java interface contain sample code.
e.g look at ConstantArgumentsBaseSample.java to look at basic SignatureVerifier execution.
<br>
<br>

Other samples takes parameters from sample users.

<h4>4. How to execute given samples?</h4>
In order to use this project:
- JRE 1.8 or higher is required

At first step, build a jar file from sample sources. e.g by executing:
```
./gradlew jar
```

Next execute one of follofing samples:

<h5>ConstantArgumentsBaseSample execution:</h5>
```
java -jar build/libs/client-libs-java-samples-1.0.4.jar base-sample
```

<h5>AllArgumentsSample execution:</h5>
```
java -jar build/libs/client-libs-java-samples-1.0.4.jar all-args-sample adscoreSignatureBase64Encoded "Mozilla/5.0" "customer" "adscoreKeyBase64Encoded" true 30 "92.96.235.182" "2001:8f8:1825:a600:950b:dae2:b606:640"
```

Output of all samples is print  out to a standard output.