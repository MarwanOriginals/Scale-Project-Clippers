package MowItNow
import MowFileParser.{MowFileReader, MowFileWriter}
import javax.swing.JOptionPane


object Main {

  def main(args: Array[String]): Unit = {
    try {
      val mowerInstructionFile = new MowFileReader
      val filePath = mowerInstructionFile.instructionFileChooser()
      val garden = mowerInstructionFile.readGarden(filePath)
      val mowers = mowerInstructionFile.readMower(filePath)
      var mowerNumber = 1
      var result = List.empty[String]
      for (mower <- mowers) {
        for (instruction <- mower.instructionList) { // Pour chaque instruction
          if(instruction == 'A' && garden.isMovePossible(mower)) {
            mower.move(instruction)
          } else if(instruction == 'G' || instruction == 'D') {
            mower.move(instruction)
          }
        }
        result = result :+ "Mower n°" + mowerNumber.toString + " - Position x : " + mower.x.toString + " position y : " +
          mower.y.toString + " direction : " + mower.direction.toString + "\n"
        mowerNumber += 1
      }
      val outputFile = new MowFileWriter
      val outputFilePath = mowerInstructionFile.exportFileChooser()
      outputFile.writeMowerInFile(outputFilePath, result)
    }
    catch {
      case _: Throwable =>
        JOptionPane.showMessageDialog(null, "Error, mower could not start properly", "An unexpected error occurred", 0)
    }


  }




}