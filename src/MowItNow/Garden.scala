package MowItNow

class Garden(var max_x: Int = 0, var max_y: Int = 0) {
  val min_x = 0
  val min_y = 0

  def isMovePossible(movingMower: Mower): Boolean = {
    movingMower.direction match {
      case 'N' => if(movingMower.y + 1 > this.max_y) false else true
      case 'E' => if(movingMower.x + 1 > this.max_x) false else true
      case 'S' => if(movingMower.y - 1 < this.min_y) false else true
      case 'W' => if(movingMower.x - 1 < this.min_x) false else true
    }
  }
}
