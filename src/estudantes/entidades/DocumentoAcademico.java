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
        if (!super.equals(objeto)) {
            return false;
        }
        DocumentoAcademico documento = (DocumentoAcademico) objeto;
        return autenticacao == documento.autenticacao;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), autenticacao);
    }
}
