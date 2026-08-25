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
        
    }

    @Override
    public int hashCode() {
        
    }
}
