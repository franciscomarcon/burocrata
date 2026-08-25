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
        }

    @Override
    public int hashCode() {
        }
}
