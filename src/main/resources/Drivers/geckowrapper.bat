@ECHO OFF
ECHO Starting geckodriver: %0 %*
%CD%\drivers\geckodriver.exe --log fatal %* > NUL 2>&1