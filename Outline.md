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
  - Has an inventory of `Items`
  - Has a current `Location`
  - *Has stats, e.g. Health, Strength, Speed?*

### Item class
  - Has a description
  - Has a name
  - Can be used
  - Can unlock `Exits`

### Runner class
  - Initializes the `Locations`
  - Puts in the `Exits`
  - Puts in the `Items`
  - Prints location descriptions, listens for player input, and processes commands
  - *Randomly selects `Item`s from a pool?*
