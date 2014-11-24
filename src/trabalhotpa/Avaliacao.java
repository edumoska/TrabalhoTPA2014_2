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

	// m�todo retorna a quantidade de quest�es de um exame, se o exame n�o
	// existir o valor retornado � 0

	public int totalQuestoes(String nomeExame) {
		for (Exame item : exames) {
			if (item.getNome() == nomeExame) {
				return item.getNumeroDeQuestoes();
			}
		}
		return 0;
	}

	// O par�metro tipo determina o tipo de exame, 0 para prova e 1 para
	// trabalho

	public String addExame(String codigoDisciplina, String nomeTurma,
			String nomeExame, int tipo) {
		Exame e;
		if (tipo == 0) {
			e = new Prova(codigoDisciplina, nomeTurma, nomeExame, tipo);
		} else {
			e = new Trabalho(codigoDisciplina, nomeTurma, nomeExame, tipo);
		}
		exames.add(e);
		return e.getNome();
	}

	public String addExame(String codigoDisciplina, String nomeTurma,
			String nomeExame, int tipo, int codigoTemplate) {
		Exame e;
		if (tipo == 0) {
			e = new Prova(codigoDisciplina, nomeTurma, nomeExame, tipo,
					codigoTemplate);
		} else {
			e = new Trabalho(codigoDisciplina, nomeTurma, nomeExame, tipo,
					codigoTemplate);
		}
		exames.add(e);
		return e.getNome();
	}

	public Turma getTurma() {
		return turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}
}
