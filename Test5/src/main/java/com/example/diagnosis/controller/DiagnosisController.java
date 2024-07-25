package com.example.diagnosis.controller;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class DiagnosisController {

    private static final String API_KEY = "YOUR_API_KEY"; // OpenAI에서 발급받은 API 키
    private static final Logger logger = LoggerFactory.getLogger(DiagnosisController.class);

    @RequestMapping(value = "/diagnose", method = RequestMethod.POST)
    public String diagnose(@RequestParam("patientStatus") String patientStatus, 
                           @RequestParam("imageFile") MultipartFile imageFile, Model model) {
        logger.info("Received diagnose request with patientStatus: " + patientStatus);
        String diagnosisResult = getDiagnosisFromChatGPT(patientStatus, imageFile);
        model.addAttribute("result", diagnosisResult);
        return "diagnosisResult";
    }

    private String getDiagnosisFromChatGPT(String patientStatus, MultipartFile imageFile) {
        String result = "";
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            HttpPost uploadFile = new HttpPost("https://api.openai.com/v1/chat/completions");
            uploadFile.setHeader("Authorization", "Bearer " + API_KEY);
            MultipartEntityBuilder builder = MultipartEntityBuilder.create();
            builder.addTextBody("prompt", patientStatus, ContentType.TEXT_PLAIN);
            builder.addBinaryBody("file", imageFile.getInputStream(), ContentType.DEFAULT_BINARY, imageFile.getOriginalFilename());
            HttpEntity multipart = builder.build();
            uploadFile.setEntity(multipart);

            try (CloseableHttpResponse response = httpClient.execute(uploadFile)) {
                HttpEntity responseEntity = response.getEntity();
                result = EntityUtils.toString(responseEntity);
            }
        } catch (Exception e) {
            e.printStackTrace();
            result = "진단 중 오류 발생: " + e.getMessage();
        }
        return result;
    }

    @RequestMapping(value = "/diagnoseForm", method = RequestMethod.GET)
    public String showForm() {
        logger.info("Accessing diagnoseForm page");
        return "diagnoseForm";
    }
}
