>>Link to my 207 notes that you may find helpful: https://dramatic-sundae-d10.notion.site/CS-ARCHIVE-814540e347e349dc9e079fd8f753c003?pvs=4

## SignUp Use Case Implementation Example 
Here's the workflow of my implementation:
### Basic: workflow for everything but UI stuff (view model, view, presenter)
> I'd recommend following these steps if you're still unsure how to code w/ CA
1. **SignupInputData** ➡️ define a class w/ attributes for anything needed for inputs.
   1. Note: I'm just now realizing why this is useful, it basically means you don't need to edit all the parameters of the method in the event that you need to adjust what needs to be inputted. (So if you're calling the method multiple times, you don't need to adjust a bunch of parameters 😎)
2. **SignupInputBoundary(interface)** ➡️ literally just has an `execute(InputData)` method with SignupInputData as the parameters
   1. Note: input data is not actually necessary and dependent on the use case. In this case we do need input data tho
3. **SignupInteractor** ➡️ ***implements InputBoundary*** 
   1. The important method here is `execute(InputData)`, I wouldn't recommend writing any logic just yet since you will probably need other parts of the engine to make this work.
4. **SignupOutputBoundary(interface)** ➡️ create any methods for handling different output cases. For example, in week 5, we had a method for if the signup succeeded vs. failed. I assume you could make as many as you'd like for however many output scenarios there are.
   1. Ex. in week 5 we had `prepareFailView(OutputData)` and `prepareSuccessView(OutputData)`
   2. Side note: even though the interactor needs to use the presenter, we don't actually need to define it yet since we've defined it abstractly through an interface! 🫶🏻
      1. (Idk how to implement the presenter properly yet anyway)
   3. Side note 2: depending on your use case, you may not actually need output data. Regardless, you should still define an output boundary, so you can call the presenter
5. **SignupDataAccessInterface(interface)** ➡️ Define abstractly any methods you will need (related to data access) for the logic of your use case.
   1. Just think of what you may need for the logic of your interactor and define it, it doesn't matter since you don't need to implement it yet.
   2. Note: you may not need this if your use case doesn't need data access 
6. **Finish implementing your interactor**! 🤪
   1. The constructor should have these passed in as parameters, note when actually using them, you pass in their concrete implementations like _presenter_ and _data access object_:
      1. `SignupOutputBoundary()`
      2. `SignDataAccessInterface()` (optional) 
   2. Implement the logic for `execute(InputData)`
         