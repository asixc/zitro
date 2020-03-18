package com.example.model;

public class Apuesta {
	private double cantidadApostada;
	private double resultadoApuesta;
	
	public Apuesta(double apuesta, double resultadoApuesta) {
		this.cantidadApostada = apuesta;
		this.resultadoApuesta = resultadoApuesta;
	}
	public double getCantidadApostada() {
		return cantidadApostada;
	}
	public void setCantidadApostada(double cantidadApostada) {
		this.cantidadApostada = cantidadApostada;
	}
	public double getResultadoApuesta() {
		return resultadoApuesta;
	}
	public void setResultadoApuesta(double resultadoApuesta) {
		this.resultadoApuesta = resultadoApuesta;
	}
}
