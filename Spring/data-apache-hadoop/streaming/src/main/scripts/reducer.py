#!/usr/bin/python
# -*- coding: utf-8 -*-s

import sys

wordCount = 0

#Process input one line at the time
for line in sys.stdin:
    #Converts the line to Unicode
    line = unicode(line, "utf-8")
    #Gets and value from the current line
    (key, value) = line.split("\t")
    if key == "Watson":
        #Increase word count by one
        wordCount = int(wordCount + 1);
#Prints the output
print ("Watson\t%s" % wordCount).encode("utf-8")