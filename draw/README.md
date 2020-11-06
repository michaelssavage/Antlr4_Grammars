# Draw Grammar

- Make sure that the classpath points to antlr4 jar file.
- generate antlr files in terminal by entering:
```
antlr4 draw.g4 -no-listener -visitor
```
- compile generated antlr files with:
```
javac *.java
```
- If all works, enter:
```
java Draw
```

| Command        | Description  |           
| ------------- |---------------|
| init x_size, y_size   | Creates a "window" of size x_size * y_size. The x_cursor and y_cursor are both set to 0.|
| down                  | Increments y_cursor                       |
| up                    | Decrements y_cursor                       |
| right                 | Increments x_cursor                       |
| left                  | Decrements x_cursor                       |
| draw                  | Sets the "pixel" at (x_cursor, y_cursor)  |
| display               | Display the "window"                      |
