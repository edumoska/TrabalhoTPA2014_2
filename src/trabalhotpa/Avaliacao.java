package trabalhotpa;

import java.util.ArrayList;
import java.util.List;

public class Avaliacao {
	private List<Exame> exames = new ArrayList<>();
	private Turma turma;

	public List<String> getExames() {

		List<String> nomes = new ArrayList<>();

		for (Exame item : exames) {
			nomes.add(item.getNome());
		}
		return nomes;
	}

	public int totalQuestoes(String nomeExame) {
		for (Exame item : exames) {
			if (item.getNome() == nomeExame) {
				return item.getNumeroDeQuestoes();
			}
		}
		return 0;
	}

	public String addExame(Prova p) {
		for (Exame item : exames) {
			if (item.getNome() == p.getNome()) {
				return "NULL";
			}
		}
		exames.add(p);
		return p.getNome();
	}

	public String addExame(Trabalho t) {
		for (Exame item : exames) {
			if (item.getNome() == t.getNome()) {
				return "NULL";
			}
		}
		exames.add(t);
		return t.getNome();
	}

	public Turma getTurma() {
		return turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}
}
