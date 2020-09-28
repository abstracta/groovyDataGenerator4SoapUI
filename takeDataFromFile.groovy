//Take the patients' ID form a file:
//------------------------------------------
//read the file
def file = new File("C:/script/id.txt");
def lines = file.readLines(); //add elements to an array
def maxlines = lines.size(); //quantity of elements in the array

//Set the variable "ID" with the value of the line "lineNo"
testRunner.testCase.setPropertyValue("ID",lines[testRunner.testCase.getPropertyValue("lineNo").toInteger()]);
log.info("ID: " + testRunner.testCase.getPropertyValue("ID"));

//Increase or reset the line counter "lineNo"
if (testRunner.testCase.getPropertyValue("lineNo").toInteger() == (maxlines - 1)){
	testRunner.testCase.setPropertyValue("lineNo", String.valueOf(0));
} else {
	testRunner.testCase.setPropertyValue("lineNo", String.valueOf(testRunner.testCase.getPropertyValue("lineNo").toInteger() + 1));
}
//------------------------------------------