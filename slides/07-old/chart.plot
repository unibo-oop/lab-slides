 
set terminal pdfcairo

set title "Versioning system adoption according to the Eclipse Community Survey"
set xlabel "Year"
set ylabel "Adoption %"

set key autotitle columnheader
set key below
set output 'img/chart.pdf'
set style data histograms
set style histogram rowstacked
set style fill solid border -1
plot 'datafromeclipse' using 2:xtic(1), for [i=3:5] '' using i
    
