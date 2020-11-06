# Hello

- This grammar is a very simple introduction to antlr4.
- Input hello and a name.
- Hello will be matched along with the ID.

```antlr4
antlr4 Hello.g4 -no-listener -no-visitor
```

```antlr4
javac *.java
```

```antlr4
grun Hello r -tokens
```
