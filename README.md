# Spring Boot gRPC Sample

The original project off of which this was based [has since relocated](https://github.com/grpc-ecosystem/grpc-spring).

This project is a copy one of the samples from the [gRPC Spring Boot Starter](https://github.com/yidongnan/grpc-spring-boot-starter/blob/master/examples/local-grpc-server/build.gradle). Build and run any way you like to run Spring Boot. E.g:

```
$ ./mvnw spring-boot:run
...
```

The server starts by default on port 9090. Test with [gRPCurl](https://github.com/fullstorydev/grpcurl):

```
$ grpcurl -d '{"name":"Hi"}' -plaintext localhost:9090 Simple.SayHello
{
  "message": "Hello ==\u003e Hi"
}
```

## Native Image

The services compile to a GraalVM native image, too.

```
$ ./mvnw -Pnative native:compile
$ ./target/server
```

The patches needed to make it work in native were a reflection hint (upstream change: https://github.com/oracle/graalvm-reachability-metadata/pull/148) and some autoconfig metadata (upstream change: https://github.com/yidongnan/grpc-spring-boot-starter/pull/775).