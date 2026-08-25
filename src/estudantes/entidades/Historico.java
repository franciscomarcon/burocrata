package estudantes.entidades;

import java.util.Arrays;
import java.util.Objects;
import professor.entidades.CodigoCurso;

public class Historico extends Registro {
    private double coeficiente;
    private String[] componentes;

    public Historico(String criador, CodigoCurso codigoCurso, int paginas,
            long autenticacao, String estudante, long matricula,
            double coeficiente, String[] componentes) {
        super(criador, codigoCurso, paginas, autenticacao, estudante, matricula);
        this.coeficiente = coeficiente;
        this.componentes = componentes;
    }

    @Override
    public boolean equals(Object objeto) {
        if (!super.equals(objeto)) {
            return false;
        }
        Historico historico = (Historico) objeto;
        return Double.compare(coeficiente, historico.coeficiente) == 0
                && Arrays.equals(componentes, historico.componentes);
    }

    @Override
    public int hashCode() {
        int resultado = Objects.hash(super.hashCode(), coeficiente);
        return 31 * resultado + Arrays.hashCode(componentes);
    }
}
