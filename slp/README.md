# slp Grammar

- This straight line programming language can recognise assigning variables and printing them.
- Make sure that the classpath points to antlr4 jar file.
- generate antlr files in terminal by entering:
```
antlr4 slp.g4 -visitor
```
- compile generated antlr files with:
```
javac *.java
```
- If all works, enter:
```
grun slp prog -gui file.slp
```

- This will look at each line of the file and create a graphic tree.
