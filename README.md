# NoteMark


## Setup

Edit local properties with the following variables
- campusEmail=<YOUR_CAMPUS_EMAIL>

## Project Structure Ideas

- root
  - core
    - domain
      - auth
        * AuthInfo -> Model for storing access and refresh token
        * SessionStorage -> Class that describes how we are storing auth info
    - data
      - auth
        * EncryptedSessionStorage -> Implementation of session storage
    - presentation
      - design_system
        * Theme.kt
        * Type.kt
        * Color.kt
        - components
          * NoteMarkTextField (one example of something we would put here)
  - auth
    - data
      * AuthRepositoryImpl
      * EmailPatternValidator
      * RegistrationValidatorImpl
    - domain
      * AuthRepository
      * PatternValidator
      * RegistrationValidator
      * Registration -> class that holds all parameters needed for registration
    - presentation
      - registration
      - login
  - notes
    - data
    - domain
    - presentation
