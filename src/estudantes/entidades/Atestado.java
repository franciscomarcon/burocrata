package estudantes.entidades;

import java.util.Objects;
import professor.entidades.CodigoCurso;

public class Atestado extends Registro {
    private String descricao;
    private String categoria;

    public Atestado(String criador, CodigoCurso codigoCurso, int paginas,
            long autenticacao, String estudante, long matricula,
            String descricao, String categoria) {
        super(criador, codigoCurso, paginas, autenticacao, estudante, matricula);
        this.descricao = descricao;
        this.categoria = categoria;
    }

    @Override
    public boolean equals(Object objeto) {
        if (!super.equals(objeto)) {
            return false;
        }
        Atestado atestado = (Atestado) objeto;
        return Objects.equals(descricao, atestado.descricao)
                && Objects.equals(categoria, atestado.categoria);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), descricao, categoria);
    }
}
