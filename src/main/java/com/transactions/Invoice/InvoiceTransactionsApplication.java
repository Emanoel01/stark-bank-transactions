package com.transactions.Invoice;

import com.starkbank.*;

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
	private StartBankConfiguration configuration;

	@Autowired
	private Keys keys;

	public static void main(String[] args) {
		SpringApplication.run(InvoiceTransactionsApplication.class, args);
	}

	@PostConstruct
	public void getProjectConfig() throws Exception {

		File file = new File(keys.getPath()+"/privateKey.pem");
		FileInputStream fileInputStream = new FileInputStream(file);
		byte[] encKey = new byte[fileInputStream.available()];
		fileInputStream.read(encKey);
		fileInputStream.close();
		String stringKey = new String(encKey, StandardCharsets.UTF_8);

		Project user = new Project("sandbox",configuration.getProjectId(), stringKey);

		Settings.user = user;
	}

}
