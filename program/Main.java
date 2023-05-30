package program;

import java.util.ArrayList;
import java.util.List;

import entities.Atendente;
import entities.Cliente;


public class Main {

	public static void main(String[] args) {
		 List<Atendente> atendentes = new ArrayList<>();
	        atendentes.add(new Atendente("Atendente 1"));
	        atendentes.add(new Atendente("Atendente 2"));

	        
	        CentralAtendimento central = new CentralAtendimento(atendentes);

	        
	        central.adicionarClienteFila(new Cliente("Cliente 1"));
	        central.adicionarClienteFila(new Cliente("Cliente 2"));
	        central.adicionarClienteFila(new Cliente("VIP Cliente 3"));

	        
	        central.utilizarChatBot(new Cliente("Cliente com Pergunta"));

	        
	        central.atenderChamadas();
	    }
	}

	
