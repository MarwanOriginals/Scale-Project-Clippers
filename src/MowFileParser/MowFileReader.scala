package MowFileParser
import java.io.File

import MowItNow.Garden
import MowItNow.Mower
import javax.swing.JFileChooser
import javax.swing.filechooser.FileNameExtensionFilter

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

  def instructionFileChooser(): String = {
    val chooser = new JFileChooser
    chooser.setCurrentDirectory(new File("."))
    chooser.setDialogTitle("Select your instruction file")
    chooser.setFileSelectionMode(JFileChooser.FILES_ONLY)
    val filter = new FileNameExtensionFilter("TEXT FILES", "txt", "text")
    chooser.setFileFilter(filter)
    chooser.setAcceptAllFileFilterUsed(false)
    if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
      return chooser.getSelectedFile.getPath
    }
    else ""
  }

  def exportFileChooser(): String = {
    val chooser = new JFileChooser
    chooser.setCurrentDirectory(new File("."))
    chooser.setDialogTitle("Select your instruction file")
    chooser.setFileSelectionMode(JFileChooser.FILES_ONLY)
    val filter = new FileNameExtensionFilter("TEXT FILES", "txt", "text")
    chooser.setFileFilter(filter)
    chooser.setAcceptAllFileFilterUsed(false)
    if (chooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
      return chooser.getSelectedFile.getPath
    }
    else ""
  }
  
}