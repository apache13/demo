2.1. Generating a Keystore
Now we'll create a set of cryptographic keys and store it in a keystore.

We can use the following command to generate our PKCS12 keystore format:

$ keytool -genkeypair -alias demo -keyalg RSA -keysize 2048 -storetype PKCS12 -keystore demo.p12 -validity 3650
We can store as many numbers of key-pair in the same keystore each identified by a unique alias.

For generating our keystore in a JKS format, we can use the following command:

$ keytool -genkeypair -alias demo -keyalg RSA -keysize 2048 -keystore demo.jks -validity 3650
It is recommended to use the PKCS12 format which is an industry standard format. So in case we already have a JKS keystore, we can convert it to PKCS12 format using the following command:

$ keytool -importkeystore -srckeystore demo.jks -destkeystore demo.p12 -deststoretype pkcs12
We'll have to provide the source keystore password and also set a new keystore password. The alias and keystore password will be needed later.