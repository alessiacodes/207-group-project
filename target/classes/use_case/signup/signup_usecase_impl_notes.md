Here was what I was thinking for how this use case might run:
1. input all required fields, since there is alot, we will likely have to run checks to ensure that the data is valid. (i.e. is their age a positive number?)
    1. For now, I think we can stick with just saving the data and checking if the username already exists
2. If inputs are okay ➡️ save info in database and display success window.
   3. Smth like "Successfully added account, `username`. Welcome to MARVN!"
3. If inputs invalid ➡️ prompt inputs again and display appropriate error messages