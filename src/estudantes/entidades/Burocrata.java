package estudantes.entidades;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import professor.entidades.*;
import java.util.Random;

/**
 * Classe que traz a lógica do algoritmo de organização e despacho de processos.
 * <br><br>
 * Você pode incluir novos atributos e métodos nessa classe para criar
 * lógicas mais complexas para o gerenciamento da organização e despacho de 
 * processos, mas eles não serão invocados diretamente pelo simulador e devem
 * respeitar propriedades de encapsulamento e coesão.
 * 
 * @author coloque os nomes dos autores aqui
 */
public class Burocrata {
    private int estresse = 0;
    private Mesa mesa;
    private Universidade universidade;
    public int MINIMO_PAGINAS = 245;
    public int n_ciclo = 0;
    
    /**
     * Construtor de Burocrata.
     * 
     * @param m mesa com os processos
     * @param u universidade com os montes dos cursos e a secretaria
     */
    public Burocrata(Mesa m, Universidade u){
        this.mesa = m;
        this.universidade = u;
    }
    
    /**
     * Executa a lógica de criação e despacho dos processos.
     * <br><br>
     * Esse método é o único método de controle invocado durante a simulação 
     * da universidade.
     * <br><br>
     * Aqui podem ser feitas todas as verificações sobre os documentos nos 
     * montes dos cursos e dos processos abertos na mesa do Burocrata. A partir 
     * dessas informações, você pode colocar documentos nos processos abertos
     * e despachar os processos para a secretaria acadêmica.
     * <br><br>
     * Cuidado com a complexidade do seu algoritmo, porque se ele demorar muito
     * serão criados menos documentos na sua execução e sua produtividade geral
     * vai cair.
     * <br><br>
     * Esse método será chamado a cada 50 milissegundos pelo simulador da
     * universidade.
     * <br><br>
     * <strong>O burocrata não pode manter documentos com ele</strong> depois
     * que o método trabalhar terminar de executar, ou seja, você deve devolver
     * para os montes dos cursos todos os documentos que você removeu dos montes
     * dos cursos.
     * 
     * @see professor.entidades.Universidade#despachar(Processo)
     * @see professor.entidades.Universidade#removerDocumentoDoMonteDoCurso(estudantes.entidades.Documento, professor.entidades.CodigoCurso)
     * @see professor.entidades.Universidade#devolverDocumentoParaMonteDoCurso(estudantes.entidades.Documento, professor.entidades.CodigoCurso) 
     */
    public void trabalhar(){
        CodigoCurso[] codigos = CodigoCurso.values();
        Random gerador = new Random();
        int j = gerador.nextInt(codigos.length);
        for (int i = 0; i < 10; i++) {
            CodigoCurso codigo = codigos[j];
            Documento[] documentos =
                    universidade.pegarCopiaDoMonteDoCurso(codigo);

            for (Documento documento : documentos) {
                for (Processo processo : mesa.getProcessos()) {
                    if (documentoAptoParaProcesso(documento, processo)) {
                        processo.adicionarDocumento(documento);
                        universidade.removerDocumentoDoMonteDoCurso(documento, codigo);
                        break;
                    }
                }
            }
            
            j = (j + 1) % codigos.length;
        }

        for (Processo processo : mesa.getProcessos()){
            if (aptoParaDespachar(processo)){
                universidade.despachar(processo);
            }
        }
    
        this.n_ciclo++;
        if (this.n_ciclo >= 2370) {
            this.MINIMO_PAGINAS = 2;
            System.out.println("acabando");
        } 
        else if (this.n_ciclo >= 2300) {
            this.MINIMO_PAGINAS = 220;
            System.out.println("passou p/220");
        } 
    }

    public boolean aptoParaDespachar(Processo processo){
        if (DocEssencial(processo)){
            return true;
        }
        if (contarPaginas_(processo)<=MINIMO_PAGINAS){
            return false;
        }
        if (apenasAtas(processo)){
            return false;
        }
        return true;
        }
        
    public boolean DocEssencial(Processo processo) {
        if (processo == null) {
            return false;
        }

        Documento[] documentos = processo.pegarCopiaDoProcesso();

        if (documentos.length == 0) {
            return false;
        }

        Documento documentoAvaliado = documentos[0];

        if (documentoAvaliado instanceof Norma) {
            Norma norma = (Norma) documentoAvaliado;

            return (norma instanceof Portaria || norma instanceof Edital)
                    && norma.getPaginas() >= 100
                    && norma.isValido();
        }

        return false;
    }

    public boolean apenasAtas(Processo processo){
        for(Documento documento : processo.pegarCopiaDoProcesso()){
            if(documento.getClass()!=Ata.class){
                return false;
            }
        }
        if (processo.pegarCopiaDoProcesso().length != 0) return true;

        return false;
    }

    public int contarPaginas_(Processo processo){
        int paginas = 0;
        for(Documento documento : processo.pegarCopiaDoProcesso()){
            paginas += documento.getPaginas();
        }
        return paginas;
    }

    /* começo de código gerado por IA */
    /**
     * Verifica se um documento pode ser colocado em um processo sem violar as
     * regras administrativas ou ultrapassar o limite de páginas da pasta.
     *
     * @param documento documento que se deseja colocar no processo
     * @param processo processo que receberia o documento
     * @return true se o documento for compatível com o conteúdo do processo
     */
    public boolean documentoAptoParaProcesso(Documento documento, Processo processo) {
        if (documento == null || processo == null) {
            return false;
        }

        // Avalia o conteúdo atual da pasta junto com o novo documento.
        Documento[] documentosDoProcesso = processo.pegarCopiaDoProcesso();
        Documento[] documentosAvaliados = Arrays.copyOf(documentosDoProcesso,
                documentosDoProcesso.length + 1);
        documentosAvaliados[documentosDoProcesso.length] = documento;

        int totalDePaginas = 0;
        boolean possuiGraduacao = false;
        boolean possuiPosGraduacao = false;
        boolean possuiAdministrativo = false;
        boolean possuiAcademico = false;
        boolean possuiDiploma = false;
        boolean possuiDocumentoIncompativelComDiploma = false;
        String categoriaDosAtestados = null;
        boolean encontrouAtestado = false;
        Set<String> destinatariosComuns = null;

        for (Documento documentoAvaliado : documentosAvaliados) {
            // Soma as páginas e identifica se o curso é de graduação ou pós.
            totalDePaginas += documentoAvaliado.getPaginas();
            if (totalDePaginas > 250) {
                return false;
            }

            CodigoCurso codigoCurso = documentoAvaliado.getCodigoCurso();
            if (codigoCurso == CodigoCurso.POS_GRADUACAO_COMPUTACAO
                    || codigoCurso == CodigoCurso.POS_GRADUACAO_ENGENHARIA_ELETRICA
                    || codigoCurso == CodigoCurso.POS_GRADUACAO_MICROELETRONICA) {
                possuiPosGraduacao = true;
            } else {
                possuiGraduacao = true;
            }
            if (possuiGraduacao && possuiPosGraduacao) {
                return false;
            }

            // Atas não entram nessa classificação e podem acompanhar ambos os tipos.
            if (documentoAvaliado instanceof DocumentoAdministrativo) {
                possuiAdministrativo = true;
            } else if (documentoAvaliado instanceof DocumentoAcademico) {
                possuiAcademico = true;
            }
            if (possuiAdministrativo && possuiAcademico) {
                return false;
            }

            // Portarias e editais válidos com 100 páginas ou mais devem ficar sozinhos.
            if (documentoAvaliado instanceof Norma) {
                Norma norma = (Norma) documentoAvaliado;
                if ((norma instanceof Portaria || norma instanceof Edital)
                        && norma.getPaginas() >= 100 && norma.isValido()) {
                    if (documentosAvaliados.length > 1) {
                        return false;
                    }
                }
            }

            // Mantém somente os destinatários comuns entre ofícios e circulares.
            Set<String> destinatariosDoDocumento = null;
            if (documentoAvaliado instanceof Oficio) {
                Oficio oficio = (Oficio) documentoAvaliado;
                destinatariosDoDocumento = new HashSet<>();
                destinatariosDoDocumento.add(oficio.getDestinatario());
            } else if (documentoAvaliado instanceof Circular) {
                Circular circular = (Circular) documentoAvaliado;
                destinatariosDoDocumento = new HashSet<>(
                        Arrays.asList(circular.getDestinatarios()));
            }

            if (destinatariosDoDocumento != null) {
                if (destinatariosComuns == null) {
                    destinatariosComuns = destinatariosDoDocumento;
                } else {
                    destinatariosComuns.retainAll(destinatariosDoDocumento);
                }
                if (destinatariosComuns.isEmpty()) {
                    return false;
                }
            }

            // Diplomas só podem acompanhar certificados, outros diplomas ou atas.
            if (documentoAvaliado instanceof Diploma) {
                possuiDiploma = true;
            } else if (!(documentoAvaliado instanceof Certificado)
                    && !(documentoAvaliado instanceof Ata)) {
                possuiDocumentoIncompativelComDiploma = true;
            }
            if (possuiDiploma && possuiDocumentoIncompativelComDiploma) {
                return false;
            }

            // Todos os atestados da pasta devem ter a mesma categoria.
            if (documentoAvaliado instanceof Atestado) {
                Atestado atestado = (Atestado) documentoAvaliado;
                if (!encontrouAtestado) {
                    categoriaDosAtestados = atestado.getCategoria();
                    encontrouAtestado = true;
                } else if (!Objects.equals(categoriaDosAtestados, atestado.getCategoria())) {
                    return false;
                }
            }
        }

        return true;
    }
    /* fim de código gerado por IA */

    
    /**
     * Retorna o valor atual de estresse do burocrata.
     * @return estresse atual
     */
    public int getEstresse(){
        return this.estresse;
    }
    
    /**
     * Aumenta o estresse do burocrata em uma unidade.
     * 
     * <strong>VOCÊ NÃO DEVERIA INVOCAR ESSE MÉTODO!!!</strong>
     */
    public void estressar(){
        this.estresse++;
    }
    
    /**
     * Aumenta o estresse do burocrata em 10 unidades.
     * 
     * <strong>VOCÊ NÃO DEVERIA INVOCAR ESSE MÉTODO!!!</strong>
     */
    public void estressarMuito(){
        this.estresse += 10;
    }
}
