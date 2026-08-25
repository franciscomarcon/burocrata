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
        if (!super.equals(objeto)) {
            return false;
        }
        Plano plano = (Plano) objeto;
        return Objects.equals(responsavel, plano.responsavel)
                && Arrays.equals(planejamento, plano.planejamento);
    }

    @Override
    public int hashCode() {
        int resultado = Objects.hash(super.hashCode(), responsavel);
        return 31 * resultado + Arrays.hashCode(planejamento);
    }
}
