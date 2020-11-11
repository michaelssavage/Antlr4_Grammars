# Declaration on Plagiarism

# Assignment Submission Form

This form must be filled in and completed by the student(s) submitting an assignment

|                       |                                                   |
|-----------------------|---------------------------------------------------|
|Name(s):               | **Michael Savage**                                |
|Programme:             | **Computer Applications**                         |
|Module Code:           | **CA4003**                                        |
|Assignment Title:      | **Assignment 1: A Lexical and Syntax Analyser**   |
|Submission Date:       | **12/11/2020**                                    |
|Module Coordinator:    | **Dr. David Sinclair**                            |


I declare that this material, which I now submit for assessment, is entirely my own work and has not been taken from the work of others, save and to the extent that such work has been cited and acknowledged within the text of my work. I understand that plagiarism, collusion, and copying are grave and serious offences in the university and accept the penalties that would be imposed should I engage in plagiarism, collusion or copying. I have read and understood the Assignment Regulations. I have identified and included the source of all facts, ideas, opinions, and viewpoints of others in the assignment references. Direct quotations from books, journal articles, internet sources, module text, or any other source whatsoever are acknowledged and the source cited are identified in the assignment references. This assignment, or any part of it, has not been previously submitted by me or any other person for assessment on this or any other course of study. 


I have read and understood the referencing guidelines found at http://www.dcu.ie/info/regulations/plagiarism.shtml , https://www4.dcu.ie/students/az/plagiarism and/or recommended in the assignment guidelines. 



Name(s):  **Michael Savage**
Date: **12/11/2020**

---

# Assignment 1: A Lexical and Syntax Analyser

## “The aim of this assignment is to implement a lexical and syntax analyser using Antlr4 for a simple language called CAL.”

For this assignment, I created a parser that took input from a file and outputted to the terminal whether or not a file was parsed successfully. I did this by reimplementing the BaseErrorListener.java file and creating my own error listener. I tested my parser with a really simple batch file. The testCal.bat file made things easy by testing the 6 different files in quick succession. 

(images/figure1.png "Figure 1")
*Figure 1: batch file that generates, compiles and runs java files.*

(images/figure2.png "Figure 2)
*Figure 2: Output from executing the batch file*

## Lexical Analysis
Lexical analysis is needed to identify tokens by using rules. The tokens in this assignment consist of reserved words, operational tokens, integers, identifiers, and Comments.

**1.	Reserved Words**

These words will take precedence over identifiers. They are not case sensitive so fragments are used to point to the uppercase and lowercase literal of each letter. 

**2.	Operational Tokens**

These are the simplest terminal tokens. They match certain characters or sequence of characters.

**3.	Integers**

Numbers are handled by matching tokens or the literal ‘0’.  Numbers can start with the numbers from 1-9 and then be followed by any amount of  0-9 numbers shown with *. Integers cannot start with a zero unless it is ‘0’ on its own. Numbers can also start with an optional minus shown by ?.

(images/figure3.png "Figure 3")
*Figure 3: Number Lexer Rule*

**4.	Identifiers**

IDs match terminal rules. The first character must be a letter followed by any amount of letters, underscores or integers. This choice is shown by using vertical bars. Again, reserved words will precede IDs. For example, ‘constant’ will match a reserved word and ‘constants’ will match an ID.
 
(images/figure4.png "Figure 4")
*Figure 4: ID Lexer Rule*

(images/figure5.png "Figure 5")
*Figure 5: Fragment rules for numbers and identifiers*

**5.	Comments**

There are two type of comments that are acceptable. Nested multi-line comments shown by /* … */ and single line comments starting with ‘//’. When these characters are read, they are discarded.

(images/figure6.png "Figure 6")
*Figure 6: Multi-line comments and single-line comments*

## Syntax Analysis

Syntax analysis is needed to interpret the sequence of tokens and make sure it fulfils syntax rules. It deals with a set of non-terminals with prog being designated start symbol.

**1.	Parse Tree**

One of the main syntax rules is the optionality of a non-terminal in places. The prog rules states that the arguments must be decl_list, function_list and main. Both decl_list and function_list can be empty by having a ? after the parse rule. This is shown in figure 7 below that decl_list can be empty and not be used.

(images/figure7.png "Figure 7")
*Figure 7: file2.cal parse tree*

**2.	Error Handling**

For handling errors I used CalErrorListener.java to extend the BaseErrorListener.java. The default behaviour for the syntaxError method is to print the error message to the terminal containing information about the problem. I removed this behaviour and instead worked on returning a Boolean value to the main Cal.java file.
I was pointed in the right direction by finding the following question on Stackoverflow.

https://stackoverflow.com/questions/18132078/handling-errors-in-antlr4 

From this answer, I went back to the antlr4 source code to line 276 of TestPerformance.java. I found that REPORT_SYNTAX_ERRORS is just a private static Boolean and I decided I would implement my own private static Boolean, NO_ERRORS, that could be manipulated with setter and getter functions.

https://github.com/antlr/antlr4/blob/98dc2c0f0249a67b797b151da3adf4ffbc1fd6a1/tool-testsuite/test/org/antlr/v4/test/tool/TestPerformance.java 
 
(images/figure8.png "Figure 8")
*Figure 8: NO_ERRORS Boolean variable*

Now, if there was an error in the parsing, the setter and getter methods will be used to get the value of the NO_ERRORS variable and print the relevant message. 
 
(images/figure5.png "Figure 5")
*Figure 9: Setter and getter methods*

## Conclusion

Antlr4 is an interesting and powerful parser generator. It is really easy to read and it was a fun challenge translating the pseudocode into the grammar file. I have a far better understanding of parse trees, grammars, and syntax analysis.
