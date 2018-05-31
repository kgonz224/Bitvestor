#	Makefile
#	Project: Bitvestor
#	Author(s): Eddie Noguera, Kevin Gonzalez
#	Creation Date: 05/31/2018
#

INPUT = input.txt
SOURCEFILES = Bitvestor.java GUI.java
RUNFILE = Bitvestor

test:
	make compile
	make run < $(INPUT)

compile: $(SOURCEFILES)
	javac $(SOURCEFILES)

run:
	java $(RUNFILE)
