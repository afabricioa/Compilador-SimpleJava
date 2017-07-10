/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tabela;

import java.util.ArrayList;

/**
 *
 * @author Jonatas Laet
 */
public class Table {
    ArrayList <Variavel> varGlobal;
    ArrayList <Constante> constantes;
    ArrayList <Funcao> funcoes;
    
    public Table () {
        this.varGlobal = new ArrayList<>();
        this.constantes = new ArrayList<>();   
        this.funcoes = new ArrayList<>();
    }
      
    public void addVar (String id, int tipo)
    {
        varGlobal.add(new Variavel(id, tipo));
    }
    
    public void addConst (String id, int tipo, String valor)
    {
        constantes.add(new Constante(id, tipo));
    }
    
    public void addFunc (int tipo, String id)
    {
        funcoes.add(new Funcao(tipo, id));
    }
    
    public boolean isVariavel(String id)
    {
        for (Variavel v : this.varGlobal)
        {
            if (v.id.equals(id))
            {
                return true;
            }
        }
        return false;
    }
    
    public Variavel getVariavel(String id)
    {
        for (Variavel v : this.varGlobal)
        {
            if (v.id.equals(id))
            {
                return v;
            }
        }
        return null;
    }
    
    public boolean isConstante(String id)
    {
        for (Constante c : this.constantes)
        {
            if (c.id.equals(id))
            {
                return true;
            }
        }
        return false;
    }
    
    public Constante getConstante(String id)
    {
        for (Constante c : this.constantes)
        {
            if (c.id.equals(id))
            {
                return c;
            }
        }
        return null;
    }
    
    public boolean isFuncao(String id)
    {
        for (Funcao f : this.funcoes)
        {
            if (f.id.equals(id))
            {
                return true;
            }
        }
        return false;
    }
    
    public Funcao getFuncao(String id)
    {
        for (Funcao f : this.funcoes)
        {
            if (f.id.equals(id))
            {
                return f;
            }
        }
        return null;
    }
    
    public boolean ehPalavraDaLinguagem(String word)
    {
        //Verifica se a palavra usada é igual a um dos tipos
        if (word.equals("Real") || word.equals("Int") || word.equals("String") || word.equals("Boolean"))
        {
            return true;
        } 
        //Verifica se a palavra usada é igual a um dos laços ou if
        else if (word.equals("for") || word.equals("while") || word.equals("if") || word.equals("else"))
        {
            return true;
        }
        //Verifica se a palavra usada é igual a um then ou Prog ou return
        else if (word.equals("then") || word.equals("Progr") || word.equals("return"))
        {
            return true;
        }
        //Verifica se a palavra usada é igual a print ou scan
        else if (word.equals("print") || word.equals("scan"))// || word.equals("if") || word.equals("else"))
        {
            return true;
        }
        return false;
    }
}
