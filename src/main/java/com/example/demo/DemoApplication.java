package com.example.demo;

import java.util.Arrays;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.model.JugadorEnum;
import com.example.model.Proveedor;
import com.example.service.IService;
import com.example.service.dto.request.Request;


@SpringBootApplication(scanBasePackages = { "com.example" })
public class DemoApplication implements CommandLineRunner {
	
	private static final double MIN_FLOAT = 9999.99;
	private static final double MAX_FLOAT = 0.01;
	private Random random = new Random();

	@Autowired
	private IService service;
	
	@Autowired
	private Request req;
	
	
	
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {		
		for (int i = 0; i <25; i++) {
			generateRandomPlayer();
			service.play(req);
			
		}
		
	}

	private void generateRandomPlayer() {	
		req.setUUIDJugador(Arrays.asList(JugadorEnum.values()).get(getIntRandom(0,3)).getUUID());
		req.setUUIDJuego(getIntRandom(0,4));
		req.setUUIDProveedor(Arrays.asList(Proveedor.values()).get(getIntRandom(0,1)).UUID());
		req.setApuesta(getDoubleRandom());
	
	}
	
	private int getIntRandom(int min, int max) {
		return random.nextInt(max + 1 - min) + min;
	}
	
	private double getDoubleRandom() {
		return MIN_FLOAT + random.nextDouble() * (MAX_FLOAT - MIN_FLOAT);
	}
}
