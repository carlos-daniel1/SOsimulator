package process;

public class Processo {
	private int id;
	private int qtdInstrucao;
	
	public Processo(int id, int qtdInstrucao) {
		this.id = id;
		this.qtdInstrucao = qtdInstrucao;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getQtdInstrucao() {
		return qtdInstrucao;
	}
	public void setQtdInstrucao(int qtdInstrucao) {
		this.qtdInstrucao = qtdInstrucao;
	}


	@Override
	public String toString() {
		return "id=" + id + "qtdInstrucao=" + qtdInstrucao + "\n";
	}
	
	
}
