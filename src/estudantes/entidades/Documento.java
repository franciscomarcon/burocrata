package estudantes.entidades;

import java.util.Objects;
import professor.entidades.CodigoCurso;

/**
 * Classe que representa um documento genérico.
 * <br><br>
 * <strong>Seu trabalho começa aqui...</strong>
 * 
 * @author coloque os nomes dos autores aqui
 */
public abstract class Documento {
    private String criador;
    private CodigoCurso codigoCurso;
    private int paginas;

    public Documento(String criador, CodigoCurso codigoCurso, int paginas) {
        this.criador = criador;
        this.codigoCurso = codigoCurso;
        this.paginas = paginas;
    }

    @Override
    public boolean equals(Object objeto) {
        if (this == objeto) return true;

        if (objeto == null || getClass() !objeto.getClass()) return false;

        Documento that = (Documento) o;

        return paginas == that.paginas && Objects.equals(criador, that.criador) &&
        Objects.equals(codigoCurso, that.codigoCurso); //Ia nos mostrou essa função ao invés de criador.equals(that.criador)
    }

    @Override
    public int hashCode() {
        return Objects.hash(criador, codigoCurso, paginas);
    }
}
