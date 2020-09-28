//Function to generate the validation digit of the id
def validation_digit(id) {
	def a = 0
	def i = 0
	//if length of id is less than 7 digits complete with 0's to the left
	if (id.length() <= 6) {
    for (i = id.length(); i < 7; i++){
      id = '0' + id
    }
  }
  for (i = 0; i < 7; i++) {
    a += ("2987634"[i].toInteger() * id[i].toInteger()) % 10
  }
  if ( (a%10).equals(0) ) {
    return 0
  } else {
   	return 10 - a % 10
	}
}

//Function to validate if the id has a correct format, analyzing the validation digit
def validate_id(id) {
	id = clean_id(id)
	def dig = id[id.length() - 1]
	id = id.replaceAll(/[0-9]$/, '')
	return (dig == validation_digit(id).toString())
}

//Function to get a random valid 7 digit id between 0 and 9.999.999 with the validation digit
def random_id(){
	Random rnd = new Random()
	def id = rnd.nextInt(10000000).toString()
	id = id.substring(0,7) + validation_digit(id).toString()
	return id
}

//Function to remove "." and "-", and basically every character that isn't a number from the id.
def clean_id(id){
  return id.replaceAll(/\D/, '')
}

def id = random_id()
//Set the id as a SoapUI property
testRunner.testCase.testSuite.setPropertyValue( "ID1", id)
println "ID: " + id + "."