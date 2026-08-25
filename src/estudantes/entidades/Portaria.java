package estudantes.entidades;

import java.util.Objects;
import professor.entidades.CodigoCurso;

public class Portaria extends Norma {
    private int anoInicio;

    public Portaria(String criador, CodigoCurso codigoCurso, int paginas,
            int numero, boolean valido, String texto, int anoInicio) {
        super(criador, codigoCurso, paginas, numero, valido, texto);
        this.anoInicio = anoInicio;
    }

    @Override
    public boolean equals(Object objeto) {
    }

    @Override
    public int hashCode() {
    }
}
