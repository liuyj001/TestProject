package com.h3c;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ApplicationTests {
    @Autowired
    AppSettingMapping appSettingMapping;

    @Test
    void getAppSetting() {
        String appsetting = appSettingMapping.getAll().toString();
        System.out.println(appsetting);
    }

    @Test
    void getEncData(){
        StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
        encryptor.setAlgorithm("PBEWithMD5AndDES");
        encryptor.setPassword("H3C");

        String plaintext = "qmoffice";
        String encryptedText = encryptor.encrypt(plaintext);
        System.out.println("Encrypted Text: " + encryptedText);
    }
}
