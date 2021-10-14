import java.util.*

class Robot {
    var direction: String = ""
    var x: Int = 0
    var y: Int = 0

    fun turnLeft() {
        when (direction) {
            "N" -> direction = "W"
            "W" -> direction = "S"
            "S" -> direction = "E"
            "E" -> direction = "N"
        }
    }

    fun turnRight() {
        when (direction) {
            "N" -> direction = "E"
            "E" -> direction = "S"
            "S" -> direction = "W"
            "W" -> direction = "N"
        }
    }

    fun advance() {
        when (direction) {
            "N" -> y += 1
            "E" -> x += 1
            "S" -> y -= 1
            "W" -> x -= 1
        }
    }
}

fun main() {
    val robot = Robot()

    val scanner = Scanner(System.`in`)

    print("Enter robot's position: ")
    robot.x = scanner.nextInt()
    robot.y = scanner.nextInt()

    do {
        print("Enter robot's direction: ")
        val dir = scanner.next()
        robot.direction = checkDirection(dir)
    } while (checkDirection(dir) == "-1")

    print("Enter your instruction: ")
    val ins = scanner.next()

    for (i in ins.indices) {
        when (ins[i]) {
            'R' -> robot.turnRight()
            'L' -> robot.turnLeft()
            'A' -> robot.advance()
        }
    }

    println("Position of robot according to your instruction: {${robot.x}, ${robot.y}}")
    println("and its direction: ${robot.direction}")
}

fun checkDirection(s: String): String {
    return if (s.equals("N", ignoreCase = true) || s.equals("North", ignoreCase = true)) {
        "N"
    } else if (s.equals("W", ignoreCase = true) || s.equals("West", ignoreCase = true)) {
        "W"
    } else if (s.equals("S", ignoreCase = true) || s.equals("South", ignoreCase = true)) {
        "S"
    } else if (s.equals("E", ignoreCase = true) || s.equals("East", ignoreCase = true)) {
        "E"
    } else {
        "-1"
    }
}