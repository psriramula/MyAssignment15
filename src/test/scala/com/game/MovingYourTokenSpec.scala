package com.game

import org.scalatest.mockito.MockitoSugar
import org.scalatest.{FeatureSpec, GivenWhenThen}


/**
  * Created by prasadsriramula on 23/06/2017.
  */
class MovingYourTokenSpec extends FeatureSpec with GivenWhenThen  with MockitoSugar{



  feature("Token Can Move Across the Board") {
    scenario("Starting Game and token on square 1") {
      Given("the game is started")
      // Create a new Game

      When("the token is placed on the board")
      // place a new token on game board

      Then("the token is on square 1")
      // assert the current position of the token

    }

  }

}
