package com

import scala.collection.mutable

/**
  * Created by prasadsriramula on 23/06/2017.
  */
class Game {


  val startingPoint = 1
  val maxSquare = 100
  val winSquare = 100

  private val tokenInPlay = mutable.Map[Token, Int]()

  def currentPosition(token: Token): Int = tokenInPlay(token)

  def createNewToken(): Token = {
    val token = new Token
    move(token, startingPoint)
    token
  }


  private def move(token: Token, square: Int) = tokenInPlay += token -> square

}

class Token
