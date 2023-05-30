package program;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import entities.Atendente;
import entities.ChatBot;
import entities.Cliente;

public class CentralAtendimento {
	private Queue<Cliente> filaEspera;
	private List<Atendente> atendentes;
	private ChatBot chatBot;

	public CentralAtendimento(List<Atendente> atendentes) {
		this.filaEspera = new LinkedList<>();
		this.atendentes = atendentes;
		this.chatBot = new ChatBot();
	}

	public void adicionarClienteFila(Cliente cliente) {
		filaEspera.offer(cliente);
	}

	public void atenderChamadas() {
		while (!filaEspera.isEmpty()) {
			Cliente cliente = filaEspera.poll();

			if (cliente.getNome().startsWith("VIP")) {
				atenderClientePrioritario(cliente);
			} else {
				Atendente atendente = atendentes.remove(0);
				atenderCliente(cliente, atendente);
				atendentes.add(atendente);
			}
		}
	}

	private void atenderClientePrioritario(Cliente cliente) {
		System.out.println("Atendente Prioritário: Atendendo " + cliente.getNome());

	}

	private void atenderCliente(Cliente cliente, Atendente atendente) {
		System.out.println(atendente.getNome() + ": Atendendo " + cliente.getNome());

	}

	public void utilizarChatBot(Cliente cliente) {
		chatBot.responderPerguntas(cliente);
	}
}
