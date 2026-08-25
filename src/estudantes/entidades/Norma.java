package estudantes.entidades;

import java.util.Objects;
import professor.entidades.CodigoCurso;

public class Norma extends DocumentoAdministrativo {
    private int numero;
    private boolean valido;
    private String texto;

    public Norma(String criador, CodigoCurso codigoCurso, int paginas,
            int numero, boolean valido, String texto) {
        super(criador, codigoCurso, paginas);
        this.numero = numero;
        this.valido = valido;
        this.texto = texto;
    }

    @Override
    public boolean equals(Object objeto) {
    }

    @Override
    public int hashCode() {
    }
}
