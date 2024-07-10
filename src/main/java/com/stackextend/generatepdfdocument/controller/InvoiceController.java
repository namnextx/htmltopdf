package com.stackextend.generatepdfdocument.controller;

import com.stackextend.generatepdfdocument.service.InvoiceTemplate;
import com.stackextend.generatepdfdocument.service.impl.InvoiceTemplateFactory;
import com.stackextend.generatepdfdocument.service.impl.PdfServiceServiceimpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

import static java.lang.String.format;

@RestController
@RequestMapping("/invoice/generator")
public class InvoiceController {

    static private Logger logger = LogManager.getLogger(InvoiceController.class);

/*    @Resource
    private MockOrderService mockOrderService;
    @Resource
    private InvoiceService invoiceService;*/

    @Autowired
    private PdfServiceServiceimpl pdfServiceServiceimpl;

    // display invoice generator : /resources/templates/forms.html
/*    @GetMapping("/forms")
    public String invoiceForms() {
        return "forms";
    }

    // generate invoice pdf
    @PostMapping(value = "/generate", produces = "application/pdf")
    public ResponseEntity<InputStreamResource> invoiceGenerate(@RequestParam(name = "code", defaultValue = "XYZ123456789") String code,
                                                               @RequestParam(name = "lang", defaultValue = "en") String lang) throws IOException {
        logger.info("Start invoice generation...");
        final OrderModel order = mockOrderService.getOrderByCode(code);
        final File invoicePdf = invoiceService.generateInvoiceFor(order, Locale.forLanguageTag(lang));
        logger.info("Invoice generated successfully...");

        final HttpHeaders httpHeaders = getHttpHeaders(code, lang, invoicePdf);
        return new ResponseEntity<>(new InputStreamResource(new FileInputStream(invoicePdf)), httpHeaders, OK);
    }

    private HttpHeaders getHttpHeaders(String code, String lang, File invoicePdf) {
        HttpHeaders respHeaders = new HttpHeaders();
        respHeaders.setContentType(APPLICATION_PDF);
        respHeaders.setContentLength(invoicePdf.length());
        respHeaders.setContentDispositionFormData("attachment", format("%s-%s.pdf", code, lang));
        return respHeaders;
    }*/

    @GetMapping("/invoice/pdf")
    public ResponseEntity<InputStreamResource> generateInvoicePdf(@RequestParam String templateType, @RequestParam String templatePath) throws Exception {

        Map<String, String> data = new HashMap<>();
        data.put("INVOICE_NO", "12345");
        data.put("INVOICE_DATE", "16 June 2025");
        data.put("BILLED_TO", "Imani Olowe<br>+123-456-7890<br>63 Ivy Road, Hawkville, GA, USA 31036");
        data.put("SUBTOTAL", "$500");
        data.put("TAX", "$0");
        data.put("TOTAL", "$500");
        data.put("PAYMENT_INFO", "Briard Bank<br>Account Name: Samira Hadid<br>Account No.: 123-456-7890<br>Pay by: 5 July 2025<br>123 Anywhere St., Any City, ST 12345");
        data.put("SIGNATURE", "Samira Hadid<br>123 Anywhere St., Any City, ST 12345");

        InvoiceTemplate invoiceTemplate = InvoiceTemplateFactory.getInvoiceTemplate(templateType, templatePath, data);

        ByteArrayOutputStream pdfStream = pdfServiceServiceimpl.generatePdf(invoiceTemplate);
        ByteArrayInputStream inputStream = new ByteArrayInputStream(pdfStream.toByteArray());

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline; filename=invoice.pdf");

        return ResponseEntity
                .ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(inputStream));
    }
}
