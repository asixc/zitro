package com.example.service;

import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.IJugada;
import com.example.exception.InvalidRequest;
import com.example.model.Apuesta;
import com.example.model.Balance;
import com.example.model.Juego;
import com.example.model.Jugada;
import com.example.model.Jugador;
import com.example.model.JugadorEnum;
import com.example.model.Proveedor;
import com.example.model.Transaction;
import com.example.service.dto.request.Request;
import com.example.service.dto.response.Response;

@Service
public class ServiceImpl implements IService {

	private static Logger LOG = LoggerFactory.getLogger(ServiceImpl.class);
	private static int AFORO = 10;
	private static int MIN = 1;
	private static int MAX = 10000;
	private static int MAXTRANSACTION = 564546;

	@Autowired
	private IJugada jugadaDao;
	
	@Autowired
	private Response res;

	@Override
	public Response play(Request req) {
		try {
			req.validate();
			return isTheCasinoFull() ? returnLater() : startGame(req);
		} catch (InvalidRequest ir) {
			LOG.error("InvalidRequest: " + ir.getMessage());
		}
		return null;
	}

	private Response startGame(Request req) {
		SubstractSite();

		Transaction ts = new Transaction();

		ts.setJudador(getDataPlayer(req));
		ts.setJugada(getDataBet(req));
		ts.setTransactionId(getRandomTransactionId());

		res.setResult(jugadaDao.saveTransaction(ts));
		return res;
	}

	private String getRandomTransactionId() {
		Random random = new Random();
		int transactionNumber = random.nextInt(MAXTRANSACTION);
		return String.format("Zitro[%d]", transactionNumber);
	}

	private Jugada getDataBet(Request req) {
		Jugada jugada = new Jugada();
		try {
			jugada.setJuego(Juego.valueOfId(req.getUUIDJuego()));
			jugada.setApuesta(new Apuesta(req.getApuesta(), ramdonResultBet()));
			LOG.info("Resultado Jugada: " + jugada.getApuesta().getResultadoApuesta());
		} catch (Exception e) {
			LOG.error("Fallo no controlado");
		}
		return jugada;
	}

	private double ramdonResultBet() {
		return (double) (MIN + Math.random() * (MAX - MIN));
	}

	private Jugador getDataPlayer(Request req) {
		Jugador jugador = new Jugador();
		try {
			JugadorEnum je = JugadorEnum.valueOfString(req.getUUIDJugador());

			jugador.setProveedor(Proveedor.valueOfId(req.getUUIDProveedor()));
			jugador.setUUID(je.getUUID());
			jugador.setBalance(new Balance(je.getGanado(), je.getGastado()));
		} catch (Exception e) {
			LOG.error("Fallo no controlado");
		}

		return jugador;
	}

	private void SubstractSite() {
		ServiceImpl.setAforo(ServiceImpl.getAforo() - 1);
		LOG.info(String.format("Usuario conectado, quedan %d plazas.", ServiceImpl.getAforo()));
	}

	private Response returnLater() {
		LOG.error("Casino lleno intentelo, de nuevo más tarde");
		return null;
	}

	private boolean isTheCasinoFull() {
		return ServiceImpl.getAforo() == 0 ? true : false;
	}

	public static int getAforo() {
		return AFORO;
	}

	public static void setAforo(int aforo) {
		ServiceImpl.AFORO = aforo;
	}

}
