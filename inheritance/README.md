# Composition and Inheritance

this file contains solution for the sixth lab of java401d5 course

and it contains:

1. **Place** an abstract Class for creating all the method so the other classes can take its method and all property
    - test for the abstract class alone.
2. **Restaurant** Class that extend place create an object by passing the name as String, the rating as number from 0,5
   and the price as String of dollar sign "$"
    - **restaurantTest** unit test will test the creating editing and all the functionality inside the Restaurant Class.
3. **Shop** Class that extend place, create an object by passing the name as String, the rating as number from 0,5,
   description as string and the price as String of dollar sign "$"
    - **ShopTest** unit test will test the creating editing and all the functionality inside the Shop Class.
4. **Theater** Class that extend place, create an object by passing the name as String and the rating as number from
   0,5,
    - **TheaterTest** unit test will test the creating editing and all the functionality inside the Theater Class.
5. **Review** Class that create an object by passing the required parameters, and you have 3 options
    1. passing the place you want to review, body of the review, name of the author and your rating for this review and
       this will update the review for the desire place automatically
    2. passing the body of the review, the author and your rating for this place this will not update any place rating
       until you run the method `place.addReview(review)` and this will add it to the desire place.
    3. the same as the first one but instead of the author name you can pass the user instance of the User Class (we
       will talk about this class in the next point), this will also automatically add the review to the desire place.

    - **reviewTesting** unit test that will test and make sure all the method inside the Review class work fine with no
      duplicate and update the desire place.

6. **User** class that create a user that you can then pass it to the certain review to certain place.
    - All the user test are include in the reviewTest and other test.

## Usage

For testing Run

`$ gradle test`

For running and seeing the output of the Library use your intellij IDEA.

