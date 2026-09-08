package estudantes.entidades;

import java.util.Arrays;
import java.util.Objects;
import professor.entidades.CodigoCurso;

public class Ata extends Documento {
    private int numero;
    private String texto;
    private String[] presentes;

    public Ata(String criador, CodigoCurso codigoCurso, int paginas,
            int numero, String texto, String[] presentes) {
        super(criador, codigoCurso, paginas);
        this.numero = numero;
        this.texto = texto;
        this.presentes = presentes;
    }

    @Override
    public boolean equals(Object objeto) {
        if (this == objeto) return true;

        if (objeto == null || getClass() != objeto.getClass()) return false;

        Ata ata = (Ata) objeto;

        return super.equals(objeto) && numero == ata.numero && Objects.equals(texto, ata.texto)
                && Arrays.equals(presentes, ata.presentes);
    }

    @Override
    public int hashCode() {
        int resultado = Objects.hash(super.hashCode(), numero, texto);
        resultado = 31 * resultado + Arrays.hashCode(presentes);
        return resultado;
    }
}
