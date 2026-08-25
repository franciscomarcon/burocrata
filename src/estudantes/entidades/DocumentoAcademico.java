package estudantes.entidades;

import java.util.Objects;
import professor.entidades.CodigoCurso;

public abstract class DocumentoAcademico extends Documento {
    private long autenticacao;

    public DocumentoAcademico(String criador, CodigoCurso codigoCurso, int paginas,
            long autenticacao) {
        super(criador, codigoCurso, paginas);
        this.autenticacao = autenticacao;
    }

    @Override
    public boolean equals(Object objeto) {
        }

    @Override
    public int hashCode() {
        }
}
