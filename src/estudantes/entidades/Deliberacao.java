package estudantes.entidades;

import java.util.Objects;
import professor.entidades.CodigoCurso;

public abstract class Deliberacao extends DocumentoAdministrativo {
    private String texto;

    public Deliberacao(String criador, CodigoCurso codigoCurso, int paginas, String texto) {
        super(criador, codigoCurso, paginas);
        this.texto = texto;
    }

    @Override
    public boolean equals(Object objeto) {
        if (!super.equals(objeto)) {
            return false;
        }
        Deliberacao deliberacao = (Deliberacao) objeto;
        return Objects.equals(texto, deliberacao.texto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), texto);
    }
}
