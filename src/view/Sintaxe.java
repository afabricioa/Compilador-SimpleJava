/**
 * 
 */
package view;

import javax.swing.text.Segment;

import org.fife.ui.rsyntaxtextarea.AbstractTokenMaker;
import org.fife.ui.rsyntaxtextarea.RSyntaxUtilities;
import org.fife.ui.rsyntaxtextarea.Token;
import org.fife.ui.rsyntaxtextarea.TokenMap;

/**
 * @author Gleison Andrade
 *
 */
public class Sintaxe extends AbstractTokenMaker{

	@Override
	public Token getTokenList(Segment sgmnt, int start, int startOffset)  {
		resetTokenList();
        char[] array = sgmnt.array;
        int offset = sgmnt.offset;
        int count = sgmnt.count;
        int end = offset + count;
        int newStartOffset = startOffset - offset;
        int currentTokenStart = offset;
        int currentTokenType = start;
        int i;
        
        for (i = offset; i < end; i++) {
            char c = array[i];
            
            switch (currentTokenType) {
                
                case Token.NULL:
                    currentTokenStart = i;
                    
                    switch (c) {                        
                        case ' ':
                        case '\t':
                            currentTokenType = Token.WHITESPACE;
                            break;
                        case '"':
                            currentTokenType = Token.LITERAL_STRING_DOUBLE_QUOTE;
                            break;
                        case '/':
                            if (array[i+1] == '/')
                                currentTokenType = Token.COMMENT_EOL;
                            else if (array[i+1] == '*')
                            	currentTokenType = Token.COMMENT_MULTILINE;
                            break;
                        case '>':
                            currentTokenType = Token.OPERATOR;
                            break;
                        case '<':
                            currentTokenType = Token.OPERATOR;
                            break;
                        default:
                            if (RSyntaxUtilities.isDigit(c)) {
                                currentTokenType = Token.LITERAL_NUMBER_DECIMAL_INT;
                                break;
                            } else if (RSyntaxUtilities.isLetter(c) || c == '/' || c == '_') {
                                currentTokenType = Token.IDENTIFIER;
                                break;
                            }
                            currentTokenType = Token.IDENTIFIER;
                            break;
                    }
                    break;
                case Token.WHITESPACE:
                    
                    switch (c) {
                        case ' ':
                        case '\t':
                            break;
                        case '"':
                            addToken(sgmnt, currentTokenStart, i-1, Token.WHITESPACE, newStartOffset+currentTokenStart);
                            currentTokenStart = i;
                            currentTokenType = Token.LITERAL_STRING_DOUBLE_QUOTE;
                            break;
                        case '/':
                            addToken(sgmnt, currentTokenStart, i-1, Token.WHITESPACE, newStartOffset+currentTokenStart);
                            currentTokenStart = i;
                            currentTokenType = Token.COMMENT_EOL;
                            break;
                        default:
                            addToken(sgmnt, currentTokenStart, i-1, Token.WHITESPACE, newStartOffset+currentTokenStart);
                            currentTokenStart = i;
                            if (RSyntaxUtilities.isDigit(c)) {
                                currentTokenType = Token.LITERAL_NUMBER_DECIMAL_INT;
                                break;
                            } else if (RSyntaxUtilities.isLetter(c) || c == '/' || c == '_') {
                                currentTokenType = Token.IDENTIFIER;
                                break;
                            }
                            currentTokenType = Token.IDENTIFIER;
                    }
                    break;
                default:
                    case Token.IDENTIFIER:

                        switch (c) {
                            case ' ':
                            case '\t':
                                addToken(sgmnt, currentTokenStart, i-1, Token.IDENTIFIER, newStartOffset+currentTokenStart);
                                currentTokenStart = i;
                                currentTokenType = Token.WHITESPACE;
                                break;
                            case '"':
                                addToken(sgmnt, currentTokenStart, i-1, Token.IDENTIFIER, newStartOffset+currentTokenStart);
                                currentTokenStart = i;
                                currentTokenType = Token.LITERAL_STRING_DOUBLE_QUOTE;
                                break;
                            default:
                                if (RSyntaxUtilities.isLetterOrDigit(c) || c == '/' || c == '_')
                                    break;
                        }
                        break;
                    case Token.LITERAL_NUMBER_DECIMAL_INT:

                        switch (c) {
                            case ' ':
                            case '\t':
                                addToken(sgmnt, currentTokenStart, i-1, Token.LITERAL_NUMBER_DECIMAL_INT, newStartOffset+currentTokenStart);
                                currentTokenStart = i;
                                currentTokenType = Token.WHITESPACE;
                                break;
                            case '"':
                                addToken(sgmnt, currentTokenStart, i-1, Token.LITERAL_NUMBER_DECIMAL_INT, newStartOffset+currentTokenStart);
                                currentTokenStart = i;
                                currentTokenType = Token.LITERAL_STRING_DOUBLE_QUOTE;
                                break;
                            default:
                                if (RSyntaxUtilities.isDigit(c))
                                    break;
                                addToken(sgmnt, currentTokenStart, i-1, Token.LITERAL_NUMBER_DECIMAL_INT, newStartOffset+currentTokenStart);
                                i--;
                                currentTokenType = Token.NULL;
                        }
                        break;
                    case Token.COMMENT_EOL:
                        i = end - 1;
                        addToken(sgmnt, currentTokenStart, i, currentTokenType, newStartOffset+currentTokenStart);
                        currentTokenType = Token.NULL;
                        break;
                    case Token.LITERAL_STRING_DOUBLE_QUOTE:
                        if (c == '"') {
                            addToken(sgmnt, currentTokenStart, i, Token.LITERAL_STRING_DOUBLE_QUOTE, newStartOffset+currentTokenStart);
                            currentTokenType = Token.NULL;
                        }
                        break;   
            }    
        }
        switch (currentTokenType) {
            
            case Token.LITERAL_STRING_DOUBLE_QUOTE:
                addToken(sgmnt, currentTokenStart, end-1, currentTokenType, newStartOffset+currentTokenStart);
                break;
            case Token.NULL:
                addNullToken();
                break;
            default:
                addToken(sgmnt, currentTokenStart, end-1, currentTokenType, newStartOffset+currentTokenStart);
                addNullToken();
        }
        
        return firstToken;
	}
	
	@Override
    public void addToken(Segment sgmnt, int start, int end, int tokenType, int startOffset) {
        if (tokenType == Token.IDENTIFIER) {
            int valor = wordsToHighlight.get(sgmnt, start, end);
            if (valor != -1) {
                tokenType = valor;
            }
        }
        super.addToken(sgmnt, start, end, tokenType, startOffset);
    }

	@Override
	public TokenMap getWordsToHighlight() {
		TokenMap tokenMap = new TokenMap();
		
		// Palavras reservadas
		tokenMap.put("Prog", Token.RESERVED_WORD);
		tokenMap.put("Static", Token.RESERVED_WORD);	
		tokenMap.put("break", Token.RESERVED_WORD);	
		tokenMap.put("return", Token.RESERVED_WORD);
		tokenMap.put("Int", Token.RESERVED_WORD);
		tokenMap.put("Real", Token.RESERVED_WORD);
		tokenMap.put("Bool", Token.RESERVED_WORD);
		tokenMap.put("String", Token.RESERVED_WORD);
		tokenMap.put("TRUE", Token.RESERVED_WORD);
		tokenMap.put("FALSE", Token.RESERVED_WORD);
		tokenMap.put("void", Token.RESERVED_WORD);
		
		tokenMap.put("if", Token.FUNCTION);
		tokenMap.put("else", Token.FUNCTION);
		
		tokenMap.put("for", Token.FUNCTION);
                tokenMap.put("to", Token.FUNCTION);
		tokenMap.put("step", Token.FUNCTION);
		
		tokenMap.put("while", Token.FUNCTION);
		
		tokenMap.put("print", Token.FUNCTION);
		tokenMap.put("scan", Token.FUNCTION);
		
		tokenMap.put("//", Token.COMMENT_EOL);
		
		tokenMap.put("/*", Token.COMMENT_MULTILINE);
		tokenMap.put("*/", Token.COMMENT_MULTILINE);
		
		tokenMap.put("{", Token.MARKUP_TAG_DELIMITER);
                tokenMap.put("}", Token.MARKUP_TAG_DELIMITER);
                tokenMap.put("(", Token.MARKUP_TAG_DELIMITER);
                tokenMap.put(")", Token.MARKUP_TAG_DELIMITER);
        
		return tokenMap;
	}

}
