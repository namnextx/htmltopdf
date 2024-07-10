package com.stackextend.generatepdfdocument.service.impl;

import com.stackextend.generatepdfdocument.service.PdfService;
import com.stackextend.generatepdfdocument.service.InvoiceTemplate;
import org.springframework.stereotype.Service;
import org.xhtmlrenderer.pdf.ITextRenderer;

import java.io.ByteArrayOutputStream;

@Service
public class PdfServiceServiceimpl implements PdfService {
    public ByteArrayOutputStream generatePdf(InvoiceTemplate template) throws Exception {
        String htmlContent = template.generateHtml();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ITextRenderer renderer = new ITextRenderer();
        renderer.setDocumentFromString(htmlContent);
        renderer.layout();
        renderer.createPDF(outputStream);
        return outputStream;
    }
}
