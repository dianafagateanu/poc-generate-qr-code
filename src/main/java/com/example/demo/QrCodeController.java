package com.example.demo;

import com.google.zxing.WriterException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;


@Controller
public class QrCodeController {

    private static final String QR_CODE_IMAGE_PATH = "./src/main/resources/static/MyQRCode.png";


    @GetMapping(value = "/")
    public String getQrCode() {

        String textForQrCode = "This is my first QR Code.";
        try {
            ZxingBarcodeGenerator.generateQRCodeImage(textForQrCode, 200, 200, QR_CODE_IMAGE_PATH);
        } catch (WriterException | IOException e) {
            System.out.println("Could not generate QR Code :: " + e.getMessage());
        }

        return "hello";
    }

}
