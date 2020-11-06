@echo off
cd C:\Users\micha\cal
echo %cd%
CALL antlr4 cal.g4 -no-listener
echo Generating antlr files...
javac *.java
echo Compiling Java files...
:start
set /p file="Enter file name: "
CALL java Cal %file%
echo.
GOTO :start