package estudantes.entidades;

import java.util.Objects;
import professor.entidades.CodigoCurso;

public class Oficio extends Deliberacao {
    private String destinatario;

    public Oficio(String criador, CodigoCurso codigoCurso, int paginas,
            String texto, String destinatario) {
        super(criador, codigoCurso, paginas, texto);
        this.destinatario = destinatario;
    }

    @Override
    public boolean equals(Object objeto) {
        if (this == objeto) return true;//equals vai sempre ser quase a mesma coisa

        if (objeto == null || getClass() != objeto.getClass()) return false;

        Oficio ofc = (Oficio) objeto;

        return super.equals(objeto) && Objects.equals(ofc.destinatario, destinatario);
        
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(),destinatario);//hashcode, usando classe super e novo atributo
    }

    public String getDestinatario() {
        return destinatario;
    }
}
