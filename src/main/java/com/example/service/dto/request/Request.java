package com.example.service.dto.request;

import org.springframework.stereotype.Component;

import com.example.exception.InvalidRequest;
import com.example.exception.NotFoundException;
import com.example.model.Juego;
import com.example.model.JugadorEnum;
import com.example.model.Proveedor;

@Component
public class Request {
	private String UUIDJugador;
	private int UUIDJuego;
	private int UUIDProveedor;
	private double apuesta;
	
	public String getUUIDJugador() {
		return UUIDJugador;
	}
	public void setUUIDJugador(String UUIDJugador) {
		this.UUIDJugador = UUIDJugador;
	}
	public int getUUIDJuego() {
		return UUIDJuego;
	}
	public void setUUIDJuego(int UUIDJuego) {
		this.UUIDJuego = UUIDJuego;
	}
	public int getUUIDProveedor() {
		return UUIDProveedor;
	}
	public void setUUIDProveedor(int uUIDProveedor) {
		UUIDProveedor = uUIDProveedor;
	}
	public double getApuesta() {
		return apuesta;
	}
	public void setApuesta(double apuesta) {
		this.apuesta = apuesta;
	}
	
	public void validate() throws InvalidRequest {
		
		checkRequestUUIDProveedorValidate();
		checkRequesUUIDJuego();
		checkRequesUUIDJugador();
		if(this.apuesta <= 0) {
			throw new InvalidRequest("Error en el parámetro apuesta");
		}
		
	}
	
	private void checkRequesUUIDJugador() throws InvalidRequest {
		try {
			JugadorEnum.valueOfString(this.UUIDJugador);
		}catch(NotFoundException e) {
			throw new InvalidRequest("Error en el parámetro apuesta", e);
		}
	}
	private void checkRequesUUIDJuego() throws InvalidRequest {
		try {
			Juego.valueOfId(this.UUIDJuego);
		}catch(NotFoundException e) {
			throw new InvalidRequest("Error en el parámetro apuesta", e);
		}
	}
	private void checkRequestUUIDProveedorValidate() throws InvalidRequest{
		try {
			Proveedor.valueOfId(this.UUIDProveedor);
		}catch(NotFoundException e) {
			throw new InvalidRequest("Error en el parámetro apuesta", e);
		}
	}
	
	
}
