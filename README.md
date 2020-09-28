# groovyScripts4SoapUI

Groovy scripts to manage test data in SoapUI projects.

- _takeDataFromFile.groovy_ get the data from the line _lineNo_ in _id.txt_ file and set the property _ID_ in SoapUi with that value
- _personsData.groovy_ generates "random" names, last names and emails in SoapUI
- _id.groovy_ could generate random 8 digit valid id's or validate an existing one analyzing the validation digit
- _mongoDBExamples_ has examples for connecting to a Mongo database and performing actions over collections.

## takeDataFromFile

In order to have this script working, you should replace _route-to-file_ in line 4 with the directory where _id.txt_ file it's located, and declare _ID_ and _lineNo_ properties in SoapUI.

If you want to start getting data from the first line you should set _lineNo_ to 0 in SoapUI.

## personsData

It get the names from a list of 3096 elements and the last names from a list of 624 elements, that gives a chance of 1 in 1931904 of getting the same combination of name + last name. Both lists were taken from the [Faker Library](https://github.com/peterdb/faker).

To increase the randomness, both name and last name are concatenated with a random integer from 0 to 999. That increase the chance of getting the same combination of strings for name and last name to 1 in 1921904000000.

Then, the email is generated as _name.lastname@gmail.com_.

An example of the result could be:

- Name: _Aaron1_0
- Lastname: _Abbott999_
- Email: _Aaron1.Abbott999@gmail.com_

Finally, each value is saved in a SoapUI property (_Name1_, _Lastname1_ and _Email1_).

## id

It's the Groovy version of [this](https://github.com/picandocodigo/ci_js) JavaScript code.

It has 4 functions:

- _validation_digit(id)_ \- Generates the validation digit from the other remaining 7 digits of the id
- _validate_id(id)_ \- Validates if the id has a correct format, analyzing the validation digit
- _random_id()_ \- Returns a random valid id between 0 and 9.999.999 with the validation digit
- _clean_id(id)_ \- It basically removes any character that it's not a number from the id (for example "." or "-")

Finally, the script creates a random id and set a SoapUi property named "ID1" with its value.

## mongoDBExamples

In order to use this script you will need the [mongo-java-driver jar](https://mvnrepository.com/artifact/org.mongodb/mongo-java-driver) on the lib folder where you have SoapUI installed.

This script defines a class that has methods for connecting to a client and getting collections from a database, the methods are the following:

- _client()_ \- Creates and returns a new Mongo Client.
- _collection(databaseName, collectionName)_ \- Gets a Mongo database and returns a collection.

In addition to that, there are some examples that show how to perform some actions over collections, such as iteration over elements, finding documents and making updates.
