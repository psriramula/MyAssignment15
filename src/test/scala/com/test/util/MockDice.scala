package com.test.util

import com.play.Dice
import org.mockito.Mockito._
import org.scalatest.mockito.MockitoSugar

/**
  * Created by prasadsriramula on 23/06/2017.
  */

  trait MockDice {
    self: MockitoSugar =>

    def mockDiceRoll(diceRollValue: Int): Dice = {
      val mockDice = mock[Dice]
      when(mockDice.rollDice).thenReturn(diceRollValue)
      mockDice
    }

}
