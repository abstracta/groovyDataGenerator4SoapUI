# groovyDataGenerator4SoapUI
Groovy script to generate "random" names, last names and emails in SoapUI. 

It get the names from a list of 3096 elements and the last names from a list of 624 elements, that gives a chance of 1 in 1931904 of getting the same combination of name + last name. Both lists were taken from the [Faker Library](https://github.com/peterdb/faker).

To increase the randomness, both name and last name are concatenated with a random integer from 0 to 999. That increase the chance of getting the same combination of strings for name and last name to 1 in 1921904000000.

Then, the email is generated as *name.lastname@gmail.com*.

An example of the result could be:

- Name: *Aaron1*
- Lastname: *Abbott999*
- Email: *Aaron1.Abbott999@gmail.com*

Finally, each value is saved in a SoapUI property (*Name1*, *Lastname1* and *Email1*).
