package memory;

import java.util.ArrayList;

import processo.Processo;

public class MemoryBlock {
	private static int counter = 0;
	private int id;
	private int tamanho;
	private ArrayList<Processo> processos;
	
	
	public MemoryBlock(int tamanho) {
		this.tamanho = tamanho;
		this.processos = new ArrayList<>();
		this.id = ++counter;
	}
	
	
	public int getTamanho() {
		return tamanho;
	}
	public void setTamanho(int tamanho) {
		this.tamanho = tamanho;
	}
	public ArrayList<Processo> getProcessos() {
		return processos;
	}
	
	public void setProcessos(Processo p) {
		processos.add(p);
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	@Override
	public String toString() {
		return "BlocoMemoria id = " + id + ", tamanho = " + tamanho + ", processos = " + processos + "\n";
	}

	
	
}
