package com.example.model;

import com.example.exception.NotFoundException;

public enum Juego {
	VIDEOBINGO(1,"juego de azar", 100, 1000, 20, "VIDEOBINGO"),
	SLOT(2,"traga perras", 100, 1000, 25, "SLOT"),
	BLACKJACK(3, "juego de cartas", 250, 3000, 33, "BLACKJACK"),
	POKER(4, "juego de cartas", 50, 100000, 5, "POKER"),
	RULETA(5, "juego de azar", 500, 5000, 6, "RULETA");
	
	private int id;
	private String tipoJuego;
	private int apuestaMinima;
	private int apuestaMaxima;
	private int probabilidad;
	private String nombreJuego;
	
	Juego(int id, String tipoJuego, int min, int max, int probabilidad, String nombreJuego){
		this.id = id;
		this.tipoJuego = tipoJuego;
		this.apuestaMinima = min;
		this.apuestaMaxima = max;
		this.probabilidad = probabilidad;
		this.nombreJuego = nombreJuego;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTipoJuego() {
		return tipoJuego;
	}

	public void setTipoJuego(String tipoJuego) {
		this.tipoJuego = tipoJuego;
	}

	public int getApuestaMinima() {
		return apuestaMinima;
	}

	public void setApuestaMinima(int apuestaMinima) {
		this.apuestaMinima = apuestaMinima;
	}

	public int getApuestaMaxima() {
		return apuestaMaxima;
	}

	public void setApuestaMaxima(int apuestaMaxima) {
		this.apuestaMaxima = apuestaMaxima;
	}

	public int getProbabilidad() {
		return probabilidad;
	}

	public void setProbabilidad(int probabilidad) {
		this.probabilidad = probabilidad;
	}

	public String getNombreJuego() {
		return nombreJuego;
	}

	public void setNombreJuego(String nombreJuego) {
		this.nombreJuego = nombreJuego;
	}

	public static Juego valueOfId(int id) throws NotFoundException {
		for(Juego j : Juego.values()) {
			if (j.id == id) {
				return j;
			}
		}
		throw new NotFoundException(String.format("No existe juego con UUID [%s]", id));
	}
	
}
