package simplejava;

import org.antlr.v4.runtime.RecognitionException;

/**
 * @author Gleison Andrade
 *
 */
public class ErroSintaxeException {
    private Object simbolo;
    private int linha;
    private int posicaoCaractereLinha;
    private String mensagem;
    private RecognitionException reconhecimentoException;
    
    
	/**
	 * 
	 */
	public ErroSintaxeException() {
		super();
	}


	/**
	 * @param simbolo
	 * @param linha
	 * @param posicaoCaractereLinha
	 * @param mensagem
	 * @param reconhecimentoException
	 */
	public ErroSintaxeException(Object simbolo, int linha, int posicaoCaractereLinha, String mensagem, RecognitionException reconhecimentoException) {
		super();
		this.simbolo = simbolo;
		this.linha = linha;
		this.posicaoCaractereLinha = posicaoCaractereLinha;
		this.mensagem = mensagem;
		this.reconhecimentoException = reconhecimentoException;
	}
	
	/**
	 * @return the simbolo
	 */
	public Object getSimbolo() {
		return simbolo;
	}


	/**
	 * @param simbolo the simbolo to set
	 */
	public void setSimbolo(Object simbolo) {
		this.simbolo = simbolo;
	}


	/**
	 * @return the linha
	 */
	public int getLinha() {
		return linha;
	}


	/**
	 * @param linha the linha to set
	 */
	public void setLinha(int linha) {
		this.linha = linha;
	}


	/**
	 * @return the posicaoCaractereLinha
	 */
	public int getPosicaoCaractereLinha() {
		return posicaoCaractereLinha;
	}


	/**
	 * @param posicaoCaractereLinha the posicaoCaractereLinha to set
	 */
	public void setPosicaoCaractereLinha(int posicaoCaractereLinha) {
		this.posicaoCaractereLinha = posicaoCaractereLinha;
	}


	/**
	 * @return the mensagem
	 */
	public String getMensagem() {
		return mensagem;
	}


	/**
	 * @param mensagem the mensagem to set
	 */
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}


	/**
	 * @return the reconhecimentoException
	 */
	public RecognitionException getReconhecimentoException() {
		return reconhecimentoException;
	}


	/**
	 * @param reconhecimentoException the reconhecimentoException to set
	 */
	public void setReconhecimentoException(
			RecognitionException reconhecimentoException) {
		this.reconhecimentoException = reconhecimentoException;
	}


    @Override
    public String toString() {
        return "Erro na linha " + linha + ": posicao " + posicaoCaractereLinha + " " + mensagem;
    }    
}
