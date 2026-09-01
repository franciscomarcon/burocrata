package estudantes.entidades;

import java.util.Arrays;
import java.util.Objects;

import professor.entidades.CodigoCurso;

public class Circular extends Deliberacao {
    private String[] destinatarios;

    public Circular(String criador, CodigoCurso codigoCurso, int paginas,
            String texto, String[] destinatarios) {
                super(criador, codigoCurso, paginas, texto);
                this.destinatarios = destinatarios;
    }

    @Override
    public boolean equals(Object objeto) {
    if (this == objeto) return true;

        if (objeto == null || getClass() != objeto.getClass()) return false;

        Circular circ = (Circular) objeto;

        return super.equals(objeto) && Objects.equals(circ.destinatarios, destinatarios);
                

    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), destinatarios);
    }
}
