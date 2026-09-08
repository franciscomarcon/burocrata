package estudantes.entidades;

import java.util.Objects;
import professor.entidades.CodigoCurso;

public class Diploma extends Certificado {
    private String habilitacao;

    public Diploma(String criador, CodigoCurso codigoCurso, int paginas,
            long autenticacao, String estudante, long matricula,
            String descricao, String habilitacao) {
        super(criador, codigoCurso, paginas, autenticacao, estudante, matricula, descricao);
        this.habilitacao = habilitacao;
    }

    @Override
    public boolean equals(Object objeto) {
        if (this == objeto) return true;

        if (objeto == null || getClass() != objeto.getClass()) return false;

        Diploma diploma = (Diploma) objeto;

        return super.equals(objeto) && Objects.equals(habilitacao, diploma.habilitacao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), habilitacao);
    }
}
