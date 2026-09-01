package estudantes.entidades;

import java.util.Objects;

import professor.entidades.CodigoCurso;

public abstract class DocumentoAdministrativo extends Documento {

    public DocumentoAdministrativo(String criador, CodigoCurso codigoCurso, int paginas) {
        super(criador, codigoCurso, paginas);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj){
            return true;//quase igual a classe doc essa parte
        }
        if (obj == null || getClass()!=obj.getClass()){
            return false;
        }
        return super.equals(obj);
        }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode()); //utiliza a função da classe documento
        }
}
