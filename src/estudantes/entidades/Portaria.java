package estudantes.entidades;

import java.util.Objects;
import professor.entidades.CodigoCurso;

public class Portaria extends Norma {
    private int anoInicio;

    public Portaria(String criador, CodigoCurso codigoCurso, int paginas,
            int numero, boolean valido, String texto, int anoInicio) {
        super(criador, codigoCurso, paginas, numero, valido, texto);
        this.anoInicio = anoInicio;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj){
            return true;
        }
        if (obj == null || getClass()!=obj.getClass()){
            return false;
        }
        Portaria portaria = (Portaria)obj;
        return super.equals(obj) && anoInicio==portaria.anoInicio;  
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), anoInicio);
    }
}
