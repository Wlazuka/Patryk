# Validations. google Email

The purpose of this exercise is to train you to work with string values.

Estimated workload of this exercise is _45 min_.

### Description

Please, implement `validateEmail` method
in [`EmailValidation`](src/main/java/validations/EmailValidation.java):

This method checks the input string for compliance with the rules for a regular GOOGLE email. Let us define them:

- A regular GOOGLE email includes firstname and lastname (in English), separated by underscore ("_").
- GOOGLE email always ends with "@google.com"
- When a person gets new GOOGLE email, but email with this firstname and lastname is already registered, we add "1" to the
  new email. If such email is registered as well, we use "2" and so on.

While implementing the method you might need to come up with *regular expressions*. You may consider
using [regex101.com](https://regex101.com/) to ease designing them.

Note that input value may be null.

You can and should use following methods\classes:

- [`matches`](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/lang/String.html#matches(java.lang.String))
- [`Pattern`](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/regex/Pattern.html)
- [`Matcher`](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/regex/Pattern.html#matcher(java.lang.CharSequence))

### Examples

- Valid examples

      william_shakespeare@google.com
      lu_e@google.com
      william_shakespeare1@google.com 
      william_shakespeare2@google.com

- Invalid examples

       william@google.com
       william.shakespeare@google.com
       william...shakespeare@google.com
       william-shakespeare@google.com
       shakespeare123@google.com
       william_$hakespeare@google.com