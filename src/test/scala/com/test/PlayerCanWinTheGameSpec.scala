package com.test

import com.play.{Dice, Game}
import com.test.util.MockDice
import org.scalatest.mockito.MockitoSugar
import org.scalatest.{FeatureSpec, GivenWhenThen, Matchers}

/**
  * Created by prasadsriramula on 25/06/2017.
  */
class PlayerCanWinTheGameSpec extends FeatureSpec with GivenWhenThen with Matchers with MockitoSugar with MockDice {

  feature("Player Can Win the Game") {
    scenario("During Game, player can win if Dice rolls 3 when on square 97") {
      Given("the token is on square 97")
      val game = new Game
      val token = game.createNewToken
      game.rollDiceForToken(token,mockDiceRoll(96)) // moving it to 97th Position
      game.currentPosition(token) shouldBe 97

      When("When the token is moved 3 spaces")
      game.rollDiceForToken(token,mockDiceRoll(3))

      Then("the token is on square 100")
      game.currentPosition(token) shouldBe 100

      And ("the player has won the game")
      game.gameWinner.get shouldBe token

    }

    scenario("During Game, player can't win if Dice rolls 4 when on square 97") {
      Given("the token is on square 97")
      val game = new Game
      val token = game.createNewToken
      game.rollDiceForToken(token,mockDiceRoll(96)) // moving it to 97th Position
      game.currentPosition(token) shouldBe 97

      When("When the token is moved 4 spaces")
      game.rollDiceForToken(token,mockDiceRoll(4))

      Then("the token is on square 97")
      game.currentPosition(token) shouldBe 97

      And ("the player has not won the game")
      game.gameWinner shouldBe None

    }
  }

  }
