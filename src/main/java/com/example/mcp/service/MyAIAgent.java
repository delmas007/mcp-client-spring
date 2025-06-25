package com.example.mcp.service;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.MessageChatMemoryAdvisor;
import org.springframework.ai.chat.memory.MessageWindowChatMemory;
import org.springframework.ai.tool.ToolCallbackProvider;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class MyAIAgent {
    private final ChatClient chatClient;

    public MyAIAgent(ChatClient.Builder chatClient, ToolCallbackProvider toolCallbackProvider) {
        this.chatClient = chatClient
                .defaultToolCallbacks(toolCallbackProvider)
                .defaultAdvisors(MessageChatMemoryAdvisor
                        .builder(MessageWindowChatMemory.builder().maxMessages(20).build()).build())
                .build();
    }

    String SystemMessage = """
            Ta tâche est de répondre **uniquement** en te basant sur les informations fournies par les outils mis à ta disposition. **N’invente jamais de réponses** si les données ne sont pas disponibles.
           
            Quand un outil te fournit une réponse en anglais, tu dois la **traduire en français** avant de la transmettre à l’utilisateur.
            
            Si aucune information pertinente n’est disponible, réponds clairement que tu **ne peux pas répondre faute de données**.
           
            Tu dois toujours fournir des réponses **claires, précises et en français**.
            """;
    public String prompt(String question) {
        return chatClient.prompt()
                .system(SystemMessage)
                .user(question).call().content();
    }
}
