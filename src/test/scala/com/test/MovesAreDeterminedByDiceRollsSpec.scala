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

      When("When the player rolls a die")
      val dice = new Dice
      game.rollDiceForToken(token, dice)

      Then("Then the result should be between 1-6 inclusive")
      val result = game.currentPosition(token)
      (result >= 1 && result <= 6) shouldBe true

    }

  }
}
