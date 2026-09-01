package estudantes.entidades;

import java.util.Arrays;
import java.util.Objects;

import professor.entidades.CodigoCurso;

public class Edital extends Norma {
    private String[] responsaveis;

    public Edital(String criador, CodigoCurso codigoCurso, int paginas,
            int numero, boolean valido, String texto, String[] responsaveis) {
        super(criador, codigoCurso, paginas, numero, valido, texto);
        this.responsaveis = responsaveis;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj){
            return true;
        }
        if (obj == null || getClass()!=obj.getClass()){
            return false;
        }
        Edital edital = (Edital)obj;
        return super.equals(obj) && Objects.equals(edital.responsaveis, responsaveis);  
        }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), responsaveis);
        }
}
