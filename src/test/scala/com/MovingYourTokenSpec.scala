package com

import org.scalatest.mockito.MockitoSugar
import org.scalatest.{FeatureSpec, GivenWhenThen, Matchers}


/**
  * Created by prasadsriramula on 23/06/2017.
  */
class MovingYourTokenSpec extends FeatureSpec with GivenWhenThen with Matchers{



  feature("Token Can Move Across the Board") {
    scenario("Starting Game and token on square 1") {
      Given("the game is started")
      val game = new Game()

      When("the token is placed on the board")
      val token = game.createNewToken

      Then("the token is on square 1")
      game.currentPosition(token) shouldBe 1

    }

  }

}
