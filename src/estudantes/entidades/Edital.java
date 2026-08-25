package estudantes.entidades;

import java.util.Arrays;
import professor.entidades.CodigoCurso;

public class Edital extends Norma {
    private String[] responsaveis;

    public Edital(String criador, CodigoCurso codigoCurso, int paginas,
            int numero, boolean valido, String texto, String[] responsaveis) {
        super(criador, codigoCurso, paginas, numero, valido, texto);
        this.responsaveis = responsaveis;
    }

    @Override
    public boolean equals(Object objeto) {
        if (!super.equals(objeto)) {
            return false;
        }
        Edital edital = (Edital) objeto;
        return Arrays.equals(responsaveis, edital.responsaveis);
    }

    @Override
    public int hashCode() {
        return 31 * super.hashCode() + Arrays.hashCode(responsaveis);
    }
}
