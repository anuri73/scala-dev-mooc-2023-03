package module1.hm.hm2

import scala.util.Random

object BallApp extends App {
  sealed private trait Ball
  private case class WhiteBall() extends Ball
  private case class BlackBall() extends Ball

  private val toBall: Int => Ball = {
    case 0 => WhiteBall()
    case 1 => BlackBall()
  }

  private val isPositive: Ball => Boolean = {
    case WhiteBall() => true
    case BlackBall() => false
  }

  private val count = 10_000_000

  private val balls = List.fill(count)(toBall(Random.nextInt(2)))

  private val countOfExperiments = balls.map(isPositive)

  private val countOfPositiveExperiments: Float = countOfExperiments.count(_ == true)

  val result: Double = countOfPositiveExperiments / count
}
