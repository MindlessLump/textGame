# Project Outline

#### Location class
  - Contains a basic description of the `Location`
  - Has a list of items in the `Location`
  - Has a list of NPCs in the `Location`
  - Has a list of exits from the `Location`
  - Inputted to the game via a file:
    * Location name
    * Location description

#### Exit class
  - Has a direction
  - Has a `Location` that it points to
  - Can be locked/unlocked
  - Inputted to the game via a file:
    * Location number where it originates
    * Location number to which it points
    * Direction number
    * Exit description
    * Whether it is locked (If locked, then "locked")

#### Item class
  - Has a description
  - Has a name
  - Can be used
  - Can unlock `Exits`
  - Inputted to the game via a file:
    * Item name
    * Location number of where it is
    * Place description
    * Item description
    * An onPickup command
    * An onUse command
    * An onTargetUse command
    * Number of uses (-# for infinite)

#### Background class
  - Contains the player variables (current location and inventory)
  - Interacts with Location, Exit, and Item classes
  - Runner class only interacts with Background class

#### Runner class
  - Should only handle logic and call methods of the Background class.
  - The Background class will handle the rest
