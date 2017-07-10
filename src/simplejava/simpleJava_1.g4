grammar simpleJava;

@header{
package simplejava;
import java.util.Map;
import java.util.HashMap;
}

@parser::members{
Map<String,Integer> tabSimb = new HashMap<String,Integer>();
}
programa: 'Prog' ID '{' (decVar|decConst)* decFunc blocoMain '}'
        ;
decVar: tipo listaIDs[$tipo.v] ';'
      ;
decConst: 'Static' tipo ID '=' valor ';'
        ;
tipo returns [int v]
    : 'Int'    {$v = 1;}
    | 'Real'   {$v = 2;}
    | 'String' {$v = 3;}
    | 'Bool'   {$v = 4;}
    ;
listaIDs[int t]: ID (',' ID)*
        ;
valor: NUM
     | STRING
     ;
decFunc: /* empty */
       ;
blocoMain: /* empty */
         ;

Tk_Prog: 'Prog';
ID: [a-zA-Z]([a-zA-Z0-9])*
  ;
NUM:[0-9]+('.'[0-9]+)?
   ;
STRING: '"' .*? '"'
      ;
WS: [ \t\r\n]+ -> skip;

