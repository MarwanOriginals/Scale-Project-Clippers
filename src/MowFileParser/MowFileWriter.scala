package MowFileParser

import java.io.{BufferedWriter, File, FileWriter}

class MowFileWriter {

  def writeMowerInFile(filename: String, lines: Seq[String]): Unit = {
    val file = new File(filename)
    val bw = new BufferedWriter(new FileWriter(file))
    for (line <- lines) {
      bw.write(line)
    }
    bw.close()
  }


}
