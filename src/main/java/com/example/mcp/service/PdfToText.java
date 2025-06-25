package com.example.mcp.service;

import org.springframework.ai.document.Document;
import org.springframework.ai.reader.pdf.PagePdfDocumentReader;
import org.springframework.ai.reader.pdf.config.PdfDocumentReaderConfig;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PdfToText {

    public static String pdfExtract(Resource resource) {
        PdfDocumentReaderConfig config = PdfDocumentReaderConfig.defaultConfig();
        String content = "";
        PagePdfDocumentReader pagePdfDocumentReader = new PagePdfDocumentReader(resource, config);
        List<Document> document = pagePdfDocumentReader.get();
        content += document.stream().map(Document::getText).collect(Collectors.joining("\n")) + "\n";
        return content;
    }

}
