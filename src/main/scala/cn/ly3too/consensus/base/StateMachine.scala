package cn.ly3too.consensus.base

import StateMachine._
import scala.concurrent.Future

/**
 * statemachine interface used by consensus system
 */
trait StateMachine {
    /**
     * apply read command
     * @param cmd command to be applied
     * @return
     */
    def applyRead(cmd: ReadCommand): Future[AnyRef]

    /**
     * apply write command
     * @param cmd write command
     * @return result
     */
    def applyWrite(cmd: WriteCommand): Future[AnyRef]

    def takeSnapShot: SnapShot

    def restoreSnapShot(snapShot: SnapShot)
}

object StateMachine {
    // command to be applied to statemachine and to be saved in log
    trait Command extends Serializable
    trait ReadCommand extends Command
    trait WriteCommand extends Command
}