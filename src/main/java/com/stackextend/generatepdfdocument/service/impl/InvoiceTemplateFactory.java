package com.stackextend.generatepdfdocument.service.impl;

import com.stackextend.generatepdfdocument.service.InvoiceTemplate;

import java.util.Map;

public class InvoiceTemplateFactory {

    public static InvoiceTemplate getInvoiceTemplate(String templateType, String templateFilePath, Map<String, String> data) {
        switch (templateType.toLowerCase()) {
            case "basic":
                return new BasicInvoiceTemplate(templateFilePath, data);
            // Add more cases for different templates
            default:
                throw new IllegalArgumentException("Unknown template type: " + templateType);
        }
    }
}
