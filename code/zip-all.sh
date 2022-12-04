for LECTURE in  `ls -d lecture-*`; do
    zip -r -9 $LECTURE-code $LECTURE/*
done
mkdir build || true
mv *.zip build/
