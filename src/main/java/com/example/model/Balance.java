package com.example.model;

public class Balance {
	private double ganado;
	private double gastado;
	
	public Balance(int ganado, int gastado) {
		this.ganado = ganado;
		this.gastado = gastado;
	}
	public double getGanado() {
		return ganado;
	}
	public void setGanado(double ganado) {
		this.ganado = ganado;
	}
	public double getGastado() {
		return gastado;
	}
	public void setGastado(double gastado) {
		this.gastado = gastado;
	} 
	
}
