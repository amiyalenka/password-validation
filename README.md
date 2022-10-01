# password-validation
Problem statement 2: Password Validation
We like to build code for purposes of password verification. Verification will fail if any one
of the rules mentioned does not pass.
1. Implement the following rules. Each one of these will throw an exception with a
different message of your choice

    a. - password should be larger than 8 chars
    
    b. - password should not be null
    
    c. - password should have one uppercase letter at least
    
    d. - password should have one lowercase letter at least
    
    e. - password should have one number at least
    
2. Add feature: Password is OK if at least three of the previous conditions is true
3. Add feature: password is never OK if item 1.d is not true.
4. Assume Each verification takes 1 second to complete. How would you solve items 2
and 3 so tests can run faster?

Assumptions:

1. Validator will neither throw exception nor let know the unsatisfied rules when the password valid.

Understanding:

1. If the password is null then all other conditions will not be satisfied. So, password will be invalid. Throw exception when it is null.
2. From the three conditions meeting criteria, two are mandatory which are not null and minimum one lowercase character. 
So, out of the remaining criteria's (one UpperCase, one number and minimum length greater than 8) if any one is met then it will be considered as valid password.  