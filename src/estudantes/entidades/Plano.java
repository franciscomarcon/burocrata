package estudantes.entidades;

import java.util.Arrays;
import java.util.Objects;
import professor.entidades.CodigoCurso;

public class Plano extends DocumentoAcademico {
    private String responsavel;
    private String[] planejamento;

    public Plano(String criador, CodigoCurso codigoCurso, int paginas,
            long autenticacao, String responsavel, String[] planejamento) {
                super(criador, codigoCurso, paginas, autenticacao);
                this.responsavel = responsavel;
                this.planejamento = planejamento;
            }
            
    @Override
    public boolean equals(Object objeto) {
    }

    @Override
    public int hashCode() {
    }
}
