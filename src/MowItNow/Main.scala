package MowItNow

import MowFileParser.MowFileReader

object Main {

  def main(args: Array[String]): Unit = {
    var test = new MowFileReader
    val garden = test.readGarden("E:\\IntelliJ\\Scale-Project-Clippers\\src\\MowFileParser\\instruction.txt")
    val mowers = test.readMower("E:\\IntelliJ\\Scale-Project-Clippers\\src\\MowFileParser\\instruction.txt")
    var mowerNumber = 1
    for (mower <- mowers) {
        for (instruction <- mower.instructionList) { // Pour chaque instruction
          if(instruction == 'A' && garden.isMovePossible(mower)) {
            mower.move(instruction)
          } else if(instruction == 'G' || instruction == 'D') {
            mower.move(instruction)
          }
        }
        println("Mower n°" + mowerNumber.toString + " - Position x : " + mower.x.toString + " position y : " + mower.y.toString + " direction : "
          + mower.direction.toString)
      mowerNumber += 1
    }



  }

}