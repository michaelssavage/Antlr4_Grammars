# Antlr4_Grammars
Antlr4 is used for lexical, syntax, and semantic analysis of structured text.

From the website:
```
Download https://www.antlr.org/download/antlr-4.8-complete.jar.
Add antlr4-complete.jar to CLASSPATH, either:
  Permanently: Using System Properties dialog > Environment variables > Create or append to CLASSPATH variable
  Temporarily, at command line:

    SET CLASSPATH=.;C:\Javalib\antlr4-complete.jar;%CLASSPATH%

Create batch commands for ANTLR Tool, TestRig in dir in PATH

   antlr4.bat: java org.antlr.v4.Tool %*
   grun.bat:   java org.antlr.v4.gui.TestRig %*
 ```

For myself I had to make sure the classpath in environment variables pointed to the antlr4-complete.jar. If you have Java like me installed append it as such:
```
.;
antlr4-complete.jar;
```

If using VSCode, the referenced libraries need to be set to the antlr jar also.

