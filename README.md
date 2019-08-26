# groovyDataGenerator4SoapUI
Groovy scripts to generate fake data to use in SoapUI:

- *datosPersonas.groovy* generates "random" names, last names and emails in SoapUI
- *ci.groovy* could generate random 8 digit valid ci's or validate an existing one analyzing the validation digit

## datosPersonas

It get the names from a list of 3096 elements and the last names from a list of 624 elements, that gives a chance of 1 in 1931904 of getting the same combination of name + last name. Both lists were taken from the [Faker Library](https://github.com/peterdb/faker).

To increase the randomness, both name and last name are concatenated with a random integer from 0 to 999. That increase the chance of getting the same combination of strings for name and last name to 1 in 1921904000000.

Then, the email is generated as *name.lastname@gmail.com*.

An example of the result could be:

- Name: *Aaron1*
- Lastname: *Abbott999*
- Email: *Aaron1.Abbott999@gmail.com*

Finally, each value is saved in a SoapUI property (*Name1*, *Lastname1* and *Email1*).

## ci

It's the Groovy version of [this](https://github.com/picandocodigo/ci_js) JavaScript code.

It has 4 functions:

- *validation_digit(ci)* \- Generates the validation digit from the other remaining 7 digits of the ci
- *validate_ci(ci)* \- Validates if the id has a correct format, analyzing the validation digit
- *random_ci()* \- Returns a random valid ci between 0 and 9.999.999 with the validation digit
- *clean_ci(ci)* \- It basically removes any character that it's not a number from the ci (for example "." or "-")

Finally, the script creates a random ci and set a SoapUi property named "CI1" with its value.