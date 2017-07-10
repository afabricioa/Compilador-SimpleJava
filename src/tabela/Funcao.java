/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tabela;

import java.util.ArrayList;
import simplejava.simpleJavaBaseListener;
import simplejava.simpleJavaParser.DecFuncContext;

/**
 *
 * @author Jonatas Laet
 */
public class Funcao extends simpleJavaBaseListener {
    ArrayList <Variavel> parametros;
    ArrayList <Variavel> varLocais;
    public int tipoRetorno;
    String id;
    
    public Funcao (int tipo, String id) {
        this.parametros = new ArrayList<>();
        this.varLocais = new ArrayList<>();
        this.tipoRetorno = tipo;
        this.id = id;
    }
    
    public int qtdParametros ()
    {
        int q = this.parametros.size();
        return q;
    }
    
    public void addVar (String id, int tipo)
    {
        String idParametro;
        int tipoParametro = 9;
        //String parametro = ctx.getText();
        //System.out.println("P=" + parametro);
        varLocais.add(new Variavel(id, tipo));
        //parametros.add(new Variavel(id, tipo));
    }
    
    public void addPar (String id, int tipo)
    {
        String idParametro;
        int tipoParametro = 9;
        //String parametro = ctx.getText();
        //System.out.println("P=" + parametro);
        parametros.add(new Variavel(id, tipo));
        //parametros.add(new Variavel(id, tipo));
    }
    
    public int getTipoParametro(int tipoPar, int pos)
    {
        int q = 0;
        for (Variavel v : this.parametros)
        {
            if (v.tipo == tipoPar && pos == q)
            {
                return v.tipo;
            }
            q++;
        }
        return -1;
    }
    
    public Variavel getVariavel(String id)
    {
        for (Variavel v : this.varLocais)
        {
            if (v.id.equals(id))
            {
                return v;
            }
        }
        for(Variavel v : this.parametros)
        {
            if (v.id.equals(id))
            {
                return v;
            }
        }
        return null;
    }
    
    public boolean isVarLocal(String id)
    {
        for (Variavel v : this.varLocais)
        {
            if (v.id.equals(id))
            {
                return true;
            }
        }
        return false;
    }
    
    public boolean isVariavel(String id)
    {
        for (Variavel v : this.varLocais)
        {
            if (v.id.equals(id))
            {
                return true;
            }
        }
        for (Variavel v : this.parametros)
        {
            if (v.id.equals(id))
            {
                return true;
            }
        }
        return false;
    }
    
    public boolean isParametro(String id)
    {
        for (Variavel v : this.parametros)
        {
            if (v.id.equals(id))
            {
                return true;
            }
        }
        return false;
    }
}
