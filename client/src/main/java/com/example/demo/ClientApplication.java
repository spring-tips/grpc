package com.example.demo;

import com.example.demo.proto.HelloRequest;
import com.example.demo.proto.SimpleGrpc;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClientApplication.class, args);
	}

	@Bean
	ApplicationRunner clientRunner(@GrpcClient("greetingsService") SimpleGrpc.SimpleBlockingStub greetingService) {
		return args -> {
			var josh = HelloRequest.newBuilder().setName("Josh").build();
			var helloReply = greetingService.sayHello(josh);
			System.out.println(helloReply.toString());
		};
	}


}
