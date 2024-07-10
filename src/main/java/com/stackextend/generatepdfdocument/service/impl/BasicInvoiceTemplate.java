package com.stackextend.generatepdfdocument.service.impl;

import com.stackextend.generatepdfdocument.service.InvoiceTemplate;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

public class BasicInvoiceTemplate implements InvoiceTemplate {
    private final String templateFilePath;
    private final Map<String, String> data;

    public BasicInvoiceTemplate(String templateFilePath, Map<String, String> data) {
        this.templateFilePath = templateFilePath;
        this.data = data;
    }

    @Override
    public String generateHtml() throws Exception {
/*
        String html = new String(Files.readAllBytes(Paths.get(templateFilePath)));
*/
        String html = "<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\"/>\n" +
                "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\"/>\n" +
                "    <title>Invoice</title>\n" +
                "    <style>\n" +
                "        @page {\n" +
                "            size: letter;\n" +
                "            margin: 0;\n" +
                "        }\n" +
                "        body {\n" +
                "            font-family: Arial, sans-serif;\n" +
                "            line-height: 1.6;\n" +
                "            color: #333;\n" +
                "            margin: 0;\n" +
                "            padding: 0;\n" +
                "        }\n" +
                "        .invoice-box {\n" +
                "            width: 100%;\n" +
                "            padding: 20mm;\n" +
                "            box-sizing: border-box;\n" +
                "            page-break-inside: avoid;\n" +
                "            display: flex;\n" +
                "            flex-direction: column;\n" +
                "            justify-content: space-between;\n" +
                "            min-height: 100vh;\n" +
                "        }\n" +
                "        .header {\n" +
                "            display: flex;\n" +
                "            justify-content: space-between;\n" +
                "            align-items: center;\n" +
                "            margin-bottom: 20px;\n" +
                "        }\n" +
                "        .header img {\n" +
                "            width: 50px; /* Exact width */\n" +
                "            height: auto; /* Maintain aspect ratio */\n" +
                "        }" +
                "        .header .invoice-details {\n" +
                "            text-align: right;\n" +
                "        }\n" +
                "        .information {\n" +
                "            margin-bottom: 20px;\n" +
                "        }\n" +
                "        .information .billed-to {\n" +
                "            margin-bottom: 20px;\n" +
                "        }\n" +
                "        .items-table {\n" +
                "            width: 100%;\n" +
                "            border-collapse: collapse;\n" +
                "            margin-bottom: 20px;\n" +
                "        }\n" +
                "        .items-table th,\n" +
                "        .items-table td {\n" +
                "            border-top: 1px solid #000;\n" +
                "            border-bottom: 1px solid #000;\n" +
                "            padding: 8px;\n" +
                "            text-align: right;\n" +
                "        }\n" +
                "        .items-table th {\n" +
                "            background: #eee;\n" +
                "            font-weight: bold;\n" +
                "        }\n" +
                "        .items-table th:first-child,\n" +
                "        .items-table td:first-child {\n" +
                "            text-align: left;\n" +
                "        }\n" +
                "        .totals {\n" +
                "            text-align: right;\n" +
                "            margin-bottom: 20px;\n" +
                "        }\n" +
                "        .totals .total-amount {\n" +
                "            font-size: 24px;\n" +
                "            font-weight: bold;\n" +
                "        }\n" +
                "        .totals .line-above-total {\n" +
                "            border-top: 1px solid #000;\n" +
                "            margin-top: 10px;\n" +
                "            padding-top: 10px;\n" +
                "            display: flex;\n" +
                "            justify-content: flex-end;\n" +
                "        }\n" +
                "        .thanks {\n" +
                "            font-size: 18px;\n" +
                "            font-weight: bold;\n" +
                "            margin-bottom: 20px;\n" +
                "        }\n" +
                "\n" +
                "\n" +
                "        .footer {\n" +
                "            margin-top: 20px;\n" +
                "            page-break-inside: avoid;\n" +
                "            width: 100%;\n" +
                "        }\n" +
                "        .footer-table {\n" +
                "            width: 100%;\n" +
                "            border-collapse: collapse;\n" +
                "        }\n" +
                "        .footer-table td {\n" +
                "            vertical-align: bottom;\n" +
                "            padding: 0;\n" +
                "        }\n" +
                "        .payment-info {\n" +
                "            width: 50%;\n" +
                "        }\n" +
                "        .signature {\n" +
                "            width: 50%;\n" +
                "            text-align: right;\n" +
                "            position: relative;\n" +
                "        }\n" +
                "    </style>\n" +
                "</head>\n" +
                "<body>\n" +
                "<div class=\"invoice-box\">\n" +
                "    <div>\n" +
                "        <div class=\"header\">\n" +
                "            <img src=\"https://www.scandinaviansoftwarepark.com/wp-content/uploads/2021/11/Lumera-Logo.png\" alt=\"Company logo\" width=\"130\" height=\"80\"/>\n" +
                "            <div class=\"invoice-details\">\n" +
                "                <h1>INVOICE</h1>\n" +
                "                Invoice No. 12345<br/>\n" +
                "                16 June 2025\n" +
                "            </div>\n" +
                "        </div>\n" +
                "        <div class=\"information\">\n" +
                "            <div class=\"billed-to\">\n" +
                "                <strong>BILLED TO:</strong><br/>\n" +
                "                Imani Olowe<br/>\n" +
                "                +123-456-7890<br/>\n" +
                "                63 Ivy Road, Hawkville, GA, USA 31036\n" +
                "            </div>\n" +
                "        </div>\n" +
                "        <table class=\"items-table\">\n" +
                "            <thead>\n" +
                "            <tr>\n" +
                "                <th>Item</th>\n" +
                "                <th>Quantity</th>\n" +
                "                <th>Unit Price</th>\n" +
                "                <th>Total</th>\n" +
                "            </tr>\n" +
                "            </thead>\n" +
                "            <tbody>\n" +
                "            <tr>\n" +
                "                <td>Eggshell Camisole Top</td>\n" +
                "                <td>1</td>\n" +
                "                <td>$123</td>\n" +
                "                <td>$123</td>\n" +
                "            </tr>\n" +
                "            <tr>\n" +
                "                <td>Cuban Collar Shirt</td>\n" +
                "                <td>2</td>\n" +
                "                <td>$127</td>\n" +
                "                <td>$254</td>\n" +
                "            </tr>\n" +
                "            <tr>\n" +
                "                <td>Floral Cotton Dress</td>\n" +
                "                <td>1</td>\n" +
                "                <td>$123</td>\n" +
                "                <td>$123</td>\n" +
                "            </tr>\n" +
                "            </tbody>\n" +
                "        </table>\n" +
                "        <div class=\"totals\">\n" +
                "            <div>Subtotal: $500</div>\n" +
                "            <div>Tax (0%): $0</div>\n" +
                "            <div class=\"line-above-total\">\n" +
                "                <div class=\"total-amount\">Total: $500</div>\n" +
                "            </div>\n" +
                "        </div>\n" +
                "        <div class=\"thanks\">\n" +
                "            Thank you!\n" +
                "        </div>\n" +
                "    </div>\n" +
                "\n" +
                "    <div class=\"footer\">\n" +
                "        <table class=\"footer-table\">\n" +
                "            <tr>\n" +
                "                <td class=\"payment-info\">\n" +
                "                    <strong>PAYMENT INFORMATION</strong><br/>\n" +
                "                    Briard Bank<br/>\n" +
                "                    Account Name: Samira Hadid<br/>\n" +
                "                    Account No.: 123-456-7890<br/>\n" +
                "                    Pay by: 5 July 2025<br/>\n" +
                "                    123 Anywhere St., Any City, ST 12345\n" +
                "                </td>\n" +
                "                <td class=\"signature\">\n" +
                "                    Samira Hadid<br/>\n" +
                "                    123 Anywhere St., Any City, ST 12345\n" +
                "                </td>\n" +
                "            </tr>\n" +
                "\n" +
                "        </table>\n" +
                "    </div>\n" +
                "</div>\n" +
                "</body>\n" +
                "</html>\n";
        for (Map.Entry<String, String> entry : data.entrySet()) {
            html = html.replace("{{" + entry.getKey() + "}}", entry.getValue());
        }

        return html;
    }
}
