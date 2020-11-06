grammar bp;

prog:					  BEGIN stm* END ;
stm:					  ID ASSIGN expr SEMI		# AssignStm
						| WRITE LBR ID RBR SEMI		# WriteStm
						| READ LBR ID RBR SEMI		# ReadStm
						;
expr:					  expr op=(AND | OR) expr	# BinOp
						| NEG expr					# NegOp
						| LBR expr RBR				# parens
						| BV						# boolV
						| ID						# id
						;

fragment Letter:		[a-zA-Z];
fragment Digit:			[0-9];
fragment UnderScore:	'_';

ASSIGN:					':=';
WRITE:					'write';
READ:					'read';
BEGIN:					'begin';
END:					'end';
LBR:					'(';
RBR:					')';
SEMI:					';';
AND:					'&';
OR:						'|';
NEG:					'~';


BV:						'true' | 'false';
ID:						Letter (Letter | Digit | UnderScore)*;

WS:						[ \t\n\r]+ -> skip;
