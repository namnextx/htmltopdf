package com.stackextend.generatepdfdocument.service;

import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;

@Service
public interface PdfService {
    ByteArrayOutputStream generatePdf(InvoiceTemplate template) throws Exception;
}
