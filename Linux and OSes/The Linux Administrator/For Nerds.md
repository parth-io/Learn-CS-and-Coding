Check if your system is little or big endian

```
Perl

# little
$ perl -MConfig -e 'print "$Config{byteorder}\n";'
12345678

# big
$ perl -MConfig -e 'print "$Config{byteorder}\n";'
87654321
od | awk

# little
$ echo -n I | od -to2 | awk 'FNR==1{ print substr($2,6,1)}'
1
$ echo -n I | od -to2 | awk '{ print substr($2,6,1); exit}'
1
$ echo -n I | hexdump -o | awk '{ print substr($2,6,1); exit}'

$ echo -n I | od -to2 | head -n1 | cut -f2 -d" " | cut -c6 
1
$ echo I | tr -d [:space:] | od -to2 | head -n1 | awk '{print $2}' | cut -c6
1


# big
$ echo -n I | od -to2 | awk 'FNR==1{ print substr($2,6,1)}'
0
$ echo -n I | od -to2 | head -n1 | cut -f2 -d" " | cut -c6 
0
$ echo I | tr -d [:space:] | od -to2 | head -n1 | awk '{print $2}' | cut -c6
0
```

