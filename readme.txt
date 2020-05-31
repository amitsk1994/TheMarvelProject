The Marvel Project

Functionality 1: To extract all the comic characters from Marvel API

     - The main class file is Root.java
     - AllCharacters.java has all the API definitions including the private keys and public keys
     - Marvel API needs a md5 hashing of the public and private key with a time stamp. MD5 logic is in the MD5Utils.java
     - JsonReader.java is to support json parsing of the API response
     - Task.java is to parallelize request, to provide pagination and quicker execution. org.json jar has been used for parsing.
     - I have used a thread pool of 10 threads for a total of over 1400 results to have a good balance.
