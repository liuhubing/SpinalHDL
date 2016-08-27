package spinal.tester.scalatest

import spinal.core._
import spinal.lib._
import spinal.lib.memory.sdram.{SdramCtrl, SdramDevices}


class SdramCtrlTesterCocotbBoot extends SpinalTesterCocotbBase {
  override def getName: String = "SdramCtrlTester"
  override def pythonTestLocation: String = "tester/src/test/python/spinal/SdramCtrlTester"
  override def createToplevel: Component = {
    val device = SdramDevices.MT48LC16M16A2
    SdramCtrl(device.config,device.timingGrade7.copy(tPOW = 5 us),2,UInt(8 bits)).setDefinitionName(getName)
  }
  override def backendConfig(config: SpinalConfig): SpinalConfig = config.copy(defaultClockDomainFrequency = FixedFrequency(133 MHz)).copy(dumpWave = null)
}