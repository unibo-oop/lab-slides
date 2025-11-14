flowchart RL

compile(compilazione)
compileTest(compilazione dei test):::test
staticAnalysis(analisi statica):::staticAnalysis
test(esecuzione dei test):::test
docs(generazione della documentazione):::docs
jar(costruzione dei deliverable):::jar
delivery(pubblicazione)
deploy(messa in produzione)
staticAnalysis --> compileTest --> compile
test --> compileTest
docs --> compile
jar --> compile
delivery --> test
delivery --> jar
delivery --> docs
deploy --> delivery --> staticAnalysis

