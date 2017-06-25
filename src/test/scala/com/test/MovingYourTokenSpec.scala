package com.test

import com.play.Game
import com.test.util.MockDice
import org.scalatest.mockito.MockitoSugar

import org.scalatest.{FeatureSpec, GivenWhenThen, Matchers}


/**
  * Created by prasadsriramula on 23/06/2017.
  */
class MovingYourTokenSpec extends FeatureSpec with GivenWhenThen with Matchers with MockitoSugar with MockDice{

  feature("Token Can Move Across the Board") {
    scenario("Starting Game and token on square 1") {
      Given("the game is started")
      val game = new Game()

      When("the token is placed on the board")
      val token = game.createNewToken

      Then("the token is on square 1")
      game.currentPosition(token) shouldBe 1

    }

    scenario("Token moved 3 spaces") {
      Given("the token is on square 1")
      val game = new Game
      val token = game.createNewToken
      game.currentPosition(token) shouldBe 1

      When("the token is moved 3 spaces")
      val mockedDice = mockDiceRoll(3)
      game.rollDiceForToken(token,mockedDice)

      Then("the token is on square 4")
      game.currentPosition(token) shouldBe 4
    }

  }

}
