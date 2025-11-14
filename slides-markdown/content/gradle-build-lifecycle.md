
flowchart RL

compile(compileJava)
compileTest(compileTestJava):::test
checkstyle(verifica di stile):::staticAnalysis
pmd(verifica di uso di buone pratiche di programmazione):::staticAnalysis
spotbugs(analisi del bytecode):::staticAnalysis
check(check):::check
test(test):::test
assemble(assemble):::jar
jar(jar):::jar
javadoc(javadoc):::docs
build(build):::build
assemble --> jar --> compile
spotbugs --> compile
check --> test --> compileTest --> compile
check --> checkstyle
check --> pmd
check --> spotbugs
javadoc --> compile
build --> check
build --> assemble
