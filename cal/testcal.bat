@echo off
echo %cd%
CALL antlr4 cal.g4 -no-listener
echo Generating antlr files...
javac *.java
echo Compiling Java files...
echo.
FOR /L %%A IN (1,1,6) DO (
  CALL java Cal file%%A.cal
)
echo.
pause
