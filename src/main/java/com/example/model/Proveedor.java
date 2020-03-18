package com.example.model;

import com.example.exception.NotFoundException;

public enum Proveedor {
	POKERSTAR(1234, "PokerStart"),
	BWIN(5670, "BWIN");
	
	private int UUID;
	private String nombreFiscal;
	
	Proveedor(int UUID, String nombreFiscal){
		this.UUID = UUID;
		this.nombreFiscal = nombreFiscal;
	}

	public int UUID() {
		return UUID;
	}

	public void setUUID(int uUID) {
		UUID = uUID;
	}

	public String getNombreFiscal() {
		return nombreFiscal;
	}

	public void setNombreFiscal(String nombreFiscal) {
		this.nombreFiscal = nombreFiscal;
	}
	
	public static Proveedor valueOfId(int id) throws NotFoundException {
		for(Proveedor p: Proveedor.values()) {
			if (p.UUID == id) {
				return p;
			}
		}
		throw new NotFoundException(String.format("No existe proveedor con UUID [%s]", id));
	}
	
}
