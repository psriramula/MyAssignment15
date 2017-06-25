package com.test

import com.play.{Dice, Game}
import com.test.util.MockDice
import org.scalatest.mockito.MockitoSugar
import org.scalatest.{FeatureSpec, GivenWhenThen, Matchers}

/**
  * Created by prasadsriramula on 25/06/2017.
  */
class MovesAreDeterminedByDiceRollsSpec extends FeatureSpec with GivenWhenThen with Matchers with MockitoSugar with MockDice {

  feature("Moves Are Determined By Dice Rolls") {
    scenario("Starting Game and token on square 1") {
      Given("the game is started")
      val game = new Game
      val token = game.createNewToken

      When("the player rolls a die")
      val dice = new Dice
      game.rollDiceForToken(token, dice)

      Then("the result should be between 1-6 inclusive")
      val result = game.currentPosition(token)
      (result >= 1 && result <= 6) shouldBe true

    }

    scenario("Token should move as per the Dice roll") {

      val game = new Game
      val dice = new Dice
      val token = game.createNewToken
      game.rollDiceForToken(token, dice)
      val beforeRollTokenPosition =game.currentPosition(token)

      Given("the player rolls a 4")
      val mockedDice = mockDiceRoll(4)
      When("they move their token")
      game.rollDiceForToken(token,mockedDice)

      Then("the token should move 4 spaces")
      game.currentPosition(token) shouldBe  (beforeRollTokenPosition + 4)

    }

  }



}
