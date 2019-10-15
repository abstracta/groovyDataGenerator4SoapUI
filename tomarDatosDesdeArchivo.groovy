//Tomar ci de pacientes desde archivo:
//------------------------------------------
//leer archivo
def file = new File('<route-to-file>/ci.txt');
def lines = file.readLines(); //cargar datos en un arreglo
def maxlines = lines.size(); //cantidad de datos en el arreglo
//Cargar el valor de la línea "lineNo" del archivo, en la variable "CI"
testRunner.testCase.setPropertyValue("CI",lines[testRunner.testCase.getPropertyValue("lineNo").toInteger()]);
log.info("CI: " + testRunner.testCase.getPropertyValue("CI"));

//Aumento o reseteo del contador de líneas "lineNo":
if (testRunner.testCase.getPropertyValue("lineNo").toInteger() == (maxlines - 1)){
	testRunner.testCase.setPropertyValue("lineNo", String.valueOf(0));
} else {
	testRunner.testCase.setPropertyValue("lineNo", String.valueOf(testRunner.testCase.getPropertyValue("lineNo").toInteger() + 1));
}
//------------------------------------------