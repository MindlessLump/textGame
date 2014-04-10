# Project Outline

### Location class
  - Contains a basic description of the `Location`
  - Has a list of items in the `Location`
  - Has a list of NPCs in the `Location`
  - Has a list of exits from the `Location`

### Exit class
  - Has a direction
  - Has a `Location` that it points to
  - Can be locked/unlocked

### Player class
  - Has an inventory of `Item`s
  - Has a current `Location`
  - *Has stats, e.g. Health, Strength, Speed?*

### Item class
  - Has a description
  - Has a name
  - Can be used
  - Can unlock `Exit`s

### Runner class
  - Initializes the `Location`s
  - Puts in the `Exit`s
  - Puts in the `Item`s
  - Prints location descriptions, listens for player input, and processes commands
  - *Randomly selects `Item`s from a pool?*
