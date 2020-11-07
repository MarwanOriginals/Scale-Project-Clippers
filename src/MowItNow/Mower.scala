package MowItNow

class Mower(var x: Int = 0, var y: Int = 0, var  direction: Char = 'N') {

  def move(moveDirection: Char): Unit = {
    moveDirection match {
      case 'G' => direction match {
        case 'N' => this.direction = 'W'
        case 'E' => this.direction = 'N'
        case 'S' => this.direction = 'E'
        case 'W' => this.direction = 'S'
      }
      case 'D' => direction match {
        case 'N' => this.direction = 'E'
        case 'E' => this.direction = 'S'
        case 'S' => this.direction = 'W'
        case 'W' => this.direction = 'N'
      }
      case 'A' => direction match {
        case 'N' => this.y += 1
        case 'E' => this.x += 1
        case 'S' => this.y += -1
        case 'W' => this.x += -1
      }
    }
  }

}
