package estudantes.entidades;

import java.util.Objects;
import professor.entidades.CodigoCurso;

public class Certificado extends Registro {
    private String descricao;

    public Certificado(String criador, CodigoCurso codigoCurso, int paginas,
            long autenticacao, String estudante, long matricula, String descricao) {
        super(criador, codigoCurso, paginas, autenticacao, estudante, matricula);
        this.descricao = descricao;
    }

    @Override
    public boolean equals(Object objeto) {
        if (!super.equals(objeto)) {
            return false;
        }
        Certificado certificado = (Certificado) objeto;
        return Objects.equals(descricao, certificado.descricao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), descricao);
    }
}
