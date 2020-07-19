package cn.ly3too.consensus.base

import Rpc._
import scala.concurrent.Future

trait Rpc {
    /**
     * call an rpc function
     * @param func rpc function with args
     * @return rpc return
     */
    def call(func: RpcFunction): Future[AnyRef]
}

object Rpc{
    trait RpcFunction
}
