# cal Grammar

- This grammar is checking lexical and syntax analysis of files and returning whether the files parsed correctly or not. 
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

You can also use my batch file to check the 6 different files available.
**Note: You will have to edit the cd so it points to the right directory for you.** :
```
testcal.bat
```
