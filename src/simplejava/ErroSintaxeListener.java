/**
 * 
 */
package simplejava;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

import org.antlr.v4.runtime.ANTLRErrorListener;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;
import org.antlr.v4.runtime.atn.ATNConfigSet;
import org.antlr.v4.runtime.dfa.DFA;

/**
 * @author Gleison Andrade
 *
 */
public class ErroSintaxeListener implements ANTLRErrorListener{
	private List<ErroSintaxeException> erroSintaxe;
	
    /**
     * 
     */
    public ErroSintaxeListener() {
        erroSintaxe = new ArrayList<ErroSintaxeException>();
    }

	/**
	 * @return the erroSintaxe
	 */
	public List<ErroSintaxeException> getErroSintaxe() {
		return erroSintaxe;
	}



	/**
	 * @param erroSintaxe the erroSintaxe to set
	 */
	public void setErroSintaxe(List<ErroSintaxeException> erroSintaxe) {
		this.erroSintaxe = erroSintaxe;
	}



	@Override
	public void reportAmbiguity(Parser arg0, DFA arg1, int arg2, int arg3,
			boolean arg4, BitSet arg5, ATNConfigSet arg6) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void reportAttemptingFullContext(Parser arg0, DFA arg1, int arg2,
			int arg3, BitSet arg4, ATNConfigSet arg5) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void reportContextSensitivity(Parser arg0, DFA arg1, int arg2,
			int arg3, int arg4, ATNConfigSet arg5) {
		// TODO Auto-generated method stub
		
	}

	@Override
    public void syntaxError(Recognizer<?, ?> reconhecedor, Object simbolo, int linha,
        int posicaoCaractereLinha, String mensagem, RecognitionException e) {
        erroSintaxe.add(new ErroSintaxeException(simbolo, linha, posicaoCaractereLinha, mensagem, e));
    }

}
