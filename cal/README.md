# cal Grammar

- This grammar is checking lexical and syntax analysis of files and returning whether the files parsed correctly or not.
- We don't need a listener or visitor for this program:
```
antlr4 cal.g4 -no-listener
```

Compile java files:
```
javac *.java
```

Use can use the grun batch file like such:
```
grun bp prog -gui file6.cal
```

or you can use my batch file and check the 6 different files available:
```
testcal.bat
```

