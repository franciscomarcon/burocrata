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
        if (this == objeto) return true; //se ele é ele mesmo, retorna verdade

        if (objeto == null || getClass() != objeto.getClass()) return false; //se ele nao existe, ou as classes nao sao iguais, eh falso

        Documento that = (Documento) objeto; //cria novo objeto, com a classe Documento, que recebe a entrada

        return paginas == that.paginas && Objects.equals(criador, that.criador) && // verifica cada atributo
        Objects.equals(codigoCurso, that.codigoCurso); //Ia nos mostrou essa função ao invés de criador.equals(that.criador)
    }

    @Override
    public int hashCode() {
        return Objects.hash(criador, codigoCurso, paginas);//hashcode base
    }

    public int getPaginas() { //adicionei pois o no arquivo Processo pede essa função, sla ne
        return paginas;
    }

    public CodigoCurso getCodigoCurso() { //mesma coisa, so que para universidade
        return codigoCurso;
    }
}
