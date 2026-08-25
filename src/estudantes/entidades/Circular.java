package estudantes.entidades;

import java.util.Arrays;
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
        if (!super.equals(objeto)) {
            return false;
        }
        Circular circular = (Circular) objeto;
        return Arrays.equals(destinatarios, circular.destinatarios);
    }

    @Override
    public int hashCode() {
        return 31 * super.hashCode() + Arrays.hashCode(destinatarios);
    }
}
