package estudantes.entidades;

import java.util.Arrays;
import java.util.Objects;
import professor.entidades.CodigoCurso;

public class Historico extends Registro {
    private double coeficiente;
    private String[] componentes;

    public Historico(String criador, CodigoCurso codigoCurso, int paginas,
            long autenticacao, String estudante, long matricula,
            double coeficiente, String[] componentes) {
        super(criador, codigoCurso, paginas, autenticacao, estudante, matricula);
        this.coeficiente = coeficiente;
        this.componentes = componentes;
    }

    @Override
    public boolean equals(Object objeto) {
        }

    @Override
    public int hashCode() {
        }
}
