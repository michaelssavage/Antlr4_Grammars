// Define a grammar called Hello
grammar Hello;
r  : 'hello' ID ;         // match keyword hello followed by an identifier
ID : [a-z]+ ;             // match lower-case identifiers
WS : [ \t\r\n]+ -> skip ; // skip spaces, tabs, newlines



// cd to right location so
// ==> $cd antlr4/hello
// then generate parser and lexer
// ==> $antlr4 Hello.g4
// compile generated java code with
// ==>  $javac *.java

// then start grammar by typing
//==> $grun Hello r -tokens
