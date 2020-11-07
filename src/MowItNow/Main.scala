package MowItNow

object Main {

  def main(args: Array[String]): Unit = {
    var myGarden = new Garden(5, 5)
    var myMower1 = new Mower(3, 3, 'E')
    var listOfInstructions: List[Char] = List('A', 'A', 'D', 'A', 'A', 'D', 'A', 'D', 'D', 'A')
    for (instruction <- listOfInstructions) {
      if(instruction == 'A' && myGarden.isMovePossible(myMower1)) {
        myMower1.move(instruction)
      } else if(instruction == 'G' || instruction == 'D') {
        myMower1.move(instruction)
      }
    }
    println("Position x : " + myMower1.x.toString + " position y : " + myMower1.y.toString + " direction : "
    + myMower1.direction.toString)

    myGarden = new Garden(5, 5)
    myMower1 = new Mower(1, 2, 'N')
    listOfInstructions = List('G', 'A', 'G', 'A', 'G', 'A', 'G', 'A', 'A')
    for (instruction <- listOfInstructions) {
      if(instruction == 'A' && myGarden.isMovePossible(myMower1)) {
        myMower1.move(instruction)
      } else if(instruction == 'G' || instruction == 'D') {
        myMower1.move(instruction)
      }
    }
    println("Position x : " + myMower1.x.toString + " position y : " + myMower1.y.toString + " direction : "
      + myMower1.direction.toString)
  }

}
