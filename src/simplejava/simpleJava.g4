grammar simpleJava;
//Gramática do Moisés
@header{
    package simplejava;
    import java.util.Map;
    import java.util.HashMap;
}

@parser::members{
Map<String,Integer> tabSimb = new HashMap<String,Integer>();
}
programa: 'Prog' ID '{' (decVar|decConst)* decFunc* blocoMain '}'
        ;
//decVar: tipo listaIDs[$tipo.v] ';'
decVar: tipo listaIDs ';'
        ;

decConst: 'Static' tipo ID '=' valor ';'
        ;

decFunc: tipo ID '(' listaParametros ')' 
         '{' 
            (decVar)*
            blocoFunc
         '}'
       ;

blocoFunc: stmtf*
         ;

stmtf: ID '=' bool ';'
    | 'if' '(' bool ')' '{' stmtf* '}'
    | 'if' '(' bool ')' '{' stmtf* '}' 'else' '{' stmtf* '}'
    | 'while' '(' bool ')' '{' stmtf* '}'
    | 'break' ';'
    | 'for' '(' ID '=' bool 'to' bool ('step' bool)? ')' '{' stmtf* '}'
    | nativas
    | 'return' '(' bool ')' ';'
    | funcao
    ;

funcao:  ID '(' listaExpr ')' (';')?
      ;

nativas: 'print' '(' listaExpr ')' ';'
       | 'scan' '(' listaIDs ')' ';'
       ;

listaExpr: bool (',' bool)*
         ;

bool: bool '||' join
    | join
    ;

join: join '&&' equal
    | equal
    ;

equal: equal '==' rel
     | equal '!=' rel
     | rel
     ;

rel: expr '>' expr
   | expr '<' expr
   | expr '<=' expr
   | expr '>=' expr
   | expr
   ;
    
expr: expr '+' termo
    | expr '-' termo
    | termo
    ;

termo: termo '*' xp
     | termo '/' xp
     | xp
     ;

xp: xp '^' uni
  | uni
  ;

uni: '!' uni
   | '-' uni
   | fator
   ;

fator: '(' bool ')'
     | ID
     | NUM
     | 'TRUE'
     | 'FALSE'
     | STRING
     | funcao
     ;

listaParametros: parametro (',' parametro)*
               |
       ;

parametro: tipo ID 
       ;

listaIDs: ID (',' ID)*
        ;

tipo: 'Int'
    | 'Real'
    | 'String' 
    | 'Bool'
    ;

valor: NUM 
     | STRING
     ;

blocoMain: stmt*
     ;

stmt: ID '=' bool ';'//4
    | 'if' '(' bool ')' '{' stmt* '}' //7
    | 'if' '(' bool ')' '{' stmt* '}' 'else' '{' stmt* '}' //11
    | 'while' '(' bool ')' '{' stmt* '}'//7
    | 'break' ';'//2
    | 'for' '(' ID '=' bool 'to' bool ('step' bool)? ')' '{' stmt* '}'//13
    | nativas
    | funcao
    ;
     
ID:     [a-zA-Z]([a-zA-Z0-9])*
        ;

NUM:    [0-9]+('.'[0-9]+)?
        ;

STRING: '"'.*?'"'
        ;

WS  : (' '|'\r'|'\t'|'\u000C'|'\n') -> channel(HIDDEN)
    ;
COMMENT
    : '/*' .*? '*/' -> channel(HIDDEN)
    ;
LINE_COMMENT
    : '//' ~('\n'|'\r')* '\r'? '\n' -> channel(HIDDEN)
    ;