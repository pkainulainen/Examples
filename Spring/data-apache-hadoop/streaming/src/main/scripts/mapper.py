#!/usr/bin/python
# -*- coding: utf-8 -*-

import sys
import unicodedata

# Removes punctuation characters from the string
def strip_punctuation(word):
    return ''.join(x for x in word if unicodedata.category(x) != 'Po')

#Process input one line at the time
for line in sys.stdin:
    #Converts the line to Unicode
    line = unicode(line, "utf-8")
    #Splits the line to individual words
    words = line.split()
    #Processes each word one by one
    for word in words:
        #Removes punctuation characters
        word = strip_punctuation(word)
        #Prints the output
        print ("%s\t%s" % (word, 1)).encode("utf-8")



