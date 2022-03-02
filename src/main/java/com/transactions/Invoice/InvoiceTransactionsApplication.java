package com.transactions.Invoice;

import com.starkbank.*;

import com.starkbank.ellipticcurve.PrivateKey;
import com.transactions.Invoice.infra.entities.StarkBankConfigurationEntity;
import com.transactions.Invoice.infra.implementations.configuration.StarkBankConfigurationRepository;
import com.transactions.Invoice.main.config.classes.Keys;
import com.transactions.Invoice.main.config.classes.StartBankConfiguration;

import com.transactions.Invoice.utils.generators.NameGenerator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import javax.annotation.PostConstruct;
import java.io.*;
import java.nio.charset.StandardCharsets;

@SpringBootApplication
public class InvoiceTransactionsApplication {


	@Autowired
	private StarkBankConfigurationRepository starkBankConfigurationRepository;

	@Autowired
	private Keys keys;

	public static void main(String[] args) {
		SpringApplication.run(InvoiceTransactionsApplication.class, args);
	}

	@PostConstruct
	public void getProjectConfig(){

		StarkBankConfigurationEntity configurationEntity = this.starkBankConfigurationRepository.findById("5Gtp8CnBTJmQxkfyuxGX").block();


//		File diretorio= new File("");
//		File privateKey = new File(diretorio.getAbsolutePath() + keys.getPath() + "privateKey.pem");
		File privateKey = new File("app/privateKey.pem");
		FileInputStream fileInputStream;
		try {
			fileInputStream = new FileInputStream(privateKey);
			byte[] encKey = new byte[fileInputStream.available()];
			fileInputStream.read(encKey);
			fileInputStream.close();
			String privateKeyString = new String(encKey, StandardCharsets.UTF_8);
			Project user = new Project("sandbox",configurationEntity.getProjectId(), privateKeyString);
			Settings.user = user;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
