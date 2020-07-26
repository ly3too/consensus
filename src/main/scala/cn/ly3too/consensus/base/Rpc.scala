package cn.ly3too.consensus.base

import Rpc._
import scala.concurrent.Future

trait RpcClient {
    /**
     * call an rpc function
     * @param func rpc function with args
     * @return rpc return
     */
    def call(func: RpcFunction): Future[AnyRef]
}

trait RpcService {
    /**
     *
     * @param func rpc service provided by rpc server
     * @return
     */
    def onRpc(func: RpcFunction): AnyRef
}

object Rpc{
    trait RpcFunction
}
