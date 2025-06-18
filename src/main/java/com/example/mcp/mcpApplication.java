package com.example.mcp;

import com.example.mcp.service.JsonProcessorService;
import io.modelcontextprotocol.client.McpSyncClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

@SpringBootApplication
public class mcpApplication {
    private final JsonProcessorService jsonProcessorService;

    @Autowired
    private ResourceLoader resourceLoader;

    public String readJson() throws IOException {
        Resource resource = resourceLoader.getResource("classpath:mcp-servers.json");
        byte[] bytes = resource.getInputStream().readAllBytes();
        return new String(bytes, StandardCharsets.UTF_8);
    }

    public mcpApplication(JsonProcessorService jsonProcessorService, ResourceLoader resourceLoader) {
        this.jsonProcessorService = jsonProcessorService;
        this.resourceLoader = resourceLoader;
    }

    public static void main(String[] args) {
        SpringApplication.run(mcpApplication.class, args);
    }

    @Bean
    CommandLineRunner run(List<McpSyncClient> clients) {
        return args -> {

            System.out.println("Reading JSON file...");
            clients.forEach(client -> {
                client.listTools().tools().forEach(tool -> {
                    System.out.println("***************");
                    System.out.println(tool.name());
                    System.out.println(tool.inputSchema());
                    System.out.println(tool.description());
                    System.out.println("************");
                });
            });

//            String finalJson = jsonProcessorService.processJsonTemplate();
//            System.out.println(readJson());
//            System.out.println(finalJson);
//            Files.writeString(Path.of("mcp-servers.json"), finalJson);
//            System.out.println(readJson());


        };
    }

}
