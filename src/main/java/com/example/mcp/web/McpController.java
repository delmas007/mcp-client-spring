package com.example.mcp.web;

import com.example.mcp.service.MyAIAgent;
import com.example.mcp.service.PdfToText;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/api/v1/ai")
@RequiredArgsConstructor
public class McpController {
    private final MyAIAgent agent;

    @PostMapping("/chat")
    @ResponseBody
    public String askAgent(@RequestParam String message) {
        return agent.prompt(message);
    }

    @PostMapping("pdf")
    public String pdf(@RequestParam("file") MultipartFile file) {
        return PdfToText.pdfExtract(file.getResource());
    }

}
