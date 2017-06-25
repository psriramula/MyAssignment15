package com.play

import scala.collection.mutable
import scala.util.Random

/**
  * Created by prasadsriramula on 23/06/2017.
  */
class Game {


  val startingPoint = 1
  val maxSquare = 100
  val winSquare = 100

  private var winnerToken: Option[Token] = None
  private val tokenInPlay = mutable.Map[Token, Int]()

  def currentPosition(token: Token): Int = tokenInPlay(token)

  def createNewToken(): Token = {
    val token = new Token
    move(token, startingPoint)
    token
  }


  private def move(token: Token, square: Int) = tokenInPlay += token -> square

  def rollDiceForToken(token: Token, dice:Dice): Unit = {
    require(winnerToken.isEmpty, message = "The game has already ended")
    val square = currentPosition(token) + dice.rollDice
    if (square <= maxSquare) move(token, square)
    if (square == winSquare) winnerToken = Some(token)
  }

}

class Token

class Dice{
  val minDiceNum = 1
  val maxDiceNum = 6
  val rollDice = minDiceNum + Random.nextInt(maxDiceNum - minDiceNum + 1)
}
