# cal Grammar

- This grammar is checking lexical and syntax analysis of files and returning whether the files parsed correctly or not. 
- It does this by overwriting the BaseErrorListener.java file and by halting the default error messages.
- There are **6 files** that can be read. They start with a comment that shows whether they should parse or not.
- We don't need a listener or visitor for this program:
```
antlr4 cal.g4 -no-listener
```

Compile java files:
```
javac *.java
```

The grun batch file can be used to show the parse tree:
```
grun bp prog -gui file4.cal
```

The Cal.java file can be run to test an input file also with a parsing message printed to System.out
```
java Cal file5.cal
```

You can also use my batch file to check the 6 different files available. :
```
testcal.bat
```

