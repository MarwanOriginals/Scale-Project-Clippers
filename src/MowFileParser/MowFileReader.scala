package MowFileParser
import MowItNow.Garden
import MowItNow.Mower
import scala.io.Source

class MowFileReader {
    

  def readGarden(filePath: String): Garden = {
    var newGarden = new Garden()
    var i = 1
    for (line <- Source.fromFile(filePath).getLines) {
      if (i == 1) {
        val xCoord = line.split(" ")(0).toInt
        val yCoord = line.split(" ")(1).toInt
        newGarden = new Garden(xCoord, yCoord)
      }

      i = i + 1
    }

    return newGarden
  }

  def readMower(filePath: String): List[Mower] = {
    val instructionFile = filePath
    var lineNumber = 1
    var mowers: List[Mower] = List.empty[Mower]

    var tmp_xCoord = 0
    var tmp_yCoord = 0
    var tmp_direction = 'a'
    for (line <- Source.fromFile(instructionFile).getLines) {
      if(lineNumber % 2 == 0) {
        val xCoord = line.split(" ")(0).toInt
        val yCoord = line.split(" ")(1).toInt
        val direction = line.split(" ")(2)(0)
        tmp_xCoord = xCoord
        tmp_yCoord = yCoord
        tmp_direction = direction
      }
      if(lineNumber % 2 != 0 && lineNumber != 1) {
        var instructions: List[Char] = List.empty[Char]
        for (singleInstruction <- line) {
          instructions = instructions :+ singleInstruction
        }
        var currentMower = new Mower(tmp_xCoord, tmp_yCoord, tmp_direction, instructions)
        mowers = mowers :+ currentMower
      }
      lineNumber += 1
    }
    return mowers
  }
  
}