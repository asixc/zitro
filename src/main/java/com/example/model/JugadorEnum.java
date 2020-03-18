package com.example.model;

import com.example.exception.NotFoundException;

public enum JugadorEnum {
	JUGADOR1("12345678Z", 100, 2500),
	JUGARDOR2("12345678A", 1000, 5500),
	JUGARDOR3("87654321B", 5000, 10000),
	JUGARDOR4("87654321A", 100, 550);
	
	private String UUID;
	private int ganado;
	private int gastado;
	
	JugadorEnum(String UUID, int ganado, int gastado){
		this.UUID = UUID;
		this.ganado = ganado;
		this.gastado = gastado;
	}

	public String getUUID() {
		return UUID;
	}

	public void setUUID(String uUID) {
		UUID = uUID;
	}

	public int getGanado() {
		return ganado;
	}

	public void setGanado(int ganado) {
		this.ganado = ganado;
	}

	public int getGastado() {
		return gastado;
	}

	public void setGastado(int gastado) {
		this.gastado = gastado;
	}
	
	public static JugadorEnum valueOfString(String id) throws NotFoundException {
		for(JugadorEnum j: JugadorEnum.values()) {
			if (j.UUID.equals(id)) {
				return j;
			}
		}
		throw new NotFoundException(String.format("No existe jugador con UUID [%s]", id));
	}
	
}
