# Vaika-API
API of Vaika, car booking application, powered by POJA (Yeah) 

# Steps to contribute
- Read the OpenAPI specification:
  - [https://github.com/tanjonaaa/vaika-api/blob/preprod/doc/api.yml]()
- [Optional] Star the project ;)
- Clone of fork, up to you
- **!!Important!!** Execute the `generateJavaClient` and then the `publishJavaClientToMavenLocal` scripts in `build.gradle`
  - This step will generate the Specified components in the OpenAPI specification as Java Classes
- Access the Java Client at `com.vaika.api.rest.endpoint.model.*`
- There's a script to gen a TS Client too