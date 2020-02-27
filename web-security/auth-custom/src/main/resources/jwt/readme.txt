2.1. Generating a Keystore
Now we'll create a set of cryptographic keys and store it in a keystore.

We can use the following command to generate our PKCS12 keystore format:

$ keytool -genkeypair -alias jwt -keyalg RSA -keysize 2048 -storetype PKCS12 -keystore jwt.p12 -validity 3650
We can store as many numbers of key-pair in the same keystore each identified by a unique alias.

$ keytool -list -rfc --keystore jwt.p12 | openssl x509 -inform pem -pubkey > jwt.pem
generate .pem