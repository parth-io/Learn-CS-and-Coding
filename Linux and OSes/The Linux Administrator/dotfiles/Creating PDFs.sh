#!/bin/bash
ps2pdf Letter.pdf Letter\ 2.pdf  #to compress
pdfunite Letter.pdf 66.pdf output.pdf # to combine, output.pdf is the name
zip y.zip ./final.pdf
