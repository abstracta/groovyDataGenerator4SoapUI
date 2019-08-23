def validation_digit(ci) {
	def a = 0
	def i = 0
	//if length of ci is less than 7 digits complete with 0's to the left
	if (ci.length() <= 6) {
    	for (i = ci.length(); i < 7; i++){
      		ci = '0' + ci;
    	}
  	}
  	for (i = 0; i < 7; i++) {
    	a += ("2987634"[i].toInteger() * ci[i].toInteger()) % 10
  	}
  	if ( (a%10).equals(0) ) {
    	return 0
  	} else {
    	return 10 - a % 10
  	}
}

def validate_ci(ci) {
  	ci = clean_ci(ci)
  	def dig = ci[ci.length() - 1]
  	ci = ci.replaceAll(/[0-9]$/, '')
  	return (dig == validation_digit(ci).toString())
}

def random_ci(){
	Random rnd = new Random()
	def ci = rnd.nextInt(10000000).toString()
	ci = ci.substring(0,7) + validation_digit(ci).toString()
	return ci
}

def clean_ci(ci){
  return ci.replaceAll(/\D/, '')
}