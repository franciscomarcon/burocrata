package estudantes.entidades;

import java.util.Objects;
import professor.entidades.CodigoCurso;

public abstract class Registro extends DocumentoAcademico {
    private String estudante;
    private long matricula;

    public Registro(String criador, CodigoCurso codigoCurso, int paginas,
            long autenticacao, String estudante, long matricula) {
        super(criador, codigoCurso, paginas, autenticacao);
        this.estudante = estudante;
        this.matricula = matricula;
    }

    @Override
    public boolean equals(Object objeto) {
    }

    @Override
    public int hashCode() {
    }
}
