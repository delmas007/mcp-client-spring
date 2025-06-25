package com.example.mcp.service;

import com.example.mcp.config.GithubConfig;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@Service
public class JsonProcessorService {

    private final GithubConfig githubConfig;

    public JsonProcessorService(GithubConfig githubConfig) {
        this.githubConfig = githubConfig;
    }

    public String processJsonTemplate() throws IOException {

        String jsonTemplate = new String(Files.readAllBytes(Paths.get("src/main/resources/mcp-servers.json")));

        String processedJson = jsonTemplate.replace("${GITHUB_MCP_PAT}", githubConfig.getPat());

        return processedJson;
    }
}

