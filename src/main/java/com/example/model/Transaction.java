package com.example.model;

public class Transaction {
	private String transactionId;
	private Jugador judador;
	private Jugada jugada;
	
	public String getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}
	public Jugador getJudador() {
		return judador;
	}
	public void setJudador(Jugador judador) {
		this.judador = judador;
	}
	public Jugada getJugada() {
		return jugada;
	}
	public void setJugada(Jugada jugada) {
		this.jugada = jugada;
	}
	
	@Override
	public String toString() {
		return String.format("Transacción:%s Usuario:%s Incremento: %.2f Juego:%s",
				getTransactionId(),this.judador.getUUID(), this.jugada.getApuesta().getResultadoApuesta(), this.jugada.getJuego().getNombreJuego());
	}
}
