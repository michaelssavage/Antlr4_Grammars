# bp Grammar

- Binary Program checks True or False operators and outputs a boolean.
- It uses EvalVisitor which extends bpBaseVisitor.
- We don't need a listener so generate antlr files like such:
```
antlr4 bp.g4 -no-listener -visitor
```

Compile java files:
```
javac *.java
```

Use the grun batch file to check your own tokens:
```
grun bp prog -tokens
```

Use test1.bp as input:
```
java bp test1.bp
```
It will see read(a) and read(b) and output this to terminal:
> a: 
> b:
