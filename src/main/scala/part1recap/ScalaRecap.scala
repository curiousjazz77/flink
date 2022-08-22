package part1recap

import java.time.Instant
import java.util.UUID

/**
 * A package describing events related to a multiplayer game.
 * We analyze some essential Flink features based on these data types.
 */
object ScalaRecap {

  val aBoolean: Boolean = false
  var aVariable: Int = 56
  aVariable += 1

  //expresion
  val anIfExpression: String = if (2 > 3) "bigger" else "smaller"

  //instructions
  val theUnit: Unit = println("Hello, Scala") //Unit == void

  //OOP
  class Animal
  class Cat extends Animal
  trait Carnivore { //interface; dont need to define implementation; only methods
    def eat(animal: Animal)
  }
  //abstract classes also exist.

  class Crocodile extends Animal with Carnivore{
    override def eat(animal: Animal): Unit = println("eating this poor fellow")
  }

  //singleton object; useful when want to create messages for actors like we see
  // in the akka essentials course
  object MySingleton

  //companions
  object Carnivore

  //case classes
  case class Person(name:String, age:Int)

  //generics
  class MyList[A] // can add variance modifiers; quite complicated and not important for this course

  //method notation
  //croc.eat(animal) OR croc eat animal
  val three = 1 + 2 //method in infix notation
  val three_v2 = 1.+(2) //same as above but method notation

  //functional programming - functions as first class elements of our code; we can pass around functions,
  // modify them and return a result just like any other values
  val incrementer: Int => Int = x => x + 1
  val incremented = incrementer(4) //returns 5
  //incrementer invoked with argument four is same as incrementar.apply(4)
  incrementer.apply(4)

  //functions used quite a lot in scala; map, flatmap, filter; often used on collections
  //higher order functions
  val processed_list = List(1, 2, 3).map(incrementer) //each one will be incremented
  val aLongerList = List(1,2,3).flatMap(x => List(x, x+1)) //[1,2, 2,3, 3,4]

  //for comprehensions
  //if want to do crossproduct of list of 3 numbers and 3 characters
  val checkerboard = List(1,2,3).flatMap(n => List('a','b', 'c').map(c => (n,c)))

  val checkerboard_v2 = for {
    n <- List(1,2,3)
    c <- List('a', 'b', 'c')
  } yield (n,c) //same

  //options and try -> to manage the absence of values or the potential that a computation may fail
  val anOption: Option[Int] = Option(/*something that might be null*/ 43)
  val doubleOption = anOption.map(_*2) //shorthand for x => x * 2


  def main(args: Array[String]): Unit = {

  }
}