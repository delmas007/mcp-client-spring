package com.example.mcp.web;

import com.example.mcp.service.MyAIAgent;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/api/v1/ai")
@RequiredArgsConstructor
public class McpController {
    private final MyAIAgent agent;

    @PostMapping("/chat")
    @ResponseBody
    public Flux<String> askAgent(@RequestParam String message) {
        return agent.prompt(message);
    }

}
