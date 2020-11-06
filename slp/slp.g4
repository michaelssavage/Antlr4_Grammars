grammar slp;

//in this program, a statement is assigning an id, for example:
// a := 20;
// b := (40);
// c := 5 + 4;
// d := 20 / 6;
// this := is;

//another statement could be a print statement, for example:
// print (a,b);


prog:     stm*;
stm:      ID ASSIGN expr SEMI
        | PRINT LBR expr (COMMA expr)* RBR SEMI
        ;

expr:     expr op=(MULT | DIV) expr
        | expr op=(PLUS |MINUS) expr
        | LBR expr RBR
        | ID
        | NUMBER
        ;

fragment Letter:      [a-zA-Z];
fragment Digit:       [0-9];
fragment UnderScore:  '_';

ASSIGN:               ':=';
PRINT:                'print ';
LBR:                  '(';
RBR:                  ')';
SEMI:                 ';';
MULT:                 '*';
DIV:                  '/';
PLUS:                 '+';
MINUS:                '-';
COMMA:                ',';

ID:                   Letter (Letter | Digit | UnderScore)*;
NUMBER:               Digit Digit*;
WS:                   [ \t\n\r]+ -> skip;
