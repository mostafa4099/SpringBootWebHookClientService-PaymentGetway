package com.webhook;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.webhook.model.TransactionModel;
import org.apache.tomcat.jni.Library;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Map;

@SpringBootApplication
@RestController
public class WebHookClientApplication {

    @Value("${base64.encrypt.key}")
    String secretKey;

    public static void main(String[] args) {
        SpringApplication.run(WebHookClientApplication.class, args);
    }

    @PostMapping("/daraz_payment_receiver")
    public String receivePaymentInfo(@RequestBody String encryptPayload) {
        String payLoad = decryptPayload(encryptPayload);
        System.out.println(payLoad);

        ObjectMapper mapper = new ObjectMapper();

        try {
//            Map<String,Object> map = mapper.readValue(payLoad, Map.class);
//            JsonNode rootNode = mapper.readTree(payLoad);

            TransactionModel model = mapper.readValue(payLoad, TransactionModel.class);

        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return "Successful";
    }

    public String decryptPayload(String encryptedPayload){
        String payLoad = "";
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(secretKey.getBytes(StandardCharsets.UTF_8), "AES");
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.DECRYPT_MODE, secretKeySpec);
            byte[] decryptedBytes = cipher.doFinal(Base64.getDecoder().decode(encryptedPayload));
            payLoad = new String(decryptedBytes, StandardCharsets.UTF_8);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return payLoad;
    }

}
