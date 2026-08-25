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
        if (!super.equals(objeto)) {
            return false;
        }
        Portaria portaria = (Portaria) objeto;
        return anoInicio == portaria.anoInicio;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), anoInicio);
    }
}
